package edu.ncsu.csc216.stp.model.util;

/**
 * Sorted List Class
 * @author Jaden Abrams
 * @author Henry Kon
 * @param <E> Generic Object Type
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
	 * @param idx the index to remove the item from
	 * @return the object removed
	 */
	@Override
	public E remove(int idx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * checks if the object is in the list
	 * @param element the object to check for
	 * @return if it is in the list
	 */
	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * returns the item at the index
	 * @param idx the index to get
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
	 * Checks whether an index is out of bounds or not
	 * @param idx the index to check.
	 * @throws IndexOutOfBoundsException if index is invalid
	 */
	private void checkIndex(int idx) {
		// TODO: Auto-generated method stub
	}

}
