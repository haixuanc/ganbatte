#!/bin/bash

# ------------------------------------------------------------------------------
# Sample usages:
# $ ./test.sh Solutions QuestionOneSolution
# or
# $ ./test.sh QuestionTwoSolution
# or
# $ ./test.sh QuestionThreeSolution QuestionThreeSolution firstTestMethod
# ------------------------------------------------------------------------------

# The solution class to test
SOLUTION=$1

# The JUnit test class
if [ "$2" = "" ]; then
	TEST=$1Test
else
	TEST=$2Test
	# Test method contained in the JUnit test class
	METHOD=$3
fi

# Current chapeter
CHAPTER=ch0

# The project package
PROJECT_PKG=com.ctci
# The solution package
SOLUTIONS_PKG=$PROJECT_PKG.$CHAPTER
# The test suite package
TEST_PKG=$SOLUTIONS_PKG.testSuites
# Test utilities package
TEST_UTILS_PKG=$PROJECT_PKG.testUtils

# Path to Junit JARs
JUNIT_PATH=/usr/share/java/junit-4.12.jar:/usr/share/java/hamcrest-core-1.3.jar
# Path to test utility source code
TEST_UTILS_PATH=../test-utils
# Path to test suite source code
TEST_SUITE_PATH=./test-suites
# Path to the root directory of all compiled classes
DESTINATION_PATH=./bin

# Create the root directory to hold compiled classes
rm -rf $DESTINATION_PATH
mkdir $DESTINATION_PATH

# Compile test utility classes
javac -Xlint -d $DESTINATION_PATH -cp $JUNIT_PATH $TEST_UTILS_PATH/*.java
# Compile the solution class
javac -Xlint -d $DESTINATION_PATH $SOLUTION.java
# Compile the JUnit test class
javac -Xlint -d $DESTINATION_PATH -cp .:$JUNIT_PATH:$DESTINATION_PATH $TEST_SUITE_PATH/$TEST.java

# If no method specified, run all methods in the test class
if [ "$METHOD" = "" ]; then
	RUNNER=org.junit.runner.JUnitCore
	TASK=$TEST
# Run the test method only
else
	RUNNER=$TEST_UTILS_PKG.SingleJUnitTestRunner
	TASK=$TEST#$METHOD
fi

# Go! Run test(s)
java -cp .:$JUNIT_PATH:$DESTINATION_PATH $RUNNER $TEST_PKG.$TASK
