package edu.ncsu.csc216.stp.model.manager;

import java.io.File;

import edu.ncsu.csc216.stp.model.io.TestPlanReader;
import edu.ncsu.csc216.stp.model.io.TestPlanWriter;
import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.FailingTestList;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

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
		clearTestPlans();
	}

	/**
	 * Loads Test Plans from a given file
	 * @param testPlanFile the File to load the Test Plans from
	 */
	public void loadTestPlans(File testPlanFile) {
		ISortedList<TestPlan> newPlans = TestPlanReader.readTestPlansFile(testPlanFile);
		for (int i = 0; i < newPlans.size(); i++) {
			try {
				testPlans.add(newPlans.get(i));
			} catch(IllegalArgumentException ignored) {
				// catch block ignored.
			}
		}
		setCurrentTestPlan(failingTestList.getTestPlanName());
		getFailingTests();
	}

	/**
	 * Saves Test Plans to a given file
	 * @param testPlanFile the File to save the Test Plans to
	 */
	public void saveTestPlans(File testPlanFile) {
		TestPlanWriter.writeTestPlanFile(testPlanFile, testPlans);
		isChanged = false;
	}

	/**
	 * Gets whether the Manager has been modified since the last save
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
		if("Failing Tests".equalsIgnoreCase(testPlanName))
			throw new IllegalArgumentException("Invalid name.");
		testPlans.add(new TestPlan(testPlanName));
		isChanged = true;
	}

	/**
	 * Returns a list of test plan names. The Failing Tests list is always listed first.
	 * @return a String array containing test plan names.
	 */
	public String[] getTestPlanNames() {
		String[] builder = new String[testPlans.size() + 1];
		builder[0] = failingTestList.getTestPlanName();
		for (int i = 0; i < testPlans.size(); i++) {
			builder[i + 1] = testPlans.get(i).getTestPlanName();
		}
		return builder;
	}

	/**
	 * Helper method to rebuild the Failing Tests List
	 */
	private void getFailingTests() {
		failingTestList.clearTests();
		for (int i = 0; i < testPlans.size(); i++) {
			TestPlan temp = testPlans.get(i);
			for (int j = 0; j < temp.getTestCases().size(); j++) {
				if(!temp.getTestCase(j).isTestCasePassing())
					failingTestList.addTestCase(temp.getTestCase(j));
			}
		}
	}

	/**
	 * Sets the currentTestPlan to the AbstractTestPlan with the given name.
	 * If a TestPlan with that name is not found, then the currentTestPlan is set to the failingTestList
	 * @param testPlanName the name of the Test Plan to set as the current Test Plan
	 */
	public void setCurrentTestPlan(String testPlanName) {
		if(failingTestList.getTestPlanName().equals(testPlanName))
			currentTestPlan = failingTestList;
		for (int i = 0; i < testPlans.size(); i++) {
			if(testPlanName.equalsIgnoreCase(testPlans.get(i).getTestPlanName())) {
				currentTestPlan = testPlans.get(i);
				isChanged = true;
				return;
			}
		}
	}

	/**
	 * Gets the current test plan
	 * @return the Current Test Plan
	 */
	public AbstractTestPlan getCurrentTestPlan() {
		return currentTestPlan;
	}

	/**
	 * Sets the name of the Current Test Plan, provided that the current test plan is not the Failing Test List.
	 * @param name the new name of the current Test Plan
	 * @throws IllegalArgumentException if the Current Test Plan is the Failing Test List, or if the new name matches
	 * a pre-existing Test Plan name (all case insensitive).
	 */
	public void editTestPlan(String name) {
		if(currentTestPlan == failingTestList)
			throw new IllegalArgumentException("The Failing Tests list may not be edited.");
		for (int i = 0; i < testPlans.size(); i++) {
			if(testPlans.get(i).getTestPlanName().equalsIgnoreCase(name))
				throw new IllegalArgumentException("Invalid name.");
		}
		currentTestPlan.setTestPlanName(name);
		isChanged = true;
	}

	/**
	 * Removes the Current Test Plan and sets it to the Failing Test List, provided the Current Test Plan is not already
	 * the Failing Test List.
	 * @throws IllegalArgumentException if the Current Test Plan is the Failing Test List.
	 */
	public void removeTestPlan() {
		if(currentTestPlan == failingTestList)
			throw new IllegalArgumentException("The Failing Tests list may not be deleted");
		int idx = -1;
		for (int i = 0; i < testPlans.size(); i++) {
			if(testPlans.get(i).getTestPlanName().equals(currentTestPlan.getTestPlanName()))
				idx = i;
		}
		if(idx == -1)
			return;
		testPlans.remove(idx);
		currentTestPlan = failingTestList;
		isChanged = true;
	}

	/**
	 * Adds a Test Case to the Current Test Plan.
	 * If the Test Case is failing, it is also added to the Failing Test List.
	 * If the Current Test Plan is not a Test Plan, nothing is done.
	 * @param testCase the Test Case to add to the Current Test Plan
	 */
	public void addTestCase(TestCase testCase) {
		if(currentTestPlan == failingTestList)
			return;
		currentTestPlan.addTestCase(testCase);
		if(!testCase.isTestCasePassing())
			getFailingTests();
		isChanged = true;
	}

	/**
	 * Adds the test result to the test case at the given index in the current test plan.
	 * If the tests are failing, then the Failing Test List should be updated.
	 * @param idx the index to add the Test Result at
	 * @param passing a boolean value set to true if the test is passing, false otherwise.
	 * @param description the test result description
	 */
	public void addTestResult(int idx, boolean passing, String description) {
		currentTestPlan.addTestResult(idx, passing, description);
		if(!passing)
			getFailingTests();
		isChanged = true;
	}

	/**
	 * Clears out the TestPlanManager by setting testPlans to an empty SortedList,
	 * failingTestList to an empty FailingTestList(), currentTestPlan to the failingTestList,
	 * and isChanged to false.
	 */
	public void clearTestPlans() {
		testPlans = new SortedList<>();
		failingTestList = new FailingTestList();
		currentTestPlan = failingTestList;
		isChanged = false;
	}
}
