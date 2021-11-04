package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Test Plan Object.
 * Stores Test Cases and Plan information
 * @author Henry Kon
 * @author Jaden Abrams
 */
public class TestPlan extends AbstractTestPlan implements Comparable<TestPlan> {
	/**
	 * Constructs a Test Plan with the given name
	 * @param testPlanName the Name of the Test Plan
	 * @throws IllegalArgumentException if the Test Plan name matches the name of the Failing Test List (case insensitive).
	 */
	public TestPlan(String testPlanName) {
		super(testPlanName);
	}

	/**
	 * Returns a 2D String array where the first column is the test case id,
	 * the second column is the test type, and the third column is the status (“PASS” or “FAIL”).
	 * @return a 2D String Array containing Test Case data.
	 */
	public String[][] getTestCasesAsArray() {
		String[][] arrayBuilder = new String[getTestCases().size()][3];
		for (int i = 0; i < getTestCases().size(); i++) {
			arrayBuilder[i][0] = getTestCases().get(i).getTestCaseId();
			arrayBuilder[i][1] = getTestCases().get(i).getTestType();
			arrayBuilder[i][2] = getTestCases().get(i).getStatus();
		}
		return arrayBuilder;
	}

	/**
	 * Sets the name of the Test Plan
	 * Overridden to add check for if the name matches "Failing Tests" case insensitive
	 * @param testPlanName the new name of the Test Plan
	 */
	@Override
	public void setTestPlanName(String testPlanName) {
		if("Failing Tests".equalsIgnoreCase(testPlanName))
			throw new IllegalArgumentException("Invalid name.");
		super.setTestPlanName(testPlanName);
	}

	/**
	 * Adds a test case to the end of the list., and sets the Test Case's TestPlan to the current TestPlan.
	 * @param t the Test Case to add.
	 */
	public void addTestCase(TestCase t) {
		super.addTestCase(t);
		getTestCases().get(getTestCases().size() - 1).setTestPlan(this);
	}

	/**
	 * Compares the names of the Test Plans (case insensitive)
	 * @param t the other Test Plan to compare to
	 * @return 0 if the names are identical, otherwise a non-zero integer.
	 */
	public int compareTo(TestPlan t) {
		return getTestPlanName().toLowerCase().compareTo(t.getTestPlanName().toLowerCase());
	}
}
