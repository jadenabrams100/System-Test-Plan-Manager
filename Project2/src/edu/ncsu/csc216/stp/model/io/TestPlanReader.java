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
		ISortedList<TestPlan> plans = new SortedList<TestPlan>();
		
		try {
			Scanner fileReader = new Scanner(new FileInputStream(file));
			String fileLine = "";
			if(!fileReader.hasNextLine()) {
				throw new IllegalArgumentException("Unable to load file.");
			}
			fileLine = fileLine + fileReader.nextLine();
			if(!fileLine.substring(0, 1).equals("!")) {
				throw new IllegalArgumentException("Unable to load file.");
			}
			while(fileReader.hasNextLine()) {
				fileLine = fileLine + fileReader.nextLine();
			}
			Scanner s1 = new Scanner(fileLine);
			s1.useDelimiter("\\r?\\n?[n]");
			while(s1.hasNext()) {
				TestPlan tp = processTestPlan(s1.next());
				plans.add(tp);
			}
			
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		
		return plans;
	}

	/**
	 * Helper method to convert a Stringified Test Plan into a Test Plan object
	 * @param s a String version of a Test Plan
	 * @return a Test Plan Object
	 */
	private static TestPlan processTestPlan(String s) {
		try {
			Scanner s1 = new Scanner(s);
			TestPlan tp = new TestPlan(s1.nextLine().trim());
		} catch(Exception e) {
			
		}
		return null;
	}

	/**
	 * Helper method to build a Test Case with Test Plans
	 * @param testPlan documentation pending
	 * @param s String to process
	 * @return a Test Case Object
	 */
	private static TestCase processTest(AbstractTestPlan testPlan, String s) {
		return null;
	}
}
