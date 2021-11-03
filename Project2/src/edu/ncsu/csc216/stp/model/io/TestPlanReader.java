package edu.ncsu.csc216.stp.model.io;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.tests.TestResult;
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
			fileLine = fileLine + fileReader.nextLine() + "\n";
			if(!fileLine.substring(0, 1).equals("!")) {
				throw new IllegalArgumentException("Unable to load file.");
			}
			while(fileReader.hasNextLine()) {
				fileLine = fileLine + fileReader.nextLine() + "\n";
			}
			Scanner s1 = new Scanner(fileLine);
			s1.useDelimiter("\\r?\\n?[!]");
			TestPlan tp = null;
			while(s1.hasNext()) {
				tp = processTestPlan(s1.next());
				if(tp != null) {
					plans.add(tp);
					tp = null;
				}
			}
			s1.close();
			
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
			s1.useDelimiter("\\r?\\n?[#]");
			while(s1.hasNext()) {
				TestCase tc = processTest(tp, s1.next());
				if(tc != null) {
					tp.addTestCase(tc);
				}
				
			}
			
			s1.close();
			return tp;
		} catch(Exception e) {
			
			return null;
		}
	}

	/**
	 * Helper method to build a Test Case with Test Plans
	 * @param testPlan documentation pending
	 * @param s String to process
	 * @return a Test Case Object
	 */
	private static TestCase processTest(TestPlan testPlan, String s) {
		
		try {
			Scanner s1 = new Scanner(s);
			Scanner s2 = new Scanner(s1.nextLine().trim());
			s2.useDelimiter(",");
			String id = s2.next();
			String type = s2.next();
			s2.close();
			s1.useDelimiter("\\r?\\n?[-]");
			Scanner infoScanner = new Scanner(s1.next());
			infoScanner.useDelimiter("\\r?\\n?[*]");
			String description = infoScanner.next().trim();
			String expected = infoScanner.next().trim();
			TestCase tc = new TestCase(id, type, description, expected);
			tc.setTestPlan(testPlan);
			while(s1.hasNext()) {
				String resultString = s1.next().trim();
				String passingString = resultString.substring(0,resultString.indexOf(":"));
				String actualResultString = resultString.substring(resultString.indexOf(":")+1).trim();
				if(passingString.equals(TestResult.PASS)) {
					tc.addTestResult(true, actualResultString);
				}
				else if(passingString.equals(TestResult.FAIL)) {
					tc.addTestResult(false, actualResultString);
				}
			}
			return tc;
		} catch(Exception e) {
			return null;
		}
	}
}
