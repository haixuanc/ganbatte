#!/bin/bash

# Chapter
CHAPTER="ch0"
# The containing class of the method to be tested
TESTEE_CLASS="Solutions"
# The method to be tested
TESTEE_METHOD=$1
# The test suite class
TEST_SUITE="${TESTEE_METHOD}Test"
TEST_METHOD=$2

# Project package
PROJECT_PKG="com.ganbatte.ctci"
# Solutions package
SOLUTIONS_PKG="${PROJECT_PKG}.${CHAPTER}"
# Test package
TEST_PKG="${SOLUTIONS_PKG}.testSuites"
# Test utilities package
TEST_UTILS_PKG="${PROJECT_PKG}.testUtils"
# Path to Junit JARs
JUNIT_PATH="/usr/share/java/junit-4.12.jar:/usr/share/java/hamcrest-core-1.3.jar"
# Path to test utility source code
TEST_UTILS_PATH="../test-utils"
# Path to test suite source code
TEST_SUITE_PATH="./test-suites"
# Path to root directory of all compiled classes
COMPILED_PATH="./bin"

# Create the root directory to hold compiled classes
rm -rf $COMPILED_PATH
mkdir $COMPILED_PATH
# Compiled test utility classes
javac -Xlint -d $COMPILED_PATH -cp $JUNIT_PATH $TEST_UTILS_PATH/*.java
# Compiled class to be tested
javac -Xlint -d $COMPILED_PATH ${TESTEE_CLASS}.java
# Compiled JUnit test class
javac -Xlint -d $COMPILED_PATH -cp .:$JUNIT_PATH:$TEST_UTILS_PATH:$COMPILED_PATH ${TEST_SUITE_PATH}/${TEST_SUITE}.java

# If no test method specified, run all tests in test class
if [ "$TEST_METHOD" = "" ]; then
	TEST_RUNNER="org.junit.runner.JUnitCore"
	TEST_TASK=$TEST_SUITE
# Run the specified test in test class
else
	TEST_RUNNER="${TEST_UTILS_PKG}.SingleJUnitTestRunner"
	TEST_TASK="${TEST_SUITE}#$TEST_METHOD"
fi

# Go! Run test(s)
java -cp .:$JUNIT_PATH:$COMPILED_PATH $TEST_RUNNER ${TEST_PKG}.$TEST_TASK