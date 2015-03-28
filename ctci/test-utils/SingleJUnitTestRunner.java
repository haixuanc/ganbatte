package com.ctci.testUtils;

import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * A custom JUnit test runner that can execute a single test method in a test
 * class.
 */
public class SingleJUnitTestRunner {
	private static final float MS = 0.001F;

	public static void main(String[] args) throws ClassNotFoundException {
		String[] classAndMethod = args[0].split("#");
		Request request = Request.method(Class.forName(classAndMethod[0]), 
				classAndMethod[1]);
		Result result = new JUnitCore().run(request);
		StringBuilder summary = new StringBuilder();
		summary
			.append("%nTime: " + MS * result.getRunTime())
			.append("%n%n" + (result.wasSuccessful() ? "OK" : "Failed"))
			.append(" (" + result.getRunCount() + " test" +
					(result.getRunCount() > 1 ? "s" : "") + ")%n%n");
		System.out.printf(summary.toString());
		for (Failure failure : result.getFailures()) {
			System.out.printf(failure.toString());
		}
	}
}
