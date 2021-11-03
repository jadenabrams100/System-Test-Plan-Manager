/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * Ensures that TestPlanWriter works as expected
 * @author Jaden Abrams
 * @author Henry Kon
 *
 */
class TestTestPlanWriter {

	/**
	 * Test method for writeTestPlansFile()
	 */
	@Test
	void testWriteTestPlanFile() {
		ISortedList<TestPlan> list = TestPlanReader.readTestPlansFile(new File("test-files/test-plans1.txt"));
		TestPlanWriter.writeTestPlanFile(new File("test-files/actual-test-plans.txt"), list);
		try {
			Scanner fileReader = new Scanner(new FileInputStream("test-files/expected-test-plans.txt"));
			Scanner fileReader2 = new Scanner(new FileInputStream("test-files/actual-test-plans.txt"));
			while(fileReader.hasNextLine() && fileReader2.hasNextLine()) {
				assertEquals(fileReader.nextLine().trim(), fileReader2.nextLine().trim());
			}
			if(fileReader.hasNextLine() || fileReader2.hasNextLine()) {
				fail("One of the files has too many lines");
			}
		} catch(Exception e){
			fail();
		}
	}

}
