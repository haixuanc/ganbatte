package com.ctci.ch1;

import java.util.Arrays;

public class Solutions {
	/**
	 * Q1
	 */
	public static boolean isAllUnique(String s) {
		/* return Solutions.isAllUnique1(s); */
		/* return Solutions.isAllUnique2(s); */
		return Solutions.isAllUnique3(s);
	}

	/**
	 * Q1 solution 1
	 *
	 * Hashtable to keep track of seen chars, e.g. HashSet<Character>
	 * Note array is a special type of hashtable
	 * Use array if char set is small to save more space
	 * If array is used, O(size of char set) space, O(n) time
	 */
	public static boolean isAllUnique1(String s) {
		// Assume string contains ASCII chars only (one char = one byte)
		// 2^8 ASCII codes
		final int CODE_SIZE = 1 << 8;
		/* final int CODE_SIZE = 1 << 16; */
		if (s.length() > CODE_SIZE) {
			return false;
		}
		// Uninitialized array elements have a default value of 0 for integer,
		// null for object reference
		// Use a byte array to simulate a bit vector of CODE_SIZE bits
		byte[] charsUsed = new byte[CODE_SIZE >> 3];
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			int j = c >> 3;
			c = 1 << (c % 8);
			// Set bit only if c has never been used before
			charsUsed[j] ^= c;
			// If set failed, it means c has been used
			if ((charsUsed[j] & c) == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Q1 solution 2
	 *
	 * Double for-loop. O(1) space, O(n^2) time
	 */
	public static boolean isAllUnique2(String s) {
		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			for (int j = 0; j < i; j++) {
				if (s.charAt(j) == current) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Q1 solution 3
	 *
	 * Sort array first then go through array to see if any neighbor duplicates
	 * O(1) space if in-place sort is used e.g. quicksort
	 * O(nlgn) time on average e.g. quicksort
	 */
	public static boolean isAllUnique3(String s) {
		char[] sorted = s.toCharArray();
		Arrays.sort(sorted);
		for (int i = 1; i < sorted.length; i++) {
			if (sorted[i] == sorted[i-1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Q2
	 */
	public static String reverse(String original) {
		int i = 0;
		int j = original.length() - 1;
		char[] s = original.toCharArray();
		while (i++ < j--) {
			char tmp = s[i];
			s[i] = s[j];
			s[j] = tmp;
		}
		return new String(s);
	}
}
