package edu.ncsu.csc216.stp.model.tests;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.ILog;
import edu.ncsu.csc216.stp.model.util.Log;

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
		setTestCaseId(testCaseId);
		setTestType(testType);
		setTestDescription(testDescription);
		setExpectedResults(expectedResults);
		results = new Log<TestResult>();
		plan = null;
	}

	/**
	 * Creates a Test Result from the given values and adds it to the end of the Test Results log.
	 * @param passing true if the test is passing, false otherwise.
	 * @param result the results of the test run.
	 * @throws IllegalArgumentException if the TestResult cannot be constructed.
	 */
	public void addTestResult(boolean passing, String result) {
		try {
			results.add(new TestResult(passing, result));
		} catch(Exception e) {
			throw new IllegalArgumentException("Invalid test results.");
		}
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
		if(results.size() == 0) {
			return false;
		}
		return results.get(results.size()-1).isPassing();
	}

	/**
	 * Gets the status of the Test Case
	 * @return "PASS" if the test is passing, "FAIL" if the test is failing.
	 */
	public String getStatus() {
		if(isTestCasePassing()) {
			return TestResult.PASS;
		}
		return TestResult.FAIL;
	}

	/**
	 * Returns a string representation of the testResults Log.
	 * @return a String version of the Test Result log, with a leading '-' appended to the start of each Test Result.
	 */
	public String getActualResultsLog() {
		String rtn = "";
		for(int i = 0; i < results.size(); i++) {
			rtn = rtn + "-" + results.get(i).toString() + "\n";
		}
		return rtn;
	}

	/**
	 * Sets the testPlan field to the given TestPlan.
	 * @param testPlan the Test Plan to use.
	 * @throws IllegalArgumentException if the parameter is null.
	 */
	public void setTestPlan(TestPlan testPlan) {
		if(testPlan == null) {
			throw new IllegalArgumentException("Invalid test plan");
		}
		plan = testPlan;
	}

	/**
	 * Returns a string representation of the TestCase for printing to a file.
	 * @return a String version of the Test Case.
	 */
	public String toString() {
		return "# " + testCaseId + "," + testType + "\n" + "* " + testDescription + "\n" + "* " + expectedResults + "\n" + getActualResultsLog();
	}
	
	/**
	 * sets the test case id
	 * @param id the id to set
	 * @throws IllegalArgumentException if id is null or empty
	 */
	private void setTestCaseId(String id) {
		if(id == null || id.length() == 0) {
			throw new IllegalArgumentException("Invalid Test information");
		}
		testCaseId = id;
	}
	
	/**
	 * sets the type
	 * @param t the type to set
	 * @throws IllegalArgumentException if t is null or empty
	 */
	private void setTestType(String t) {
		if(t == null || t.length() == 0) {
			throw new IllegalArgumentException("Invalid Test information");
		}
		testType = t;
	}
	
	/**
	 * sets the test description 
	 * @param d the description to set
	 * @throws IllegalArgumentException if d is null or empty
	 */
	private void setTestDescription(String d) {
		if(d == null || d.length() == 0) {
			throw new IllegalArgumentException("Invalid Test information");
		}
		testDescription = d;
	}
	
	/**
	 * sets the test expected results
	 * @param r the result to set
	 * @throws IllegalArgumentException if r is null or invalid
	 */
	private void setExpectedResults(String r) {
		if(r == null || r.length() == 0) {
			throw new IllegalArgumentException("Invalid Test information");
		}
		expectedResults = r;
	}
}
