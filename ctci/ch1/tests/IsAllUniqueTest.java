package com.ctci.ch1.tests;

import static com.ctci.ch1.Solutions.isAllUnique;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IsAllUniqueTest {
	@Test
	public void shouldBeUnique1() {
		assertEquals(true, isAllUnique(""));
	}

	@Test
	public void shouldBeUnique2() {
		assertEquals(true, isAllUnique("ab123BCA c"));
	}

	/* @Test */
	/* public void shouldBeUnique3() { */
	/* 	assertEquals(true, isAllUnique("ab123BCA c中文")); */
	/* } */

	@Test
	public void shouldNotBeUnique1() {
		assertEquals(false, isAllUnique("adc123aBC"));
	}

	@Test
	public void shouldNotBeUnique2() {
		assertEquals(false, isAllUnique("     "));
	}

	/* @Test */
	/* public void shouldNotBeUnique3() { */
	/* 	assertEquals(false, isAllUnique("哈哈")); */
	/* } */
}
