package com.ctci.ch0;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Solutions {
	/**
	 * P.52
	 */
	public static int calClockAngle(int hour, int min) {
		hour = hour % 12;
		// Expression int/int will truncate
		// Java requires explicit type conversion int <- int (double x)
		int hAngle = hour * (360 / 12) + min / 2;
		int mAngle = min * (360 / 60);
		int diff = Math.abs(hAngle - mAngle);
		return diff > 180 ? diff % 180 : diff;
	}
    
	/**
	 * P.53
	 */
	public static int findStartIndex(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}
		return findStartIndex(a, 0, a.length - 1);
	}

	private static int findStartIndex(int[] a, int start, int end) {
		if (start == end) {
			return start;
		}
		int mid = (start + end) / 2;
		if (a[start] > a[mid]) {
			return findStartIndex(a, start+1, mid);
		}
		if (a[mid] > a[end]) {
			return findStartIndex(a, mid+1, end);
		}
		return start;
	}

	/**
	 * P.53
	 */
	public static boolean isMsgMadeFromMagzine(String msg, String magzine) {
		if (msg.length() > magzine.length()) {
			return false;
		}
		// If the size of character set is small, we can use an array and encode 
		// characters into integers to save space
		Map<Character, Integer> charFreq = getCharFreq(magzine);
		for (int i = 0; i < msg.length(); i++) {
			char c = msg.charAt(i);
			if (!charFreq.keySet().contains(c)) {
				return false;
			}
			int left = charFreq.get(c) - 1;
			if (left < 0) {
				return false;
			}
			charFreq.put(c, left);
		}
		return true;
	}

	private static Map<Character, Integer> getCharFreq(String s) {
		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				continue;
			}
			if (!m.keySet().contains(c)) {
				m.put(c, 1);
			} else {
				m.put(c, m.get(c) + 1);
			}
		}
		return m;
	}

	/**
	 * P.54
	 */
	public static void printAllPerms(String chars) {
		List<String> perms = getAllPerms(chars);
		for (String p : perms) {
			System.out.println(p);
		}
	}

	/**
	 * A recursive solution
	 */
	public static List<String> getAllPerms(String chars) {
		List<String> perms = new ArrayList<>();
		if (chars.length() <= 1) {
			perms.add(chars);
			return perms;
		}
		char c = chars.charAt(0);
		List<String> subPerms = getAllPerms(chars.substring(1));
		for (String subPerm : subPerms) {
			perms.addAll(getPerms(c, subPerm));
		}
		return perms;
	}

	/**
	 * An iterative solution
	 */
	public static List<String> getAllPermsIter(String chars) 
		throws IllegalArgumentException {
		if (chars.length() == 0) {
			throw new IllegalArgumentException();
		}
		List<String> finals = new ArrayList<>();
		List<String> temps;
		for (int i = 0; i < chars.length(); i++) {
			temps = finals;
			char c = chars.charAt(i);
			if (temps.isEmpty()) {
				finals.add(c + "");
				continue;
			}
			finals = new ArrayList<String>();
			for (String temp : temps) {
				finals.addAll(getPerms(c, temp));
			}
			temps.clear();
		}
		return finals;
	}

	private static List<String> getPerms(char c, String s) {
		List<String> perms = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			String before = s.substring(0, i);
			String after = s.substring(i);
			perms.add(before + c + after);
		}
		perms.add(s + c);
		return perms;
	}
}
