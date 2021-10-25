/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * @author Jaden Abrams
 * @author Henry Kon
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {
	
	/** the first node in the list */
	private ListNode front;
	/** the size of the list */
	private int size;

	/**
	 * a constructor for a blank sortedList
	 */
	public SortedList() {
		front = null;
		size = 0;
	}
	
	/**
	 * adds an element to the end of the list
	 * @param element the element to add
	 */
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * removes the item from the list and returns it
	 * @param the index to remove the item from
	 * @return the object removed
	 */
	@Override
	public E remove(int idx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * checks if the object is in the list
	 * @param the object to check for
	 * @return if it is in the list
	 */
	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * returns the item at the index
	 * @param the index to get
	 * @return the object at index
	 */
	@Override
	public E get(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * returns the size of the list
	 * @return the size
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * TODO: figure out what this does
	 * @param idx
	 */
	private void checkIndex(int idx) {
		
	}

}
