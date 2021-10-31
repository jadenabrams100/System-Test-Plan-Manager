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
		String[][] arrayBuilder = new String[cases.size()][3];
		for (int i = 0; i < cases.size(); i++) {
			arrayBuilder[i][0] = cases.get(i).getTestCaseId();
			arrayBuilder[i][1] = cases.get(i).getTestType();
			arrayBuilder[i][2] = cases.get(i).getStatus();
		}
		return arrayBuilder;
	}

	/**
	 * Adds a test case to the end of the list., and sets the Test Case's TestPlan to the current TestPlan.
	 * @param t the Test Case to add.
	 */
	public void addTestCase(TestCase t) {
		cases.add(t);
		cases.get(cases.size() - 1).setTestPlan(this);
	}

	/**
	 * Compares the names of the Test Plans (case insensitive)
	 * @param t the other Test Plan to compare to
	 * @return documentation pending.
	 */
	public int compareTo(TestPlan t) {
		return 0;
	}
}
