/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
		assertEquals("Invalid test results", e1.getMessage());
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
		fail("Not yet implemented");
	}

	/**
	 * Test method for getExpectedResults()
	 */
	@Test
	void testGetExpectedResults() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for getResults()
	 */
	@Test
	void testGetResults() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for getTestPlan
	 */
	@Test
	void testGetTestPlan() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for isTestCasePassing()
	 */
	@Test
	void testIsTestCasePassing() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for getStatus()
	 */
	@Test
	void testGetStatus() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for gtActualResultsLog()
	 */
	@Test
	void testGetActualResultsLog() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for setTestPlan()
	 */
	@Test
	void testSetTestPlan() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for toString()
	 */
	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
