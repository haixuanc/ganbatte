package com.ctci.ch1.tests;

import static com.ctci.ch1.Solutions.reverse;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReverseTest {
	@Test
	public void test1() {
		assertEquals("", reverse(""));
	}
	@Test
	public void test2() {
		assertEquals("abcdefg", reverse(reverse("abcdefg")));
	}
}
