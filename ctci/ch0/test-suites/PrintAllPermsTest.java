package com.ganbatte.ctci.ch0.testSuites;

import static com.ganbatte.ctci.ch0.Solutions.getAllPerms;
import static com.ganbatte.ctci.ch0.Solutions.getAllPermsIter;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;

public class PrintAllPermsTest {
	@Test
	public void testA() {
		String[] expecteds = {"a"};
		String[] actuals = getAllPerms("a").toArray(new String[0]);
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testAb() {
		String[] expecteds = {"ab", "ba"};
		Arrays.sort(expecteds);
		String[] actuals = getAllPerms("ab").toArray(new String[0]);
		Arrays.sort(actuals);
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testAbc() {
		String[] expecteds = {"abc", "acb", "bac", "bca", "cab", "cba"};
		Arrays.sort(expecteds);
		String[] actuals = getAllPerms("abc").toArray(new String[0]);
		Arrays.sort(actuals);
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testIterA() {
		String[] expecteds = {"a"};
		String[] actuals = getAllPermsIter("a").toArray(new String[0]);
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testIterAb() {
		String[] expecteds = {"ab", "ba"};
		Arrays.sort(expecteds);
		String[] actuals = getAllPermsIter("ab").toArray(new String[0]);
		Arrays.sort(actuals);
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testIterAbc() {
		String[] expecteds = {"abc", "acb", "bac", "bca", "cab", "cba"};
		Arrays.sort(expecteds);
		String[] actuals = getAllPermsIter("abc").toArray(new String[0]);
		Arrays.sort(actuals);
		assertArrayEquals(expecteds, actuals);
	}
}
