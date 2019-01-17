/**
 * @Title: Pinyin4jUtil.java
 * @Package utils
 * @Description: TODO
 * @author 閮戜害姊?  zhengyiliang@rongyi.com
 * @date 2015骞?10鏈?8鏃? 涓嬪崍2:46:58
 * @version V1.0
 * Copyright (C),涓婃捣瀹规槗缃戠數瀛愬晢鍔℃湁闄愬叕鍙?
 */
package com.rongyi.core.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZhengYl
 *
 */
public class Pinyin4jUtil {

	/**
	 * 获取汉字对应的全拼拼音
	 *
	 * @param str
	 * @return
	 */
	public static String getPinYin(String str) {
		char[] t1 = null;
		t1 = str.toCharArray();
		String[] t2 = new String[t1.length];
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();

		t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);
		StringBuilder stringBuilder = new StringBuilder();
		int t0 = t1.length;
		try {
			for (int i = 0; i < t0; i++) {
				// 判断是否为汉字字符
				if (Character.toString(t1[i]).matches(
						"[\\u4E00-\\u9FA5]+")) {
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
					stringBuilder.append(t2[0]);
				} else
					stringBuilder.append(Character.toString(t1[i]));
			}
		} catch (BadHanyuPinyinOutputFormatCombination e1) {
			e1.printStackTrace();
		}
		return stringBuilder.toString();
	}

	/**
	 * 返回中文的首字母
	 *
	 * @param str
	 * @return
	 */
	public static String getShortPinYin(String str) {
		String convert = "";
		for (int j = 0; j < str.length(); j++) {
			char word = str.charAt(j);
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			if (pinyinArray != null) {
				convert += pinyinArray[0].charAt(0);
			} else {
				convert += word;
			}
		}
		return convert;
	}

	/**
	 * 汉字转换位汉语拼音首字母，英文字符不变，特殊字符丢失 支持多音字，生成方式如（长沙市长:cssc,zssz,zssc,cssz）
	 *汉字
	 * @param
	 * @return 拼音
	 */
	public static List<String> converterToFirstSpell(String chines) {
		StringBuffer pinyinName = new StringBuffer();
		char[] nameChar = chines.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < nameChar.length; i++) {
			if (nameChar[i] > 128) {
				// 取得当前汉字的所有全拼
				String[] strs = null;
				try {
					strs = PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat);
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (strs != null) {
					for (int j = 0; j < strs.length; j++) {
						// 取首字母
						pinyinName.append(strs[j].charAt(0));
						if (j != strs.length - 1) {
							pinyinName.append(",");
						}
					}
				}
				// else {
				// pinyinName.append(nameChar[i]);
				// }
			} else {
				pinyinName.append(nameChar[i]);
			}
			pinyinName.append(" ");
		}
		// return pinyinName.toString();
		return parseTheChineseByObject(discountTheChinese(pinyinName.toString()));
	}

	/**
	 * 汉字转换位汉语全拼，英文字符不变，特殊字符丢失
	 * 支持多音字，生成方式如（重当参:zhongdangcen,zhongdangcan,chongdangcen
	 * ,chongdangshen,zhongdangshen,chongdangcan）
	 *汉字
	 * @param
	 * @return 拼音
	 */
	public static List<String> converterToSpell(String chines) {
		StringBuffer pinyinName = new StringBuffer();
		char[] nameChar = chines.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < nameChar.length; i++) {
			if (nameChar[i] > 128) {
				// 取得当前汉字的所有全拼
				String[] strs = null;
				try {
					strs = PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat);
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (strs != null) {
					for (int j = 0; j < strs.length; j++) {
						pinyinName.append(strs[j]);
						if (j != strs.length - 1) {
							pinyinName.append(",");
						}
					}
				}
			} else {
				pinyinName.append(nameChar[i]);
			}
			pinyinName.append(" ");
		}
		// return pinyinName.toString();
		return parseTheChineseByObject(discountTheChinese(pinyinName.toString()));
	}

	/**
	 * 去除多音字重复数据
	 *
	 * @param theStr
	 * @return
	 */
	private static List<Map<String, Integer>> discountTheChinese(String theStr) {
		// 去除重复拼音后的拼音列表
		List<Map<String, Integer>> mapList = new ArrayList<Map<String, Integer>>();
		// 用于处理每个字的多音字，去掉重复
		Map<String, Integer> onlyOne = null;
		String[] firsts = theStr.split(" ");
		// 读出每个汉字的拼音
		for (String str : firsts) {
			onlyOne = new Hashtable<String, Integer>();
			String[] china = str.split(",");
			// 多音字处理
			for (String s : china) {
				Integer count = onlyOne.get(s);
				if (count == null) {
					onlyOne.put(s, new Integer(1));
				} else {
					onlyOne.remove(s);
					count++;
					onlyOne.put(s, count);
				}
			}
			mapList.add(onlyOne);
		}
		return mapList;
	}

	/**
	 * 解析并组合拼音，对象合并方案(推荐使用)
	 *
	 * @return
	 */
	private static List<String> parseTheChineseByObject(List<Map<String, Integer>> list) {
		Map<String, Integer> first = null; // 用于统计每一次,集合组合数据
		// 遍历每一组集合
		for (int i = 0; i < list.size(); i++) {
			// 每一组集合与上一次组合的Map
			Map<String, Integer> temp = new Hashtable<String, Integer>();
			// 第一次循环，first为空
			if (first != null) {
				// 取出上次组合与此次集合的字符，并保存
				for (String s : first.keySet()) {
					for (String s1 : list.get(i).keySet()) {
						String str = s + s1;
						temp.put(str, 1);
					}
				}
				// 清理上一次组合数据
				if (temp != null && temp.size() > 0) {
					first.clear();
				}
			} else {
				for (String s : list.get(i).keySet()) {
					String str = s;
					temp.put(str, 1);
				}
			}
			// 保存组合数据以便下次循环使用
			if (temp != null && temp.size() > 0) {
				first = temp;
			}
		}
		List<String> returnStr = new ArrayList<String>();
		if (first != null) {
			// 遍历取出组合字符串
			for (String str : first.keySet()) {
				returnStr.add(str);
			}
		}
		return returnStr;
	}

	public static void main(String[] args) {
		String str = "长沙市长 SDS tasdf";

		List<String> pinyin = Pinyin4jUtil.converterToSpell(str);
		System.out.println(str+" pin yin ："+pinyin);

		pinyin = Pinyin4jUtil.converterToFirstSpell(str);
		System.out.println(str+" short pin yin ："+pinyin);

//		str = "";
		System.out.println(getShortPinYin(str));
	}

	/**
	 * 将字符串中所有括号的内容去除
	 */
	public  static String tripBracket(String str) {
		Pattern pattern = Pattern.compile("[(\\uff08].*[)\\uff09]");
		Matcher matcher = pattern.matcher(str);
		while(matcher.find())
			str = matcher.replaceAll("");
		return str;
	}
}