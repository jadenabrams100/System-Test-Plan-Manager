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
		// check if element is null
		if(element == null) {
			throw new NullPointerException("Cannot add null element");
		}
		// add if list is empty
		if(front == null) {
			front = new ListNode<E>(element, null);
			size++;
		}
		else {
			// checks if first element is same as front element
			ListNode<E> check = front;
			if(check.data.equals(element)) {
				throw new IllegalArgumentException("Cannot add duplicate element");
			}
			// iterate through list to see if data equals element
			while(check.next != null) {
				if(check.data.equals(element)) {
					throw new IllegalArgumentException("Cannot add duplicate element");
				}
				check = check.next;
			}
			// reset list copy
			ListNode<E> current = front;
			//check if element should be first element in list
			if(element.compareTo(current.data) < 0) {
				front = new ListNode<E>(element,front);
				size++;
			}
			else {
				// iterate through nodes
				while(current.next != null) {
					if(element.compareTo(current.next.data) < 0) {
						current.next = new ListNode<E>(element, current.next);
						size++;
					}
					else {
						current = current.next;
					}
				}
				// add to end of list if at end of list and element should go after last element
				if(current.next == null && element.compareTo(current.data) > 0) {
					current.next = new ListNode<E>(element, null);
					size++;
				}
			}
		}
		
		
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
		//check if index is out of bounds
		checkIndex(idx);
		// get if index is 0
		if(idx == 0) {
			return (E) front.data;
		}
		ListNode<E> current = front;
		for (int i = 0; i < idx - 1; i++) {
			current = current.next;
		}
		return (E) current.next.data;
	}

	/**
	 * returns the size of the list
	 * @return the size
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Checks whether an index is out of bounds or not
	 * @param idx the index to check.
	 * @throws IndexOutOfBoundsException if index is invalid
	 */
	private void checkIndex(int idx) {
		if(idx < 0 || idx > size-1) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}

}
