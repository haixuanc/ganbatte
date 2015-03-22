package com.ganbatte.ctci.ch0.testSuites;

import static com.ganbatte.ctci.ch0.Solutions.isMsgMadeFromMagzine;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IsMsgMadeFromMagzineTest {
	@Test
	public void testEmptyMagzine() {
		assertEquals(false, isMsgMadeFromMagzine("hello", ""));		
	}

	@Test
	public void testFalse() {
		assertEquals(false, isMsgMadeFromMagzine("zello", "helloworld"));
	}

	@Test
	public void testTrue() {
		assertEquals(true, isMsgMadeFromMagzine("wello", "helloworld"));
	}
}