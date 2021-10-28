/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Ensures that TestResult works as intended
 * @author Jaden Abrams
 * @author Henry Kon
 *
 */
class TestResultTest {

	/**
	 * Test method for TestResult constructor
	 */
	@Test
	void testTestResult() {
		assertDoesNotThrow(() -> new TestResult(true, "GUI opens"));
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new TestResult(true, null));
		assertEquals("Invalid test results.", e1.getMessage());
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> new TestResult(true, ""));
		assertEquals("Invalid test results.", e2.getMessage());
	}

	/**
	 * Test method for getActualResults()
	 */
	@Test
	void testGetActualResults() {
		TestResult t = new TestResult(true, "GUI opens");
		assertEquals("GUI opens", t.getActualResults());
		
	}

	/**
	 * Test method for isPassing()
	 */
	@Test
	void testIsPassing() {
		TestResult t = new TestResult(true, "GUI opens");
		assertTrue(t.isPassing());
	}

	/**
	 * Test method for toString()
	 */
	@Test
	void testToString() {
		TestResult t = new TestResult(true, "GUI opens");
		TestResult t2 = new TestResult(false, "Crashes computer");
		assertEquals("PASS: GUI opens", t.toString());
		assertEquals("FAIL: Crashes computer", t2.toString());
	}

}
