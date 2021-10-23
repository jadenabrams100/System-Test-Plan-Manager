/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * @author Jaden Abrams
 * @author Henry Kon
 * Provides the functionality of a log where entries are added to the end and cannot be removed.
 */
public class Log<E> implements ILog<E> {
	
	/** the list holding the log entries */
	private E[] log;
	/** the how many elements are in the log */
	private int size;
	/** the initial size of the internal array at construction */
	private static final int INIT_SIZE = 10;

	/**
	 * Creates a new Log object
	 */
	public Log() {
		log = (E []) new Object[10];
		size = 0;
	}
	/**
	 * adds an element to the log
	 * @param element the element to add
	 */
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * returns the element in the list at index idx
	 * @param idx the index to check
	 * @return the element
	 */
	@Override
	public E get(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * returns the size of the log
	 * @return the size
	 */
	@Override
	public int size() {
		return size;
	}

}
