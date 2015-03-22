package com.ganbatte.ctci.ch0.testSuites;

import static com.ganbatte.ctci.ch0.Solutions.findStartIndex;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FindStartIndexTest {
	@Test
	public void testNullArray() {
		assertEquals(-1, findStartIndex(null));		
	}
    
    @Test
	public void testEmptyArray() {
        assertEquals(-1, findStartIndex(new int[]{}));
    }
    
    @Test
	public void testSingleArray() {
        assertEquals(0, findStartIndex(new int[]{ 100 }));
    }
    
    @Test
	public void testTwoReversedArray() {
        assertEquals(1, findStartIndex(new int[]{ 2, 1 }));
    }
    
    @Test
	public void testTwoSortedArray() {
        assertEquals(0, findStartIndex(new int[]{ 1, 2 }));
    }
    
    @Test
	public void testRotatedOnceArray() {
        assertEquals(4, findStartIndex(new int[]{ 2, 3, 4, 5, 1 }));
    }
    
    @Test
	public void testRotatedThreeTimesArray() {
        assertEquals(2, findStartIndex(new int[]{ 5, 4, 1, 2, 3 }));
    }
    
    @Test
	public void testRotatedFiveTimesArray() {
        assertEquals(0, findStartIndex(new int[]{ 1, 2, 3, 4, 5 }));
    }
}