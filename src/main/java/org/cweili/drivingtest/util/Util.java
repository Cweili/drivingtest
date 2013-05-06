package org.cweili.drivingtest.util;

import java.util.Arrays;

/**
 * 共用方法
 * 
 * @author Cweili
 * @version 2013-4-12 上午10:25:59
 * 
 */
public class Util {

	private static final CharSequence CHARS = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz";

	/**
	 * 用字符串编码缩短Integer
	 * 
	 * @param string
	 *            Integer字符串
	 * @return 字符串
	 */
	public static String shortenInt(String string) {
		int integer = Integer.parseInt(string);
		return shortenInt(integer);
	}

	/**
	 * 用字符串编码缩短Integer
	 * 
	 * @param integer
	 *            Integer
	 * @return 字符串
	 */
	public static String shortenInt(int integer) {
		char[] c = new char[6];
		int tmp = integer;
		tmp = tmp > 0 ? tmp : -1 - tmp;
		int i = 6;
		while (tmp > 0 && i >= 0) {
			c[--i] = CHARS.charAt((int) tmp & 0x3f);
			tmp >>>= 6;
		}
		return new String(Arrays.copyOfRange(c, i, 6));
	}
}
