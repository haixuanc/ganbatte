package com.ganbatte.ctci.ch0;

import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Collections;

/**
 * P.54
 */
public class CurrentMedianTracker {
	Queue<Integer> left, right;

	public CurrentMedianTracker() {
		super();
		// A max-heap
		left = new PriorityQueue<>(16, Collections.reverseOrder());
		// A min-heap
		right = new PriorityQueue<>();
	}

	public int next(int n) {
		if (left.isEmpty()) {
			left.offer(n);
			return n;
		}
		if (n > left.peek()) {
			right.offer(n);
		} else {
			left.offer(n);
		}
		if (right.size() - left.size() == 2) {
			left.offer(right.poll());
		} else if (left.size() - right.size() == 2) {
			right.offer(left.poll());
		}
		if (left.size() - right.size() >= 0) {
			return left.peek();
		} else {
			return right.peek();
		}
	}
}
