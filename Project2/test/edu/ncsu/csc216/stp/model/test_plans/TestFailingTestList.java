package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Ensures that FailingTestList works properly
 * @author Jaden Abrams
 * @author Henry Kon
 *
 */
class TestFailingTestList {

	/**
	 * Test method for setTestPlanName()
	 */
	@Test
	void testSetTestPlanName() {
		FailingTestList t = new FailingTestList();
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {
			t.setTestPlanName("Test List");
		});
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {
			t.setTestPlanName("Failling Tests");
		});
		assertEquals("Invalid name.", e1.getMessage());
		assertEquals("Invalid name.", e2.getMessage());
		assertEquals("Failing Tests", t.getTestPlanName());
	}


	/**
	 * Test method for clearTests()
	 */
	@Test
	void testClearTests() {
		FailingTestList t = new FailingTestList();
		t.addTestCase(new TestCase("testGUI", "Acceptance", "Ensure the GUI loads properly", "GUI loads properly"));
		t.addTestCase(new TestCase("testGUI 2", "Acceptance 2", "Ensure the GUI loads properly (2)", "GUI loads properly (2)"));
		t.addTestCase(new TestCase("testGUI 3", "Acceptance 3", "Ensure the GUI loads properly (3)", "GUI loads properly (3)"));
		assertEquals(3, t.getTestCases().size());
		t.clearTests();
		assertEquals(0, t.getTestCases().size());
	}


	/**
	 * Test method for addTestCase()
	 */
	@Test
	void testAddTestCase() {
		FailingTestList t = new FailingTestList();
		t.addTestCase(new TestCase("testGUI", "Acceptance", "Ensure the GUI loads properly", "GUI loads properly"));
		assertEquals("testGUI", t.getTestCase(0).getTestCaseId());
		assertEquals("Acceptance", t.getTestCase(0).getTestType());
		assertNull(t.getTestCase(0).getTestPlan());
	}

	/**
	 * Test method for getTestCasesAsArray()
	 */
	@Test
	void testGetTestCasesAsArray() {
		FailingTestList t = new FailingTestList();
		t.addTestCase(new TestCase("testGUI", "Acceptance", "Ensure the GUI loads properly", "GUI loads properly"));
		TestCase b = new TestCase("loadContents", "IO Analysis", "Ensures program loads files right", "Files load right");
		b.addTestResult(false, "Files do not load properly");
		t.addTestCase(b);
		String [][] testArray = t.getTestCasesAsArray();
		assertEquals("testGUI", testArray[0][0]);
		assertEquals("Acceptance", testArray[0][1]);
		assertEquals("", testArray[0][2]);
		assertEquals("loadContents", testArray[1][0]);
		assertEquals("IO Analysis", testArray[1][1]);
		assertEquals("", testArray[1][2]);
	}

	/**
	 * Test method for getTestPlan()
	 */
	@Test
	void testFailingTestList() {
		FailingTestList t1 = new FailingTestList();
		assertEquals("Failing Tests", t1.getTestPlanName());
	}

	/**
	 * Test method for compareTo()
	 */
	@Test
	void testCompareTo() {
		String s1 = "plan";
		String s2 = "Not Your Mother's Test Plan";
		String s3 = "The Dillinger System Test Plan";
		String s4 = "Plan";
		TestPlan p1 = new TestPlan(s1);
		TestPlan p2 = new TestPlan(s2);
		TestPlan p3 = new TestPlan(s3);
		TestPlan p4 = new TestPlan(s4);
		assertEquals(0, p1.compareTo(p4));
		assertEquals(s1.toLowerCase().compareTo(s2.toLowerCase()), p1.compareTo(p2));
		assertEquals(s2.toLowerCase().compareTo(s3.toLowerCase()), p2.compareTo(p3));
	}


}
