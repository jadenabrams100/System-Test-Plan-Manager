package edu.ncsu.csc216.stp.model.io;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import java.io.*;
import edu.ncsu.csc216.stp.model.util.ISortedList;

import java.io.File;

/**
 * Class that writes Test Plan data to a file
 * @author Henry Kon
 */
public class TestPlanWriter {
	/**
	 * Writes Test Plans to a file
	 * @param file the File to write the Test Plans to.
	 * @param testPlanList a Sorted List of Test Plans to write to a file.
	 * @throws IllegalArgumentException if the method encounters any errors or exceptions.
	 */
	public static void writeTestPlanFile(File file, ISortedList<TestPlan> testPlanList) {
		try {
			PrintStream fileWriter = new PrintStream(file);
			TestPlan tp = null;
			for(int i = 0; i < testPlanList.size(); i++) {
				tp = testPlanList.get(i);
				fileWriter.println("! " + tp.getTestPlanName());
				for(int j = 0; j < tp.getTestCases().size(); j++) {
					fileWriter.print(tp.getTestCase(j));
				}
				
			}
			fileWriter.close();
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to save file");
		}
	}
}
