#!/bin/bash

TESTEE=$1
TESTER="${TESTEE}Test"
JUNIT_PATH="/usr/share/java/junit-4.12.jar:/usr/share/java/hamcrest-core-1.3.jar"
SHARED_PATH="../shared"

javac -cp $JUNIT_PATH $SHARED_PATH/*.java
javac "${TESTEE}.java"
javac -cp .:$SHARED_PATH:$JUNIT_PATH "${TESTER}.java"

if [ "$2" = "" ]; then
	TEST_RUNNER="org.junit.runner.JUnitCore"
	TEST_TARGET=$TESTER
else
	TEST_RUNNER="SingleJUnitTestRunner"
	TEST_TARGET="${TESTER}#$2"
fi

java -cp .:$SHARED_PATH:$JUNIT_PATH $TEST_RUNNER $TEST_TARGET
