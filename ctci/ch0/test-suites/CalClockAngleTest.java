package com.ganbatte.ctci.ch0.testSuites;

import static com.ganbatte.ctci.ch0.Solutions.calClockAngle;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalClockAngleTest {
	@Test
	public void test12h00() {
		assertEquals(0, calClockAngle(12, 0));
	}

	@Test
	public void test03h00() {
		assertEquals(90, calClockAngle(3, 0));
	}

	@Test
	public void test09h00() {
		assertEquals(90, calClockAngle(9, 0));
	}

	@Test
	public void test06h00() {
		assertEquals(180, calClockAngle(6, 0));
	}

	@Test
	public void test12h15() {
		assertEquals(83, calClockAngle(12, 15));
	}
}
