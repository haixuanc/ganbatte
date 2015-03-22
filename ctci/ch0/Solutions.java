package com.ganbatte.ctci.ch0;

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
}
