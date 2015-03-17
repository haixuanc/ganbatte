package com.ganbatte.ctci.ch0.testSuites;

import com.ganbatte.ctci.ch0.Solutions;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalClockAngleTest {
	@Test
	public void testTwelveOClock() {
		assertEquals(Solutions.calClockAngle(12, 0), 0);
	}
}
