package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Test Plan used to store failing Tests
 * @author Henry Kon
 * @author Jaden Abrams
 */
public class FailingTestList extends AbstractTestPlan {
	/** Constant holding the name of the Failing Tests list */
	public static final String FAILING_TEST_LIST_NAME = "Failing Tests";

	/**
	 * Constructs a new Failing Tests list with the expected name.
	 */
	public FailingTestList() {
		super(FAILING_TEST_LIST_NAME);
	}

	/**
	 * Adds the specified test case to the end of the list
	 * Checks that the Test Case is failing before adding to the end of the list.
	 * @param t the Test Case to add to the list.
	 * @throws IllegalArgumentException if the test case is not failing.
	 */
	public void addTestCase(TestCase t) {
		// TODO: Auto-generated method stub
	}

	/**
	 * Sets the test plan name.
	 * @param testPlanName the new name of the test plan
	 * @throws IllegalArgumentException if the name does not match the expected name (case-insensitive).
	 */
	public void setTestPlanName(String testPlanName) {
		// TODO: Auto-generated method stub
	}

	/**
	 * Returns a 2D String array where the first column is the test case id, the second column is the test type,
	 * and the third column is the test plan name associated with the TestCase.
	 * If the test plan is null, then use empty string for the test plan name.
	 * @return a 2D String Array containing Test Case data.
	 */
	public String[][] getTestCasesAsArray() {
		return null;
	}

	/**
	 * Clears the FailingTestList of all Test Cases.
	 */
	public void clearTests() {
		// TODO: Auto-generated method stub
	}
}
