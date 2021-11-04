package edu.ncsu.csc216.stp.model.util;

/**
 * Provides the functionality of a log where entries are added to the end and cannot be removed.
 * @author Jaden Abrams
 * @author Henry Kon
 * @param <E> Generic Object Type
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
		log = (E []) new Object[INIT_SIZE];
		size = 0;
	}
	/**
	 * adds an element to the log
	 * @param element the element to add
	 * @throws IllegalArgumentException if element is null
	 */
	@Override
	public void add(E element) {
		if(element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		try {
			log[size] = element;
			size++;
		} catch(IndexOutOfBoundsException e) {
			E[] newLog = (E[]) new Object[size * 2];
			if (size >= 0) System.arraycopy(log, 0, newLog, 0, size);
			log = newLog;
			log[size] = element;
			size++;
		}
		
	}

	/**
	 * returns the element in the list at index idx
	 * @param idx the index to check
	 * @return the element
	 */
	@Override
	public E get(int idx) {
		if(idx < 0 || idx > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		return log[idx];
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
