package dataStructures;

public class ArrayClass<E> implements Array<E> {
	private static final int SIZE = 50;

	private E[] elems;
	private int counter;

	@SuppressWarnings("unchecked")
	public ArrayClass() {
		elems = (E[]) new Object[SIZE];
		counter = 0;
	}

	@SuppressWarnings("unchecked")
	public ArrayClass(int dimention) {
		elems = (E[]) new Object[dimention];
		counter = 0;
	}

	public void insertLast(E e) {
		if (counter == elems.length) resize();
		elems[counter++] = e;
	}

	public void insertAt(E e, int pos) {
		if (counter == elems.length) resize();
		for(int i = counter-1; i >= pos; i--)
			elems[i+1] = elems[i];
		elems[pos] = e;
		counter++;
	}

	public void removeLast() {
		elems[--counter] = null;
	}

	public void removeAt(int pos) {
		for(int i = pos; i< counter -1; i++)
			elems[i] = elems[i+1];
		elems[--counter] = null;
	}

	public boolean searchForward(E e) {
		return searchIndexOf(e) != -1;
	}

	public boolean searchBackward(E e) {
		// TODO a completar
		return false;
	}

	public int searchIndexOf(E e) {
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i<counter && !found)
			if (elems[i].equals(e))
				found = true;
			else
				i++;
		if (found) result = i;
		return result;
	}

	public E get(int pos) {
		return elems[pos];

	}

	public int size() {
		return counter;

	}

	public Iterator<E> iterator() {
		return new ArrayIterator<E>(elems, counter);

	}

	@SuppressWarnings("unchecked")
	private void resize() {
		E tmp[] = (E[]) new Object[2*elems.length];
		for (int i=0;i<counter; i++)
			tmp[i] = elems[i];
		elems = tmp;
	}
}
