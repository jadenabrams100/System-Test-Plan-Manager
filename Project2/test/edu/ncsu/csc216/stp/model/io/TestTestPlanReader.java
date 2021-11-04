package edu.ncsu.csc216.stp.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * Ensures that TestPlanReader works properly
 * @author Jaden Abrams
 * @author Henry Kon
 *
 */
class TestTestPlanReader {

	/**
	 * Test method for readTestPlansFile()
	 */
	@Test
	void testReadTestPlansFile() {
		AtomicReference<ISortedList<TestPlan>> listTest = new AtomicReference<>();

		// test empty file
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			listTest.set(TestPlanReader.readTestPlansFile(new File("test-files/test-empty.txt")));
		});
		assertEquals("Unable to load file.", e.getMessage());

		// test nonexistent file
		e = assertThrows(IllegalArgumentException.class, () -> {
			listTest.set(TestPlanReader.readTestPlansFile(new File("test-files/this-file-does-not.exist")));
		});
		assertEquals("Unable to load file.", e.getMessage());
		
		//test file 0
		ISortedList<TestPlan> list1 = TestPlanReader.readTestPlansFile(new File("test-files/test-plans0.txt"));
		assertEquals(2, list1.size());
		assertEquals("PackScheduler", list1.get(0).getTestPlanName());
		TestPlan t1 = list1.get(0);
		assertEquals(2, t1.getTestCases().size());
		assertEquals("test0", t1.getTestCase(0).getTestCaseId());
		assertEquals("Invalid", t1.getTestCase(0).getTestType());
		assertEquals("description", t1.getTestCase(0).getTestDescription());
		assertEquals("expected results\nwith multiple lines", t1.getTestCase(0).getExpectedResults());
		assertEquals(2, t1.getTestCase(0).getResults().size());
		assertFalse(t1.getTestCase(0).isTestCasePassing());
		assertEquals("test1", t1.getTestCase(1).getTestCaseId());
		assertEquals("Equivalence Class", t1.getTestCase(1).getTestType());
		assertEquals("description", t1.getTestCase(1).getTestDescription());
		assertEquals("expected results", t1.getTestCase(1).getExpectedResults());
		assertEquals(1, t1.getTestCase(1).getResults().size());
		assertTrue(t1.getTestCase(1).isTestCasePassing());
		
		//test file 2
		ISortedList<TestPlan> list2 = TestPlanReader.readTestPlansFile(new File("test-files/test-plans2.txt"));
		assertEquals(1, list2.size());
		assertEquals("WolfScheduler", list2.get(0).getTestPlanName());
		assertEquals(0, list2.get(0).getTestCases().size());
		// test file 3
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> TestPlanReader.readTestPlansFile(new File("test-files/test-plans3.txt")));
		assertEquals("Unable to load file.", e1.getMessage());
		//test file 4
		ISortedList<TestPlan> list3 = TestPlanReader.readTestPlansFile(new File("test-files/test-plans4.txt"));
		assertEquals("WolfScheduler", list3.get(0).getTestPlanName());
		assertEquals(0, list3.get(0).getTestCases().size());
		//test file 5
		ISortedList<TestPlan> list4 = TestPlanReader.readTestPlansFile(new File("test-files/test-plans5.txt"));
		assertEquals("WolfScheduler", list4.get(0).getTestPlanName());
		assertEquals(0, list4.get(0).getTestCases().size());
		//test file 6
		ISortedList<TestPlan> list5 = TestPlanReader.readTestPlansFile(new File("test-files/test-plans6.txt"));
		assertEquals("WolfScheduler", list5.get(0).getTestPlanName());
		assertEquals(0, list5.get(0).getTestCases().size());
		//test file 7
		ISortedList<TestPlan> list6 = TestPlanReader.readTestPlansFile(new File("test-files/test-plans7.txt"));
		assertEquals("WolfScheduler", list6.get(0).getTestPlanName());
		assertEquals(0, list6.get(0).getTestCases().size());
		//test file 8
		ISortedList<TestPlan> list7 = TestPlanReader.readTestPlansFile(new File("test-files/test-plans8.txt"));
		assertEquals("WolfScheduler", list7.get(0).getTestPlanName());
		assertEquals(0, list7.get(0).getTestCases().size());
		//test file 9
		ISortedList<TestPlan> list8 = TestPlanReader.readTestPlansFile(new File("test-files/test-plans9.txt"));
		assertEquals("WolfScheduler", list8.get(0).getTestPlanName());
		assertEquals(0, list8.get(0).getTestCases().size());
	}

}
