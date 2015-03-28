package com.ctci.ch0.testSuites;

import com.ctci.ch0.CurrentMedianTracker;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CurrentMedianTrackerTest {
	@Test
	public void testOne() {
		CurrentMedianTracker tracker = new CurrentMedianTracker();
		assertEquals(1, tracker.next(1));		
	}

	@Test
	public void testTwo() {
		CurrentMedianTracker tracker = new CurrentMedianTracker();
		tracker.next(1);
		assertEquals(1, tracker.next(2));		
	}

	@Test
	public void testThree() {
		CurrentMedianTracker tracker = new CurrentMedianTracker();
		tracker.next(1);
		tracker.next(2);
		assertEquals(2, tracker.next(3));		
	}

	@Test
	public void testFour() {
		CurrentMedianTracker tracker = new CurrentMedianTracker();
		tracker.next(1);
		tracker.next(2);
		tracker.next(3);
		assertEquals(2, tracker.next(4));		
	}

	@Test
	public void testFive() {
		CurrentMedianTracker tracker = new CurrentMedianTracker();
		tracker.next(1);
		tracker.next(2);
		tracker.next(3);
		tracker.next(4);
		assertEquals(3, tracker.next(5));		
	}
}
