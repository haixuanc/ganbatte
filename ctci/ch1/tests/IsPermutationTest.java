package com.ctci.ch1.tests;

import static com.ctci.ch1.Solutions.isPermutation;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IsPermutationTest {
	@Test
	public void test1() {
		assertEquals(true, isPermutation("", ""));
	}

	@Test
	public void test2() {
		assertEquals(true, isPermutation("dcba", "abcd"));
	}

	@Test
	public void test3() {
		assertEquals(true, isPermutation("112233", "123123"));
	}

	@Test
	public void test4() {
		assertEquals(false, isPermutation("abccd", "aabde"));
	}

}
