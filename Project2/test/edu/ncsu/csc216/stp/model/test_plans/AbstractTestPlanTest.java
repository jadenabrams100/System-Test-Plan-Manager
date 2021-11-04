package edu.ncsu.csc216.stp.model.test_plans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Ensures that AbstractTestPlan works properly
 * @author Jaden Abrams
 * @author Henry Kon
 */
class AbstractTestPlanTest {

	/**
	 * Test method for hashCode()
	 */
	@Test
	void testHashCode() {
		AbstractTestPlan a = new TestPlan("plan");
		AbstractTestPlan b = new TestPlan("Plan");
		AbstractTestPlan c = new TestPlan("plan");
		AbstractTestPlan d = new TestPlan("The Dillinger System Test Plan");
		assertEquals(a.hashCode(), c.hashCode());
		assertEquals(a.hashCode(), b.hashCode());
		assertNotEquals(a.hashCode(), d.hashCode());
	}

	/**
	 * Test method for AbstractTestPlan constructor
	 */
	@Test
	void testAbstractTestPlan() {
		assertDoesNotThrow(() -> new TestPlan("My super swap test plan"));
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new TestPlan(null));
		assertEquals("Invalid name.", e1.getMessage());
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> new TestPlan(""));
		assertEquals("Invalid name.", e2.getMessage());
		AbstractTestPlan a = new TestPlan("plan");
		assertEquals(0, a.getTestCases().size());
		assertEquals(0, a.getNumberOfFailingTests());
		assertEquals("plan", a.getTestPlanName());
	}

	/**
	 * Test method for setTestPlanName()
	 */
	@Test
	void testSetTestPlanName() {
		AbstractTestPlan a = new TestPlan("plan");
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> a.setTestPlanName(null));
		assertEquals("Invalid name.", e1.getMessage());
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> a.setTestPlanName(""));
		assertEquals("Invalid name.", e2.getMessage());
		a.setTestPlanName("The Dillinger System Test Plan");
		assertEquals("The Dillinger System Test Plan", a.getTestPlanName());
	}

	/**
	 * Test method for addTestCase()
	 */
	@Test
	void testAddTestCase() {
		AbstractTestPlan a = new TestPlan("plan");
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> a.addTestCase(null));
		assertEquals("Invalid test information.", e1.getMessage());
		a.addTestCase(new TestCase("testGUI", "Acceptance", "Ensure the GUI loads properly", "GUI loads properly"));
		assertEquals(1, a.getTestCases().size());
		
	}

	/**
	 * Test method for getTestPlanName()
	 */
	@Test
	void testGetTestPlanName() {
		AbstractTestPlan a = new TestPlan("plan");
		assertEquals("plan", a.getTestPlanName());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#getTestCases()}.
	 */
	@Test
	void testGetTestCases() {
		AbstractTestPlan a = new TestPlan("plan");
		a.addTestCase(new TestCase("testGUI", "Acceptance", "Ensure the GUI loads properly", "GUI loads properly"));
		assertEquals(1, a.getTestCases().size());
		assertEquals("testGUI", a.getTestCases().get(0).getTestCaseId());
	}

	/**
	 * Test method for getTestCase()
	 */
	@Test
	void testGetTestCase() {
		AbstractTestPlan a = new TestPlan("plan");
		a.addTestCase(new TestCase("testGUI", "Acceptance", "Ensure the GUI loads properly", "GUI loads properly"));
		TestCase b = a.getTestCase(0);
		assertEquals("testGUI", b.getTestCaseId());
		assertEquals("Acceptance", b.getTestType());
		assertEquals("Ensure the GUI loads properly", b.getTestDescription());
		assertEquals("GUI loads properly", b.getExpectedResults());
	}

	/**
	 * Test method for removeTestCase()
	 */
	@Test
	void testRemoveTestCase() {
		AbstractTestPlan a = new TestPlan("plan");
		a.addTestCase(new TestCase("testGUI", "Acceptance", "Ensure the GUI loads properly", "GUI loads properly"));
		TestCase b = a.removeTestCase(0);
		assertEquals(0, a.getTestCases().size());
		assertEquals("testGUI", b.getTestCaseId());
		assertEquals("Acceptance", b.getTestType());
		assertEquals("Ensure the GUI loads properly", b.getTestDescription());
		assertEquals("GUI loads properly", b.getExpectedResults());
	}

	/**
	 * Test method for getNumberOfFailingTests()
	 */
	@Test
	void testGetNumberOfFailingTests() {
		AbstractTestPlan a = new TestPlan("plan");
		a.addTestCase(new TestCase("testGUI", "Acceptance", "Ensure the GUI loads properly", "GUI loads properly"));
		assertEquals(1, a.getNumberOfFailingTests());
		a.getTestCase(0).addTestResult(true, "GUI loads properly");
		assertEquals(0, a.getNumberOfFailingTests());
	}

	/**
	 * Test method for addTestResult()
	 */
	@Test
	void testAddTestResult() {
		AbstractTestPlan a = new TestPlan("plan");
		a.addTestCase(new TestCase("testGUI", "Acceptance", "Ensure the GUI loads properly", "GUI loads properly"));
		a.addTestResult(0, false, "GUI loads unformatted");
		assertEquals("GUI loads unformatted", a.getTestCase(0).getResults().get(0).getActualResults());
	}


	/**
	 * Test method for equals()
	 */
	@Test
	void testEqualsObject() {
		AbstractTestPlan a = new TestPlan("plan");
		AbstractTestPlan b = new TestPlan("Plan");
		AbstractTestPlan c = new TestPlan("plan");
		AbstractTestPlan d = new TestPlan("The Dillinger System Test Plan");
		assertEquals(a, c);
		assertEquals(a, b);
		assertNotEquals(a, d);
	}

}
