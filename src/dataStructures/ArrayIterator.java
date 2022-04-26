package dataStructures;

public class ArrayIterator<E> implements Iterator<E>{
	private E[] elems;
	private int counter;
	private int current;

	public ArrayIterator(E[] elems, int counter) {
		this.elems = elems;
		this.counter = counter;
		rewind();
	}

	public void rewind() {
		current = 0;
	}

	public boolean hasNext() {
		return current < counter;
	}

	public E next() {
		return elems[current++];
	}
}
