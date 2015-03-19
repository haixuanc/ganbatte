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
}
