package edu.ncsu.csc216.stp.model.manager;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.FailingTestList;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;

import java.io.File;

/**
 * Test Plan Manager Object
 * @author Henry Kon
 * @author Jaden Abrams
 */
public class TestPlanManager {
	/** Stores the Test Plans */
	ISortedList<TestPlan> testPlans;
	/** Stores the list of Failing Tests */
	FailingTestList failingTestList;
	/** Stores the current Test Plan */
	AbstractTestPlan currentTestPlan;
	/** Tracks if the TestPlanManager has been changes since the last save */
	boolean isChanged;

	/**
	 * Constructs a new Test Plan Manager
	 */
	public TestPlanManager() {
		// TODO: Auto-generated method stub
	}

	/**
	 * Loads Test Plans from a given file
	 * @param testPlanFile the File to load the Test Plans from
	 */
	public void loadTestPlans(File testPlanFile) {
		// TODO: Auto-generated method stub
	}

	/**
	 * Saves Test Plans to a given file
	 * @param testPlanFile the File to save the Test Plans to
	 */
	public void saveTestPlans(File testPlanFile) {
		// TODO: Auto-generated method stub
	}

	/**
	 * Gets whether or not the Manager has been modified since the last save
	 * @return true if the Manager has been modified, false otherwise.
	 */
	public boolean isChanged() {
		return isChanged;
	}

	/**
	 * Adds a given Test Plan to the list of Test Plans
	 * @param testPlanName the name of the Test Plan to add to the list.
	 * @throws IllegalArgumentException if the Test Plan name matches the name of the Failing Tests List.
	 */
	public void addTestPlan(String testPlanName) {
		// TODO: Auto-generated method stub
	}

	/**
	 * Returns a list of test plan names. The Failing Tests list is always listed first.
	 * @return a String array containing test plan names.
	 */
	public String[] getTestPlanNames() {
		return null;
	}

	/**
	 * Helper method to rebuild the Failing Tests List
	 */
	private void getFailingTests() {
		// TODO: Auto-generated method stub
	}

	/**
	 * Sets the currentTestPlan to the AbstractTestPlan with the given name.
	 * If a TestPlan with that name is not found, then the currentTestPlan is set to the failingTestList
	 * @param testPlanName the name of the Test Plan to set as the current Test Plan
	 */
	public void setCurrentTestPlan(String testPlanName) {
		// TODO: Auto-generated method stub
	}

	/**
	 * Gets the current test plan
	 * @return the Current Test Plan
	 */
	public AbstractTestPlan getCurrentTestPlan() {
		return null;
	}

	/**
	 * Sets the name of the Current Test Plan, provided that the current test plan is not the Failing Test List.
	 * @param name the new name of the current Test Plan
	 * @throws IllegalArgumentException if the Current Test Plan is the Failing Test List, or if the new name matches
	 * a pre-existing Test Plan name (all case insensitive).
	 */
	public void editTestPlan(String name) {
		// TODO: Auto-generated method stub
	}

	/**
	 * Removes the Current Test Plan and sets it to the Failing Test List, provided the Current Test Plan is not already
	 * the Failing Test List.
	 * @throws IllegalArgumentException if the Current Test Plan is the Failing Test List.
	 */
	public void removeTestPlan() {
		// TODO: Auto-generated method stub
	}

	/**
	 * Adds a Test Case to the Current Test Plan.
	 * If the Test Case is failing, it is also added to the Failing Test List.
	 * If the Current Test Plan is not a Test Plan, nothing is done.
	 * @param testCase the Test Case to add to the Current Test Plan
	 */
	public void addTestCase(TestCase testCase) {
		// TODO: Auto-generated method stub
	}

	/**
	 * Adds the test result to the test case at the given index in the current test plan.
	 * If the tests are failing, then the Failing Test List should be updated.
	 * @param idx the index to add the Test Result at
	 * @param passing a boolean value set to true if the test is passing, false otherwise.
	 * @param s the test result description
	 */
	public void addTestResult(int idx, boolean passing, String s) {
		// TODO: Auto-generated method stub
	}

	/**
	 * Clears out the TestPlanManager by setting testPlans to an empty SortedList,
	 * failingTestList to an empty FailingTestList(), currentTestPlan to the failingTestList,
	 * and isChanged to false.
	 */
	public void clearTestPlans() {
		// TODO: Auto-generated method stub
	}
}
