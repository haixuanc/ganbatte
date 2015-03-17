#!/bin/bash

# The containing class of the method to be tested
TESTEE_CLASS="Solutions"
# The method to be tested
TESTEE_METHOD=$1
# The test suite class
TEST_SUITE="${TESTEE_METHOD}Test"
# Path to Junit JARs
JUNIT_PATH="/usr/share/java/junit-4.12.jar:/usr/share/java/hamcrest-core-1.3.jar"
# Path to test utility source code
TEST_UTILS_PATH="../test-utils"
# Path to test suite source code
TEST_SUITE_PATH="./test-suites"
# Path to root directory of all compiled classes
CLASSES_PATH="./classes"

# Create the root directory to hold compiled classes
rm -rf $CLASSES_PATH
mkdir $CLASSES_PATH
# Compiled test utility classes
javac -Xlint -d $CLASSES_PATH -cp $JUNIT_PATH $TEST_UTILS_PATH/*.java
# Compiled class to be tested
javac -Xlint -d $CLASSES_PATH ${TESTEE_CLASS}.java
# Compiled JUnit test class
javac -Xlint -d $CLASSES_PATH -cp .:$JUNIT_PATH:$TEST_UTILS_PATH:$CLASSES_PATH ${TEST_SUITE_PATH}/${TEST_SUITE}.java

# If no test method specified, run all tests in test class
if [ "$2" = "" ]; then
	TEST_RUNNER="org.junit.runner.JUnitCore"
	TEST_TARGET=$TEST_SUITE
# Run the specified test in test class
else
	TEST_RUNNER="SingleJUnitTestRunner"
	TEST_TARGET="${TEST_SUITE}#$2"
fi

# Go! Run test(s)
java -cp .:$JUNIT_PATH:$TEST_UTILS_PATH:$CLASSES_PATH $TEST_RUNNER $TEST_TARGET
