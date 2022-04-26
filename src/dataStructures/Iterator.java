package dataStructures;

public interface Iterator<E> {
	/**
	 * Vai para o inicio da coleccao de elementos
	 */
	void rewind();
	
	/**
	 * Devolve <code>true</code> se existirem mais elementos a visitar, 
	 * ou <code>false</code>, caso contrario
	 * @return se existem mais elementos a visitar
	 */
	boolean hasNext();
	
	/**
	 * Devolve o proximo elemento
	 * @return proximo elemento
	 */
	E next();
}
