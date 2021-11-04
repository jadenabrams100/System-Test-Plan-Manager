package edu.ncsu.csc216.stp.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;

/**
 * Ensures that TestCase works as intended
 * @author Jaden Abrams
 * @author Henry Kon
 *
 */
class TestCaseTest {
	
	private final String ID = "TestTimeUpperBound";
	
	private final String TYPE = "Boundary Analysis";
	
	private final String DESCRIPTION = "Set the time to 4:60";
	
	private final String RESULTS = "Invalid Time Entered";

	/**
	 * Test method for TestCases contstructor
	 */
	@Test
	void testTestCase() {
		assertDoesNotThrow(() -> new TestCase(ID, TYPE, DESCRIPTION, RESULTS));
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new TestCase(null, TYPE, DESCRIPTION, RESULTS));
		assertEquals("Invalid test information.", e1.getMessage());
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> new TestCase("", TYPE, DESCRIPTION, RESULTS));
		assertEquals("Invalid test information.", e2.getMessage());
		Exception e3 = assertThrows(IllegalArgumentException.class, () -> new TestCase(ID, null, DESCRIPTION, RESULTS));
		assertEquals("Invalid test information.", e3.getMessage());
		Exception e4 = assertThrows(IllegalArgumentException.class, () -> new TestCase(ID, "", DESCRIPTION, RESULTS));
		assertEquals("Invalid test information.", e4.getMessage());
		Exception e5 = assertThrows(IllegalArgumentException.class, () -> new TestCase(ID, TYPE, null, RESULTS));
		assertEquals("Invalid test information.", e5.getMessage());
		Exception e6 = assertThrows(IllegalArgumentException.class, () -> new TestCase(ID, TYPE, "", RESULTS));
		assertEquals("Invalid test information.", e6.getMessage());
		Exception e7 = assertThrows(IllegalArgumentException.class, () -> new TestCase(ID, TYPE, DESCRIPTION, null));
		assertEquals("Invalid test information.", e7.getMessage());
		Exception e8 = assertThrows(IllegalArgumentException.class, () -> new TestCase(ID, TYPE, DESCRIPTION, ""));
		assertEquals("Invalid test information.", e8.getMessage());
	}

	/**
	 * Test method for addTestResult()
	 */
	@Test
	void testAddTestResult() {
		TestCase t = new TestCase(ID, TYPE, DESCRIPTION, RESULTS);
		assertDoesNotThrow(() -> t.addTestResult(false, RESULTS));
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> t.addTestResult(false, null));
		assertEquals("Invalid test results.", e1.getMessage());
	}

	/**
	 * Test method for getTestCaseId()
	 */
	@Test
	void testGetTestCaseId() {
		TestCase t = new TestCase(ID, TYPE, DESCRIPTION, RESULTS);
		assertEquals(ID, t.getTestCaseId());
	}

	/**
	 * Test method for getTestType
	 */
	@Test
	void testGetTestType() {
		TestCase t = new TestCase(ID, TYPE, DESCRIPTION, RESULTS);
		assertEquals(TYPE, t.getTestType());
		
	}

	/**
	 * Test method for getTestDescription()
	 */
	@Test
	void testGetTestDescription() {
		TestCase t = new TestCase(ID, TYPE, DESCRIPTION, RESULTS);
		assertEquals(DESCRIPTION, t.getTestDescription());
	}

	/**
	 * Test method for getExpectedResults()
	 */
	@Test
	void testGetExpectedResults() {
		TestCase t = new TestCase(ID, TYPE, DESCRIPTION, RESULTS);
		assertEquals(RESULTS, t.getExpectedResults());
	}

	/**
	 * Test method for getResults()
	 */
	@Test
	void testGetResults() {
		TestCase t = new TestCase(ID, TYPE, DESCRIPTION, RESULTS);
		t.addTestResult(true, RESULTS);
		assertEquals(TestResult.PASS + ": " + RESULTS, t.getResults().get(0).toString());
	}

	/**
	 * Test method for getTestPlan
	 */
	@Test
	void testGetTestPlan() {
		TestCase t = new TestCase(ID, TYPE, DESCRIPTION, RESULTS);
		t.setTestPlan(new TestPlan("cool plan"));
		assertEquals("cool plan", t.getTestPlan().getTestPlanName());
	}

	/**
	 * Test method for isTestCasePassing()
	 */
	@Test
	void testIsTestCasePassing() {
		TestCase t = new TestCase(ID, TYPE, DESCRIPTION, RESULTS);
		assertFalse(t.isTestCasePassing());
		t.addTestResult(false, "GUI crashes");
		assertFalse(t.isTestCasePassing());
		t.addTestResult(true, RESULTS);
		assertTrue(t.isTestCasePassing());
	}

	/**
	 * Test method for getStatus()
	 */
	@Test
	void testGetStatus() {
		TestCase t = new TestCase(ID, TYPE, DESCRIPTION, RESULTS);
		assertEquals(TestResult.FAIL, t.getStatus());
		t.addTestResult(true, RESULTS);
		assertEquals(TestResult.PASS, t.getStatus());
	}

	/**
	 * Test method for gtActualResultsLog()
	 */
	@Test
	void testGetActualResultsLog() {
		TestCase t = new TestCase(ID, TYPE, DESCRIPTION, RESULTS);
		t.addTestResult(true, RESULTS);
		assertEquals("- PASS: " + RESULTS + "\n", t.getActualResultsLog());
	}

	/**
	 * Test method for setTestPlan()
	 */
	@Test
	void testSetTestPlan() {
		TestCase t = new TestCase(ID, TYPE, DESCRIPTION, RESULTS);
		assertDoesNotThrow(() -> t.setTestPlan(new TestPlan("cool plan")));
		assertThrows(IllegalArgumentException.class, () -> t.setTestPlan(null));
	}

	/**
	 * Test method for toString()
	 */
	@Test
	void testToString() {
		TestCase t = new TestCase(ID, TYPE, DESCRIPTION, RESULTS);
		t.addTestResult(true, RESULTS);
		String expected = "# " + ID + "," + TYPE + "\n* " + DESCRIPTION + "\n* " + RESULTS + "\n" + t.getActualResultsLog();
		assertEquals(expected, t.toString());
	}

}
