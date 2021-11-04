package edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Ensures that SortedList works as intended
 * @author Jaden Abrams
 * @author Henry Kon
 *
 */
class SortedListTest {

	/**
	 * Test method for SortedList constructor.
	 */
	@Test
	void testSortedList() {
		SortedList<String> s = new SortedList<>();
		assertEquals(0, s.size());
	}

	/**
	 * Test method for add().
	 */
	@Test
	void testAdd() {
		SortedList<String> s = new SortedList<>();
		Exception e1 = assertThrows(NullPointerException.class, () -> s.add(null));
		assertEquals("Cannot add null element.", e1.getMessage());
		s.add("apple");
		assertEquals(1, s.size());
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> s.add("apple"));
		assertEquals("Cannot add duplicate element", e2.getMessage());
		s.add("cat");
		assertEquals(2, s.size());
		assertEquals("apple", s.get(0));
		assertEquals("cat", s.get(1));
		s.add("banana");
		assertEquals(3, s.size());
		assertEquals("apple", s.get(0));
		assertEquals("banana", s.get(1));
		assertEquals("cat", s.get(2));
	}

	/**
	 * Test method for remove()
	 */
	@Test
	void testRemove() {
		SortedList<String> s = new SortedList<>();
		s.add("apple");
		s.add("banana");
		s.add("dog");
		s.add("salamander");
		s.add("wolf");
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> s.remove(-1));
		assertEquals("Invalid index.", e1.getMessage());
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> s.remove(5));
		assertEquals("Invalid index.", e2.getMessage());
		String front = s.remove(0);
		assertEquals("apple", front);
		assertEquals(4, s.size());
		assertEquals("banana", s.get(0));
		String back = s.remove(3);
		assertEquals("wolf", back);
		assertEquals("salamander", s.get(2));
		String middle = s.remove(1);
		assertEquals("dog", middle);
		assertEquals("salamander", s.get(1));
		
	}

	/**
	 * Test method for contains()
	 */
	@Test
	void testContains() {
		SortedList<String> s = new SortedList<>();
		assertFalse(s.contains(null));
		s.add("cat");
		assertTrue(s.contains("cat"));
		s.add("banana");
		s.add("dog");
		s.add("salamander");
		s.add("wolf");
		assertFalse(s.contains("null"));
		assertTrue(s.contains("dog"));
		assertTrue(s.contains("wolf"));
	}

	/**
	 * Test method for get()
	 */
	@Test
	void testGet() {
		SortedList<String> s = new SortedList<>();
		s.add("apple");
		s.add("banana");
		s.add("dog");
		s.add("salamander");
		s.add("wolf");
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> s.get(-1));
		assertEquals("Invalid index.", e1.getMessage());
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> s.get(5));
		assertEquals("Invalid index.", e2.getMessage());
		assertEquals("apple", s.get(0));
		assertEquals("dog", s.get(2));
		assertEquals("wolf", s.get(4));
	}

	/**
	 * Test method for size()
	 */
	@Test
	void testSize() {
		SortedList<String> s = new SortedList<>();
		s.add("apple");
		s.add("banana");
		s.add("dog");
		s.add("salamander");
		s.add("wolf");
		assertEquals(5, s.size());
	}

}
