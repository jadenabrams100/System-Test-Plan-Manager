/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Ensures that SwapList works as intended
 * @author Jaden Abrams
 * @author Henry Kon
 *
 */
class SwapListTest {

	/**
	 * Test method for SwapList constructor
	 */
	@Test
	void testSwapList() {
		SwapList<String> s = new SwapList<String>();
		assertEquals(0, s.size());
		
	}

	/**
	 * Test method for add()
	 */
	@Test
	void testAdd() {
		SwapList<String> s = new SwapList<String>();
		Exception e1 = assertThrows(NullPointerException.class, () -> s.add(null));
		assertEquals("Cannot add null element.", e1.getMessage());
		s.add("apple");
		s.add("banana");
		s.add("dog");
		s.add("salamander");
		s.add("wolf");
		s.add("parrot");
		s.add("orangatan");
		s.add("cat");
		s.add("ninth");
		s.add("tenth");
		s.add("eleventh");
		s.add("null");
	}

	/**
	 * Test method for remove()
	 */
	@Test
	void testRemove() {
		SwapList<String> s = new SwapList<String>();
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
	 * Test method for moveUp()
	 */
	@Test
	void testMoveUp() {
		SwapList<String> s = new SwapList<String>();
		s.add("apple");
		s.add("banana");
		s.add("dog");
		s.add("salamander");
		s.add("wolf");
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> s.moveUp(-1));
		assertEquals("Invalid index.", e1.getMessage());
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> s.moveUp(5));
		assertEquals("Invalid index.", e2.getMessage());
		s.moveUp(0);
		assertEquals("apple", s.get(0));
		s.moveUp(1);
		assertEquals("banana", s.get(0));
		assertEquals("apple", s.get(1));
	}

	/**
	 * Test method for moveDown()
	 */
	@Test
	void testMoveDown() {
		SwapList<String> s = new SwapList<String>();
		s.add("apple");
		s.add("banana");
		s.add("dog");
		s.add("salamander");
		s.add("wolf");
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> s.moveDown(-1));
		assertEquals("Invalid index.", e1.getMessage());
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> s.moveDown(5));
		assertEquals("Invalid index.", e2.getMessage());
		s.moveDown(4);
		assertEquals("wolf", s.get(4));
		s.moveDown(0);
		assertEquals("banana", s.get(0));
		assertEquals("apple", s.get(1));
	}

	/**
	 * Test method for moveToFront()
	 */
	@Test
	void testMoveToFront() {
		SwapList<String> s = new SwapList<String>();
		s.add("apple");
		s.add("banana");
		s.add("dog");
		s.add("salamander");
		s.add("wolf");
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> s.moveToFront(-1));
		assertEquals("Invalid index.", e1.getMessage());
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> s.moveToFront(5));
		assertEquals("Invalid index.", e2.getMessage());
		s.moveToFront(0);
		assertEquals("apple", s.get(0));
		s.moveToFront(2);
		assertEquals("dog", s.get(0));
		assertEquals("apple", s.get(1));
		assertEquals("banana", s.get(2));
		assertEquals("salamander", s.get(3));
		assertEquals("wolf", s.get(4));
	}

	/**
	 * Test method for moveToBack()
	 */
	@Test
	void testMoveToBack() {
		SwapList<String> s = new SwapList<String>();
		s.add("apple");
		s.add("banana");
		s.add("dog");
		s.add("salamander");
		s.add("wolf");
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> s.moveToBack(-1));
		assertEquals("Invalid index.", e1.getMessage());
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> s.moveToBack(5));
		assertEquals("Invalid index.", e2.getMessage());
		s.moveToBack(4);
		assertEquals("wolf", s.get(4));
		s.moveToBack(2);
		assertEquals("apple", s.get(0));
		assertEquals("banana", s.get(1));
		assertEquals("salamander", s.get(2));
		assertEquals("wolf", s.get(3));
		assertEquals("dog", s.get(4));
	}

	/**
	 * Test method for get()
	 */
	@Test
	void testGet() {
		SwapList<String> s = new SwapList<String>();
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
	}

	/**
	 * Test method for size()
	 */
	@Test
	void testSize() {
		SwapList<String> s = new SwapList<String>();
		s.add("apple");
		s.add("banana");
		s.add("dog");
		s.add("salamander");
		s.add("wolf");
		assertEquals(5, s.size());
	}

}
