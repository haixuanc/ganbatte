package com.ctci.ch11.tests;

import static com.ctci.ch11.MergeSort.sort;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {
	@Test
	public void test1() {
		int[] sorted = new int[]{};
		int[] a = new int[]{};
		sort(a);
		assertArrayEquals(sorted, a);
	}

	@Test
	public void test2() {
		int[] sorted = new int[] { -100, -100, -100, -100 };
		int[] a = new int[] { -100, -100, -100, -100 };
		sort(a);
		assertArrayEquals(sorted, a);
	}

	@Test
	public void test3() {
		int[] sorted = new int[] { -6, 1, 2, 3, 4, 5 };
		int[] a = new int[] { 5, 4, 3, 2, 1, -6 };
		sort(a);
		assertArrayEquals(sorted, a);
	}
}
