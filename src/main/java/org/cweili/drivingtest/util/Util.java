/**
 * 
 */
package org.cweili.drivingtest.util;

/**
 * 
 * @author Cweili
 * @version 2013-4-2 上午10:34:48
 * 
 */
public class Util {

	private static final CharSequence CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public static String shortenInt(String string) {
		StringBuilder sb = new StringBuilder();
		int ori = Integer.parseInt(string);
		while (ori > 0) {
			sb.insert(0, CHARS.charAt(ori % CHARS.length()));
			ori /= CHARS.length();
		}
		return sb.toString();
	}

	public static String shortenInt(int integer) {
		StringBuilder sb = new StringBuilder();
		int ori = integer;
		while (ori > 0) {
			sb.insert(0, CHARS.charAt(ori % CHARS.length()));
			ori /= CHARS.length();
		}
		return sb.toString();
	}
}
