package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.tests.TestResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Ensures that TestPlan works properly
 * @author Jaden Abrams
 * @author Henry Kon
 */
class TestPlanTest {

	/**
	 * Test method for addTestCase()
	 */
	@Test
	void testAddTestCase() {
		TestPlan t = new TestPlan("Not Your Mother's Test Plan");
		t.addTestCase(new TestCase("testGUI", "Acceptance", "Ensure the GUI loads properly", "GUI loads properly"));
		assertEquals(t, t.getTestCase(0).getTestPlan());
	}

	/**
	 * Test method for getTestCasesAsArray()
	 */
	@Test
	void testGetTestCasesAsArray() {
		TestPlan t = new TestPlan("Not Your Mother's Test Plan");
		t.addTestCase(new TestCase("testGUI", "Acceptance", "Ensure the GUI loads properly", "GUI loads properly"));
		TestCase b = new TestCase("loadContents", "IO Analysis", "Ensures program loads files right", "Files load right");
		b.addTestResult(true, "Files load properly");
		t.addTestCase(b);
		String [][] testArray = t.getTestCasesAsArray();
		assertEquals("testGUI", testArray[0][0]);
		assertEquals("Acceptance", testArray[0][1]);
		assertEquals(TestResult.FAIL, testArray[0][2]);
		assertEquals("loadContents", testArray[1][0]);
		assertEquals("IO Analysis", testArray[1][1]);
		assertEquals(TestResult.PASS, testArray[1][2]);
	}

	/**
	 * Test method for getTestPlan()
	 */
	@Test
	void testTestPlan() {
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new TestPlan("Failing Tests"));
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> new TestPlan("FaIlInG tEsTs"));
		assertEquals("Invalid name.", e1.getMessage());
		assertEquals("Invalid name.", e2.getMessage());
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
