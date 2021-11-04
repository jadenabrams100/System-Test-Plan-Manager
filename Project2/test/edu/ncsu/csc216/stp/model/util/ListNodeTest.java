package edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Ensures that ListNode works as expected
 * @author Jaden Abrams
 * @author Henry Kon
 */
class ListNodeTest {

	/**
	 * Test method for ListNode constructor.
	 */
	@Test
	void testListNode() {
		ListNode<String> n = new ListNode<>("String",null);
		assertEquals("String", n.data);
		assertNull(n.next);
		
	}

}
