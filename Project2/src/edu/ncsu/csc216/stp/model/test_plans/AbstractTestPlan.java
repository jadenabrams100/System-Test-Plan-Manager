package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISwapList;

import java.util.Objects;

/**
 * Abstract Test Plan object
 * @author Henry Kon
 * @author Jaden Abrams
 */
public abstract class AbstractTestPlan {
	/** Stores the name of the Test Plan */
	String testPlanName;
	/** Stores the Test Cases in the Test Plan */
	ISwapList<TestCase> cases;

	/**
	 * Constructs a Test Plan Object
	 * @param testPlanName the name of the Test Plan
	 * @throws IllegalArgumentException if the Test Plan name is null or an empty string.
	 */
	public AbstractTestPlan(String testPlanName) {
		// TODO: Auto-generated method stub
	}

	/**
	 * Sets the Test Plan name
	 * @param testPlanName the new name of the Test Plan
	 * @throws IllegalArgumentException if the name is null or an empty String.
	 */
	public void setTestPlanName(String testPlanName) {
		// TODO: Auto-generated method stub
	}

	/**
	 * Adds the specified Test Case to the end of the list.
	 * Any exceptions from the list are thrown out of the method.
	 * @param t the Test Case to add to the list.
	 */
	public void addTestCase(TestCase t) {
		// TODO: Auto-generated method stub
	}

	/**
	 * Gets the test plan name
	 * @return the name of the test plan
	 */
	public String getTestPlanName() {
		return testPlanName;
	}

	/**
	 * Gets all the cases in the test plan
	 * @return a SwapList containing all the Test Cases in the Test Plan
	 */
	public ISwapList<TestCase> getCases() {
		return cases;
	}

	/**
	 * Removes the Test Case at the specified index and returns it.
	 * Any exceptions from the  list should be thrown out of the method.
	 * @param idx the index of the Test Case to remove
	 * @return the removed Test Case.
	 */
	public TestCase removeTestCase(int idx) {
		return null;
	}

	/**
	 * Counts the number of Test Cases that are failing
	 * @return an integer representing the number of failing Test Cases.
	 */
	public int getNumberOfFailingTests() {
		return 0;
	}

	/**
	 * Sends the test result parameters to the Test Case at the given index.
	 * @param idx the index of the Test Case to add the results to.
	 * @param passing a boolean set true if the test is passing, false if it is failing.
	 * @param actualResults the results description to add to the Test Case.
	 */
	public void addTestResult(int idx, boolean passing, String actualResults) {
		// TODO: Auto-generated method stub
	}

	/**
	 * Abstract method that returns a 2D Array
	 * @return a 2D String Array containing Test Case data.
	 */
	public String[][] getTestCasesAsArray() {
		return null;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AbstractTestPlan that = (AbstractTestPlan) o;
		return testPlanName.equals(that.testPlanName) && Objects.equals(cases, that.cases);
	}

	@Override
	public int hashCode() {
		return Objects.hash(testPlanName, cases);
	}
}
