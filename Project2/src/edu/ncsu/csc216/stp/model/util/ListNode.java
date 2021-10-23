package edu.ncsu.csc216.stp.model.util;

/**
 * A node for the linked list SwapList
 * @author Jaden Abrams
 * @author Henry Kon
 * 
 *
 */
public class ListNode<E> {
	/** the date in the node */
	public E data;
	/** the next node in the chain */
	public ListNode<E> next;
	/**
	 * creates a new node
	 * @param data the data in the node
	 * @param next the next node to link to
	 */
	public ListNode(E data, ListNode<E> next) {
		this.data = (E) data;
		this.next = next;
	}
}
