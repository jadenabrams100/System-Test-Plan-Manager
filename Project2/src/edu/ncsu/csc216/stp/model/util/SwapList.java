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
		if (size - idx >= 0) System.arraycopy(list, idx + 1, list, idx, size - idx);
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
		checkIndex(idx);
		if(idx != 0) {
			//do everything
			E temp = list[idx];
			list[idx] = list[idx - 1];
			list[idx - 1] = temp;
		}
	}

	/**
	 * moves an element down by one
	 * @param idx the index of the object to be moved
	 */
	@Override
	public void moveDown(int idx) {
		checkIndex(idx);
		if(idx != size - 1) {
			E temp = list[idx];
			list[idx] = list[idx + 1];
			list[idx + 1] = temp;
		}
	}

	/**
	 * moves an element to the front of the list
	 * @param idx the index of the object to move
	 */
	@Override
	public void moveToFront(int idx) {
		checkIndex(idx);
		if(idx != 0) {
			E temp = list[idx];
			list[idx] = list[idx - 1];
			System.arraycopy(list, 0, list, 1, idx - 1);
			list[0] = temp;
		}
	}

	/**
	 * moves an element to the back of the list
	 * @param idx the element to move
	 */
	@Override
	public void moveToBack(int idx) {
		checkIndex(idx);
		if(idx != size - 1) {
			E temp = list[idx];
			list[idx] = list[idx + 1];
			if (size - 1 - (idx + 1) >= 0) System.arraycopy(list, idx + 2, list, idx + 1, size - 1 - (idx + 1));
			list[size - 1] = temp;
		}
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
	 * @param i the array capacity
	 */
	private void checkCapacity(int i) {
		if(i == list.length) {
			E[] newList = (E[]) new Object[size * 2];
			for(int idx = 0; i < size; idx++) {
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
		if(idx < 0 || idx > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}

}
