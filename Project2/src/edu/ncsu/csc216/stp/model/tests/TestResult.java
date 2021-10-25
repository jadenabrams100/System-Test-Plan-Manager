package edu.ncsu.csc216.stp.model.tests;

public class TestResult {
	/** a string representing a passing test status */
	private static final String PASS = "PASS";
	/** a string representing a failing test status */
	private static final String FAIL = "FAIL";
	/** whether the test is passing or not */
	private boolean passing;
	/** the results of the test */
	private String actualResults;
	
	/**
	 * creates a new TestResult object
	 * @param passing if the test is passing or not
	 * @param actualResults the results of the test
	 */
	public TestResult(boolean passing, String actualResults) {
		
	}
	
	/**
	 * returns the results of the test
	 * @return the result
	 */
	public String getActualResults() {
		return null;
		
	}
	/**
	 * sets the results of the test
	 * @param actualResults the result to set
	 */
	private void setActualResults(String actualResults) {
		
	}
	
	/**
	 * tells if the test is passing or not
	 * @return if it is passing
	 */
	public boolean isPassing() {
		return false;
	}
	
	/**
	 * sets whether the test is passing or not
	 * @param isPassing if the test is passing
	 */
	private void setPassing(boolean isPassing) {
		
	}
	
	/**
	 * returns a string representation of the result
	 * @return the string of the result
	 */
	public String toString() {
		return null;
	}
}
