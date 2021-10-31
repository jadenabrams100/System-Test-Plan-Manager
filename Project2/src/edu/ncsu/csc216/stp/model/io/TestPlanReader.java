package edu.ncsu.csc216.stp.model.io;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class that handles reading Test Plans from a file
 * @author Henry Kon
 */
public class TestPlanReader {
	/**
	 * Reads Test Plans from a file
	 * Invalid data lines are ignored.
	 * @param file the File to read the Test Plans from
	 * @return a List of Test Plans
	 * @throws IllegalArgumentException if the file cannot be loaded or does not exist.
	 */
	public static ISortedList<TestPlan> readTestPlansFile(File file) {
		
		
		try {
			Scanner fileReader = new Scanner(new FileInputStream(file.getPath()));
			ISortedList<TestPlan> plans = new SortedList<TestPlan>();
			String fileLine = "";
			while(fileReader.hasNextLine()) {
				
			}
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		
		return null;
	}

	/**
	 * Helper method to convert a Stringified Test Plan into a Test Plan object
	 * @param s a String version of a Test Plan
	 * @return a Test Plan Object
	 */
	private TestPlan processTestPlan(String s) {
		return null;
	}

	/**
	 * Helper method to build a Test Case with Test Plans
	 * @param testPlan documentation pending
	 * @param s String to process
	 * @return a Test Case Object
	 */
	private TestCase processTest(AbstractTestPlan testPlan, String s) {
		return null;
	}
}
