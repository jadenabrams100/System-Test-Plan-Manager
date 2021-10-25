/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * @author Jaden Abrams
 * @author Henry Kon
 */
public class SwapList<E> implements ISwapList<E> {
	/** the initial capacity for the swaplist */
	private static final int INITIAL_CAPACITY = 10;
	/** the internal list */
	private E[] list;
	/** the size of the list **/
	private int size;

	/**
	 * creates a new swaplist with the internal list initialized with room for 10 elements
	 */
	public SwapList() {
		list = (E[]) new Object[INITIAL_CAPACITY];
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
	 * removes the element at idx from the list and returns it
	 * @param idx the index to remove
	 * @return the element removed
	 */
	@Override
	public E remove(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * moves an element up by one
	 * @param idx the location of the element to move
	 */
	@Override
	public void moveUp(int idx) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * moves an element down by one
	 * @param idx the index of the object to be moved
	 */
	@Override
	public void moveDown(int idx) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * moves an element to the front of the list
	 * @param idx the index of the object to move
	 */
	@Override
	public void moveToFront(int idx) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * moves an element to the back of the list
	 * @param idx the element to move
	 */
	@Override
	public void moveToBack(int idx) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * returns the element at the index
	 * @param idx the index to get from
	 * @return the element
	 */
	@Override
	public E get(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * gets the size of the list
	 * @return the size
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * TODO: figure out what this does
	 * @param i
	 */
	private void checkCapacity(int i) {
		
	}
	
	/**
	 * TODO: figure out what this does
	 * @param i
	 */
	private void checkIndex(int i) {
		
	}

}
