package edu.ncsu.csc216.stp.model.manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Ensures that TestPlanManager works as expected
 * @author Jaden Abrams
 * @author Henry Kon
 *
 */
class TestPlanManagerTest {

	/**
	 * Test method for TestPlanManager constructor
	 */
	@Test
	void testTestPlanManager() {
		TestPlanManager t = new TestPlanManager();
		t.addTestPlan("New Test Plan");
		assertEquals("New Test Plan", t.testPlans.get(0).getTestPlanName());
	}

	/**
	 * Test method for loadTestPlans()
	 */
	@Test
	void testLoadTestPlans() {
		TestPlanManager t = new TestPlanManager();
		t.loadTestPlans(new File("test-files/test-plans1.txt"));
		assertEquals(2, t.testPlans.size());
		assertEquals("PackScheduler", t.testPlans.get(0).getTestPlanName());
		assertEquals("WolfScheduler", t.testPlans.get(1).getTestPlanName());
		assertEquals("Failing Tests", t.getCurrentTestPlan().getTestPlanName());
		assertEquals(3, t.getCurrentTestPlan().getTestCases().size());
		assertEquals(2, t.testPlans.get(0).getTestCases().size());
		t.loadTestPlans(new File("test-files/test-plans0.txt"));
		assertEquals(2, t.testPlans.size());
		assertEquals("PackScheduler", t.testPlans.get(0).getTestPlanName());
		assertEquals("WolfScheduler", t.testPlans.get(1).getTestPlanName());
		assertEquals("Failing Tests", t.getCurrentTestPlan().getTestPlanName());
		assertEquals(3, t.getCurrentTestPlan().getTestCases().size());
		assertEquals(2, t.testPlans.get(0).getTestCases().size());
	}

	/**
	 * Test method for saveTestPlans()
	 */
	//@SuppressWarnings("RedundantExplicitClose")
	@Test
	void testSaveTestPlans() {
		TestPlanManager t = new TestPlanManager();
		t.loadTestPlans(new File("test-files/test-plans1.txt"));
		t.saveTestPlans(new File("test-files/manager-test-out.txt"));
		try (Scanner expScanner = new Scanner(new File("test-files/manager-expected-plans.txt"));
		     Scanner actScanner = new Scanner(new File("test-files/manager-test-out.txt"))) {

			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}

			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}

	/**
	 * Test method for isChanged()
	 */
	@Test
	void testIsChanged() {
		TestPlanManager t = new TestPlanManager();
		t.loadTestPlans(new File("test-files/test-plans1.txt"));
		assertFalse(t.isChanged());
		// addTestPlan
		t.addTestPlan("New Test Plan");
		assertTrue(t.isChanged());

		// setCurrentTestPlan
		t = new TestPlanManager();
		t.loadTestPlans(new File("test-files/test-plans1.txt"));
		assertFalse(t.isChanged());
		t.setCurrentTestPlan(t.testPlans.get(1).getTestPlanName());
		assertTrue(t.isChanged());

		// removeTestPlan
		t = new TestPlanManager();
		t.loadTestPlans(new File("test-files/test-plans1.txt"));
		assertFalse(t.isChanged());
		t.setCurrentTestPlan(t.testPlans.get(1).getTestPlanName());
		t.removeTestPlan();
		assertTrue(t.isChanged());

		// editTestPlan
		t = new TestPlanManager();
		t.loadTestPlans(new File("test-files/test-plans1.txt"));
		assertFalse(t.isChanged());
		t.setCurrentTestPlan(t.testPlans.get(1).getTestPlanName());
		t.editTestPlan("New Name");
		assertTrue(t.isChanged());

		// addTestCase
		t = new TestPlanManager();
		t.loadTestPlans(new File("test-files/test-plans1.txt"));
		assertFalse(t.isChanged());
		t.setCurrentTestPlan(t.testPlans.get(1).getTestPlanName());
		t.addTestCase(new TestCase("test", "TEST", "test test", "test test test"));
		assertTrue(t.isChanged());

		// clearTestPlans
		t = new TestPlanManager();
		t.loadTestPlans(new File("test-files/test-plans1.txt"));
		assertFalse(t.isChanged());
		t.clearTestPlans();
		assertFalse(t.isChanged());

	}

	/**
	 * Test method for addTestPlan()
	 */
	@Test
	void testAddTestPlan() {
		TestPlanManager t = new TestPlanManager();
		assertEquals(0, t.testPlans.size());
		t.addTestPlan("New Test");
		assertEquals(1, t.testPlans.size());
		Exception e = assertThrows(IllegalArgumentException.class, () -> t.addTestPlan("Failing Tests"));
		assertEquals("Invalid name.", e.getMessage());
	}

	/**
	 * Test method for getTestPlanNames()
	 */
	@Test
	void testGetTestPlanNames() {
		String[] comparison = new String[3];
		comparison[0] = "Failing Tests";
		comparison[1] = "PackScheduler";
		comparison[2] = "WolfScheduler";
		TestPlanManager t = new TestPlanManager();
		t.loadTestPlans(new File("test-files/test-plans1.txt"));
		String[] actual = t.getTestPlanNames();
		assertEquals(comparison.length, actual.length);
		for (int i = 0; i < comparison.length; i++) {
			assertEquals(comparison[i], actual[i]);
		}
	}

	/**
	 * Test method for setCurrentTestPlan()
	 */
	@Test
	void testSetCurrentTestPlan() {
		TestPlanManager t = new TestPlanManager();
		t.loadTestPlans(new File("test-files/test-plans1.txt"));
		assertEquals("Failing Tests", t.getCurrentTestPlan().getTestPlanName());
		t.setCurrentTestPlan("This Test Does Not Exist");
		assertEquals("Failing Tests", t.getCurrentTestPlan().getTestPlanName());
		t.setCurrentTestPlan("WolfScheduler");
		assertEquals("WolfScheduler", t.getCurrentTestPlan().getTestPlanName());
	}

	/**
	 * Test method for editTestPlan()
	 */
	@Test
	void testEditTestPlan() {
		TestPlanManager t = new TestPlanManager();
		t.addTestPlan("New Test");
		t.addTestPlan("New Test 2");
		assertEquals(2, t.testPlans.size());
		t.setCurrentTestPlan("New Test 2");
		Exception e = assertThrows(IllegalArgumentException.class, () -> t.editTestPlan("New Test"));
		assertEquals("Invalid name.", e.getMessage());
		assertEquals("New Test 2", t.getCurrentTestPlan().getTestPlanName());
		e = assertThrows(IllegalArgumentException.class, () -> t.editTestPlan("fAIliNg TeStS"));
		assertEquals("Invalid name.", e.getMessage());
		assertEquals("New Test 2", t.getCurrentTestPlan().getTestPlanName());
		t.setCurrentTestPlan("Failing Tests");
		e = assertThrows(IllegalArgumentException.class, () -> t.editTestPlan("No Longer Failing Tests!"));
		assertEquals("The Failing Tests list may not be edited.", e.getMessage());
		assertEquals("Failing Tests", t.getCurrentTestPlan().getTestPlanName());
	}

	/**
	 * Test method for removeTestPlan()
	 */
	@Test
	void testRemoveTestPlan() {
		TestPlanManager t = new TestPlanManager();
		t.addTestPlan("New Test");
		t.addTestPlan("New Test 2");
		assertEquals(2, t.testPlans.size());
		t.setCurrentTestPlan("Failing Tests");
		Exception e = assertThrows(IllegalArgumentException.class, t::removeTestPlan);
		assertEquals("The Failing Tests list may not be deleted", e.getMessage());
		assertEquals(2, t.testPlans.size());
		t.setCurrentTestPlan("New Test");
		t.removeTestPlan();
		assertEquals(1, t.testPlans.size());
	}

	/**
	 * Test method for addTestResult()
	 */
	@Test
	void testAddTestResult() {
		TestPlanManager t = new TestPlanManager();
		t.loadTestPlans(new File("test-files/test-plans1.txt"));
		t.setCurrentTestPlan("WolfScheduler");
		assertEquals(3, t.getCurrentTestPlan().getTestCase(0).getResults().size());
		t.addTestResult(0, true, "This test passed!");
		assertEquals(4, t.getCurrentTestPlan().getTestCase(0).getResults().size());
		t.addTestResult(0, false, "This test failed! :(");
		assertEquals(5, t.getCurrentTestPlan().getTestCase(0).getResults().size());
	}

	/**
	 * Test method for clearTestPlans()
	 */
	@Test
	void testClearTestPlans() {
		TestPlanManager t = new TestPlanManager();
		t.loadTestPlans(new File("test-files/test-plans1.txt"));
		t.setCurrentTestPlan("WolfScheduler");
		assertEquals(2, t.testPlans.size());
		t.clearTestPlans();
		assertEquals("Failing Tests", t.getCurrentTestPlan().getTestPlanName());
		assertEquals(0, t.testPlans.size());
	}

}
