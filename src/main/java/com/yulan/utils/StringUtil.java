package com.yulan.utils;

import java.io.UnsupportedEncodingException;

/**
 * 乱码转换
 * @author Administrator
 *
 */
public class StringUtil {
	public static String getEncoding(String str) {
		String encode = "GB2312";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s = encode;
				return s;
			}
		} catch (Exception exception) {
		}
		encode = "ISO-8859-1";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s1 = encode;
				return s1;
			}
		} catch (Exception exception1) {
		}
		encode = "UTF-8";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s2 = encode;
				return s2;
			}
		} catch (Exception exception2) {
		}
		encode = "GBK";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s3 = encode;
				return s3;
			}
		} catch (Exception exception3) {
		}
		return "";
	}
	public static String getUtf8(String string) throws UnsupportedEncodingException {
		if (string==null){
			return "";
		}

		String utf8=new String(string.getBytes(getEncoding(string)),"gbk");

		return utf8;
	}

    public static String setUtf8(String string) throws UnsupportedEncodingException {
		if (string==null){
			return "";
		}
        System.out.println(getEncoding(string));
        System.out.println(string);
        String utf8=new String(string.getBytes("GBK"),"iso-8859-1");
        System.out.println(utf8);
        System.out.println();
        return utf8;
    }
}
