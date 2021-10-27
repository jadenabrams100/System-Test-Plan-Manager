package edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * a class to test that Log works as intended
 * @author Jaden Abrams
 * @author Henry Kon
 *
 */
class LogTest {

	/**
	 * ensure that Log constructor works as intended
	 */
	@Test
	void testLog() {
		Log<String> l = new Log<String>();
		assertEquals(0, l.size());
	}

	/**
	 * ensured that add() works as intended
	 */
	@Test
	void testAdd() {
		Log<String> l = new Log<String>();
		l.add("first");
		assertEquals(1, l.size());
		assertThrows(NullPointerException.class, () -> l.add(null));
		l.add("second");
		l.add("third");
		l.add("fifth");
		l.add("sixth");
		l.add("seventh");
		l.add("eighth");
		l.add("ninth");
		l.add("tenth");
		l.add("eleventh");
		l.add("twelfth");
	}

	/**
	 * ensures that get() works as intended
	 */
	@Test
	void testGet() {
		Log<String> l = new Log<String>();
		l.add("first");
		l.add("second");
		l.add("third");
		l.add("fifth");
		l.add("sixth");
		l.add("seventh");
		l.add("eighth");
		l.add("ninth");
		l.add("tenth");
		l.add("eleventh");
		l.add("twelfth");
		assertThrows(IndexOutOfBoundsException.class, () -> l.get(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> l.get(l.size()));
		assertEquals("first", l.get(0));
		assertEquals("fifth", l.get(3));
		assertEquals("twelfth", l.get(10));
	}

	/**
	 * ensures that size() works as intended
	 */
	@Test
	void testSize() {
		Log<String> l = new Log<String>();
		assertEquals(0, l.size());
		l.add("first");
		assertEquals(1, l.size());
	}

}
