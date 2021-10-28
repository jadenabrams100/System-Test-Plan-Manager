package edu.ncsu.csc216.stp.model.util;

/**
 * Swap List Object
 * @author Jaden Abrams
 * @author Henry Kon
 * @param <E> Generic Object Type
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
		if(element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		checkCapacity(size);
		list[size] = element;
		size++;
	}

	/**
	 * removes the element at idx from the list and returns it
	 * @param idx the index to remove
	 * @return the element removed
	 */
	@Override
	public E remove(int idx) {
		checkIndex(idx);
		E rtn = list[idx];
		for (int i = idx; i < size; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = null;
		size--;
		return rtn;
		
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
		
		checkIndex(idx);
		return list[idx];
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
	 * checks whether the array is at capacity and grows the array if need be
	 * @param idx the capacity
	 */
	private void checkCapacity(int i) {
		if(i == list.length) {
			E[] newList = (E[]) new Object[size * 2];
			for(int idx = 0; i < size; i++) {
				newList[idx] = list[idx];
			}
			list = newList;
		}
	}
	
	/**
	 * Checks whether the index is valid
	 * @param idx the index to check
	 */
	private void checkIndex(int idx) {
		if(idx < 0 || idx > size-1) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}

}
