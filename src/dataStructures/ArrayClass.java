package dataStructures;

import java.util.Arrays;

public class ArrayClass<E> implements Array<E> {
	private static final int SIZE = 50;

	/**
	 * O vector generico de elementos do tipo E.
	 */
	private E[] elems;
	
	/**
	 * O numero de elementos do array.
	 */
	private int counter;

	/**
	 * Construtor com dimensao por defeito.
	 */
	@SuppressWarnings("unchecked")
	public ArrayClass() {
		elems = (E[]) new Object[SIZE];
		counter = 0;
	}

	/**
	 * Construtor com dimensao <code>dimention</code>.
	 * @param dimention - dimensao inicial do array.
	 */
	@SuppressWarnings("unchecked")
	public ArrayClass(int dimention) {
		elems = (E[]) new Object[dimention];
		counter = 0;
	}

	@Override
	public void insertLast(E e) {
		if (counter == elems.length) resize();
		elems[counter++] = e;
	}

	@Override
	public void insertAt(E e, int pos) {
		for(int i = counter-1; i >= pos; i--)
			elems[i+1] = elems[i];
		elems[pos] = e;
		counter++;
	}

	@Override
	public void removeLast() {
		elems[--counter] = null;
	}

	@Override
	public void removeAt(int pos) {
		for(int i = pos; i < counter -1; i++)
			elems[i] = elems[i+1];
		elems[--counter] = null;
	}

	@Override
	public boolean searchForward(E e) {
		return searchIndexOf(e) != -1;
	}

	@Override
	public boolean searchBackward(E e) {
		int i = counter;
		boolean found = false;
		while (i >= 0 && !found)
			if (elems[i].equals(e))
				found = true;
			else
				i--;
		return found;
	}

	@Override
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

	@Override
	public E get(int pos) {
		return elems[pos];
	}

	@Override
	public int size() {
		return counter;
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayIterator<>(elems, counter);
	}
	@Override
	@SuppressWarnings({"unchecked"})
	public Array<E> sort() {
		Array<E> sorted = new ArrayClass<>();
		Iterator<E> it = this.iterator();

		Object[] a = new Object[this.size()];
		for (int i=0; i<this.size(); i++)
			a[i] = it.next();
		Arrays.sort(a, null);
		for (Object e : a)
			sorted.insertLast((E) e);

		return sorted;
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		E tmp[] = (E[]) new Object[2*elems.length];
		for (int i=0;i<counter; i++)
			tmp[i] = elems[i];
		elems = tmp;
	}
					 
}
