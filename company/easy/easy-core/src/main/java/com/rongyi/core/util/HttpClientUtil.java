package com.rongyi.core.util;

import net.sf.json.JSONObject;
import org.apache.commons.collections.MapUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created With IntelliJ IDEA.
 * User: WUH
 * Date:  2017/7/4
 */
public class HttpClientUtil {

    private static final int CONNECTION_TIME_OUT = 10000;
    private static final int DEFAULT_SO_TIME = 10000;
    private static final String ENCODING = "UTF-8";
    private static final String CONTENT_JSON = "application/json";
    private static final String CONTENT_FORM = "application/x-www-form-urlencoded";
    private static PoolingHttpClientConnectionManager connMgr;
    private static RequestConfig requestConfig;

    static {
        // 设置连接池
        connMgr = new PoolingHttpClientConnectionManager();
        // 设置连接池大小
        connMgr.setMaxTotal(100);
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());

        requestConfig = RequestConfig.custom()
            .setConnectTimeout(CONNECTION_TIME_OUT)        // 设置连接超时
            .setSocketTimeout(DEFAULT_SO_TIME)         // 设置读取超时
            .setConnectionRequestTimeout(DEFAULT_SO_TIME)   // 设置从连接池获取连接实例的超时
            .setStaleConnectionCheckEnabled(true)      // 在提交请求之前 测试连接是否可用
            .build();
    }

    /**
     * https请求，参数格式：json
     * @param url url
     * @param map https参数
     * @return 返回值
     */
    public static String sendHttpsPostJson(String url, Map<String, Object> map) {
        try{
            //创建httpclient对象
            CloseableHttpClient httpClient = getHttpsConnection();
            //执行请求操作，并拿到结果（同步阻塞）
            HttpPost httpPost = getJsonPost(url, map);
            //获取httpPost对象
            return getResponse(httpClient, httpPost);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    /**
     *
     * @param url url
     * @param map 请求参数
     * @return 返回值
     */
    public static String sendHttpPostForm(String url, Map<String, Object> map) {
        try{
            //创建httpclient对象
            CloseableHttpClient client = getHttpConnection();
            //获取httpPost对象
            HttpPost httpPost = getFormPost(url, map);
            //执行请求操作，并拿到结果（同步阻塞）
            return getResponse(client, httpPost);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    /**
     *
     * @param url 访问路径
     * @param map 请求参数
     * @return 返回结果
     */
    public static String sendHttpPostJson(String url, Map<String, Object> map) {
        try{
            //创建httpclient对象
            CloseableHttpClient client = getHttpConnection();
            //获取httpPost对象
            HttpPost httpPost = getJsonPost(url, map);
            //执行请求操作，并拿到结果（同步阻塞）
            return getResponse(client, httpPost);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static String sendHttpGet(String url, Map<String, Object> map){
        try{

            CloseableHttpClient client = getHttpConnection();
            HttpGet httpGet = decorateGetMethod(url, map);
            return getResponse(client, httpGet);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    private static HttpGet decorateGetMethod(String url, Map<String, Object> params) throws Exception{
        //装填参数
        List<NameValuePair> pairs = new ArrayList<>();

        if (MapUtils.isNotEmpty(params)) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if(entry.getValue() != null){
                    pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
                }
            }
            url = url  + "&" + URLEncodedUtils.format(pairs, ENCODING);
        }
        //创建post方式请求对象
        return new HttpGet(url);
    }

    private static HttpPost getFormPost(String url, Map<String, Object> params) throws Exception{
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        //装填参数
        List<NameValuePair> pairs = new ArrayList<>();

        if (MapUtils.isNotEmpty(params)) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }
        }
        URLEncodedUtils.format(pairs, ENCODING);

//        httpPost.setEntity(new UrlEncodedFormEntity(pairs, ENCODING));
        httpPost.setHeader("Content-type", CONTENT_FORM);
        return httpPost;
    }

    private static HttpPost getJsonPost(String url, Map<String, Object> params) throws Exception{
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity;
        //装填参数
        if(MapUtils.isNotEmpty(params)){
            entity = new StringEntity(JSONObject.fromObject(params, JsonUtil.rectifyJsonConfig()).toString(), ENCODING);//解决中文乱码问题
        }else{
            entity = new StringEntity("");
        }
        entity.setContentEncoding(ENCODING);
        entity.setContentType(CONTENT_JSON);
        httpPost.setEntity(entity);
        return httpPost;
    }

    private static String getResponse(CloseableHttpClient client, HttpGet httpGet) throws Exception{
        String result = "";
        //执行请求操作，并拿到结果（同步阻塞）
        try(CloseableHttpResponse response = client.execute(httpGet)){
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    //按指定编码转换结果实体为String类型
                    result = EntityUtils.toString(entity, ENCODING);
                }
                EntityUtils.consume(entity);
                return result;
            }
        }
        return null;
    }

    private static String getResponse(CloseableHttpClient client, HttpPost httpPost) throws Exception{
        String result = "";
        //执行请求操作，并拿到结果（同步阻塞）
        try(CloseableHttpResponse response = client.execute(httpPost)){
            //获取结果实体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                //按指定编码转换结果实体为String类型
                result = EntityUtils.toString(entity, ENCODING);
            }
            EntityUtils.consume(entity);
            return result;
        }
    }

    private static CloseableHttpClient getHttpConnection(){
        return HttpClients.custom()           //创建builder
            .setConnectionManager(connMgr)                   //设置连接管理
            .setDefaultRequestConfig(requestConfig)     //设置请求配置
            .build();
    }

    private static CloseableHttpClient getHttpsConnection() {
        return HttpClients.custom()           //创建builder
            .setSSLSocketFactory(createSSLConnSocketFactory())    //设置Factory
            .setConnectionManager(connMgr)                   //设置连接管理
            .setDefaultRequestConfig(requestConfig)     //设置请求配置
            .build();
    }

    private static SSLConnectionSocketFactory createSSLConnSocketFactory() {
        SSLConnectionSocketFactory sslsf = null;
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {

                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }

                @Override
                public void verify(String host, SSLSocket ssl) throws IOException {
                }

                @Override
                public void verify(String host, X509Certificate cert) throws SSLException {
                }

                @Override
                public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
                }
            });
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return sslsf;
    }

    private HttpClientUtil(){}
}
