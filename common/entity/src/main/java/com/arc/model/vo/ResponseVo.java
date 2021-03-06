package com.arc.model.vo;

import com.arc.enums.ContextCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 向前段统一返回数据，该类对结果做了统一封装
 *
 * @param <T>
 */
@Getter
@Setter
@ToString
public class ResponseVo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private int code;
    /**
     * 状态信息
     */
    private String msg;

//    private boolean success;

    //有效数据
    private T data;

    //构造器
    public ResponseVo() {
    }

    public ResponseVo(T data) {
        this.data = data;
    }

    public ResponseVo(ContextCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.data = null;
    }

    public ResponseVo(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    //success方法
    public static <T> ResponseVo<T> success() {
        return new ResponseVo<T>(ContextCode.SUCCESS.getCode(), ContextCode.SUCCESS.getMsg(), null);
    }

    public static <T> ResponseVo<T> success(T data) {
        return new ResponseVo<T>(ContextCode.SUCCESS.getCode(), ContextCode.SUCCESS.getMsg(), data);
    }

    public static <T> ResponseVo<T> success(ContextCode enumCode) {
        return new ResponseVo<T>(enumCode.getCode(), enumCode.getMsg(), null);
    }

    public static <T> ResponseVo<T> success(ContextCode enumCode, T data) {
        return new ResponseVo<T>(enumCode.getCode(), enumCode.getMsg(), data);
    }

    //失败
    public static <T> ResponseVo<T> failure(ContextCode enumCode) {
        return new ResponseVo<T>(enumCode.getCode(), enumCode.getMsg(),  null);
    }

    public static <T> ResponseVo<T> failure(T data) {
        return new ResponseVo<T>(ContextCode.FAILURE.getCode(), ContextCode.FAILURE.getMsg(),  data);
    }

    public static <T> ResponseVo<T> failure(ContextCode enumCode, T data) {
        return new ResponseVo<T>(enumCode.getCode(), enumCode.getMsg(),  data);
    }

    public static ResponseVo failure() {
        return new ResponseVo(ContextCode.FAILURE);
    }

//
//    /**
//     * 处理微服务的返回结果
//     *
//     * @param response
//     * @param <T>
//     * @return
//     */
//    public static <T> ResponseVo<T> buildResponse(MicroServiceResponse<T> response) {
//        if (response == null) {
//            throw new BusinessRuntimeException(ContextCode.NULL_RESPONSE);
//        }
//        return StringUtils.equals(response.getCode(), ContextCode.SUCCESS.getCode()) ? ResponseVo.success(response.getData()) : ResponseVo.failure(ContextCode.buildFailure(response.getCode(), response.getMsg()));
//    }
//
//    /**
//     * 处理微服务的返回结果（类型转换）
//     *
//     * @param response
//     * @param <T>
//     * @return
//     */
//    public static <T> ResponseVo<T> convertResponse(MicroServiceResponse<?> response, Class<T> target) {
//        if (response == null || target == null) {
//            throw new BusinessRuntimeException(ContextCode.NULL_RESPONSE);
//        }
//        T instance = BeanCopierUtil.copyBean(response.getData(), target);
//        return StringUtils.equals(response.getCode(), ContextCode.SUCCESS.getCode()) ? ResponseVo.success(instance) : ResponseVo.failure(ContextCode.buildFailure(response.getCode(), response.getMsg()));
//    }
//
//    /**
//     * 处理微服务的返回结果（分页类型转换）
//     *
//     * @param response
//     * @param <T>
//     * @return
//     */
//    public static <T> ResponseVo<PageResponse<T>> convertPageResponse(MicroServiceResponse<? extends PageResponse> response, Class<T> target) {
//        if (response == null || target == null) {
//            throw new BusinessRuntimeException(ContextCode.NULL_RESPONSE);
//        }
//        if (response.getData() == null) {
//            throw new BusinessRuntimeException(ContextCode.PAGE_NULL_RESPONSE);
//        }
//        List<T> list = BeanCopierUtil.copyList(response.getData().getData(), target);
//        PageResponse<T> instance = new PageResponse<>();
//        instance.setData(list);
//        instance.setTotalPages(response.getData().getTotalPages());
//        instance.setTotalElements(response.getData().getTotalElements());
//        return StringUtils.equals(response.getCode(), ContextCode.SUCCESS.getCode()) ? ResponseVo.success(instance) : ResponseVo.failure(ContextCode.buildFailure(response.getCode(), response.getMsg()));
//    }
//
//    /**
//     * 处理微服务的返回结果（列表类型转换）
//     *
//     * @param response
//     * @param <T>
//     * @return
//     */
//    public static <T> ResponseVo<List<T>> convertListResponse(MicroServiceResponse<? extends List> response, Class<T> target) {
//        if (response == null || target == null) {
//            throw new BusinessRuntimeException(ContextCode.NULL_RESPONSE);
//        }
//        List<T> instance = BeanCopierUtil.copyList(response.getData(), target);
//        return StringUtils.equals(response.getCode(), ContextCode.SUCCESS.getCode()) ? ResponseVo.success(instance) : ResponseVo.failure(ContextCode.buildFailure(response.getCode(), response.getMsg()));
//    }
//
//    /**
//     * 处理微服务的返回结果（含参数名映射列表类型转换）
//     *
//     * @param response
//     * @param <T>
//     * @return
//     */
//    public static <T> ResponseVo<List<T>> convertListResponse(MicroServiceResponse<? extends List> response, Class<T> target, Map<String, String> relation) {
//        if (response == null || target == null) {
//            throw new BusinessRuntimeException(ContextCode.NULL_RESPONSE);
//        }
//        List<T> instance = BeanCopierUtil.copyList(response.getData(), target, relation);
//        return StringUtils.equals(response.getCode(), ContextCode.SUCCESS.getCode()) ? ResponseVo.success(instance) : ResponseVo.failure(ContextCode.buildFailure(response.getCode(), response.getMsg()));
//    }

}
