package edu.ncsu.csc216.stp.model.tests;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.ILog;

/**
 * Contains information about each individual test case.
 */
public class TestCase {
	/** Stores the Test Case ID */
	String testCaseId;
	/** Stores the Test Case Type */
	String testType;
	/** Stores the Test Case description */
	String testDescription;
	/** Stores the expected Test results */
	String expectedResults;
	/** Stores all Test results */
	ILog<TestResult> results;
	/** Contains the Test Plan that the Test Case belongs to */
	TestPlan plan;

	/**
	 * Constructs a new Test Case object
	 * @param testCaseId the Test Case ID
	 * @param testType the Test Case type
	 * @param testDescription the Test Case description
	 * @param expectedResults the expected results of the Test Case
	 */
	public TestCase(String testCaseId, String testType, String testDescription, String expectedResults) {
		// TODO: Auto-generated method stub
	}

	/**
	 * Creates a Test Result from the given values and adds it to the end of the Test Results log.
	 * @param passing true if the test is passing, false otherwise.
	 * @param result the results of the test run.
	 * @throws IllegalArgumentException if the TestResult cannot be constructed.
	 */
	public void addTestResult(boolean passing, String result) {
		// TODO: Auto-generated method stub
	}

	/**
	 * Gets the Test Case ID
	 * @return the Test Case ID
	 */
	public String getTestCaseId() {
		return testCaseId;
	}

	/**
	 * Gets the Test Case Type
	 * @return the Test Case type
	 */
	public String getTestType() {
		return testType;
	}

	/**
	 * Gets the Test Case Description
	 * @return the Test Case description
	 */
	public String getTestDescription() {
		return testDescription;
	}

	/**
	 * Gets the expected Test Case results
	 * @return the Expected Results
	 */
	public String getExpectedResults() {
		return expectedResults;
	}

	/**
	 * Gets all Results for the Test Case
	 * @return a Log of all Test Case results.
	 */
	public ILog<TestResult> getResults() {
		return results;
	}

	/**
	 * Gets the current Test Plan that the Case belongs to
	 * @return the Current Test Plan that the Case belongs to
	 */
	public TestPlan getTestPlan() {
		return plan;
	}

	/**
	 * Returns whether or not the Test Case is passing
	 * If there are no Test Results in the log, the test is considered failing.
	 * @return true if the Test Case is passing, false otherwise.
	 */
	public boolean isTestCasePassing() {
		return false;
	}

	/**
	 * Gets the status of the Test Case
	 * @return "PASS" if the test is passing, "FAIL" if the test is failing.
	 */
	public String getStatus() {
		return null;
	}

	/**
	 * Returns a string representation of the testResults Log.
	 * @return a String version of the Test Result log, with a leading '-' appended to the start of each Test Result.
	 */
	public String getActualResultsLog() {
		return null;
	}

	/**
	 * Sets the testPlan field to the given TestPlan.
	 * @param testPlan the Test Plan to use.
	 * @throws IllegalArgumentException if the parameter is null.
	 */
	public void setTestPlan(TestPlan testPlan) {
		// TODO: Auto-generated method stub
	}

	/**
	 * Returns a string representation of the TestCase for printing to a file.
	 * @return a String version of the Test Case.
	 */
	public String toString() {
		return null;
	}
}
