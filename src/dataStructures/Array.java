package dataStructures;

public interface Array<E> {
	
	/**
	 * Insere o elemento <code>e</code> na ultima posicao do vector
	 * @param e elemento a inserir no vector
	 */
	void insertLast(E e);

	/**
	 * Insere o elemento <code>e</code> na posicao <code>pos</code> do vector
	 * @param e elemento a inserir no vector
	 * @param pos posicao do vector a inserir o elemento
	 * @pre pos < size()
	 */
	void insertAt(E e, int pos);

	/**
	 * Remove o ultimo elemento do vector
	 * @pre size() > 0
	 */
	void removeLast();
	
	/**
	 * Remove o elemento na posicao <code>pos</code> do vector
	 * @param pos posicao do elemento a remover do vector
	 * @pre pos < size()
	 */
	void removeAt(int pos);

	/**
	 * Procura o elemento <code>e</code> no vector
	 * @param e elemento a procurar do vector
	 * @return <code>true</code> se o elemento existe no vector,
	 * 	     <code>false</code> caso contrario
	 */
	boolean searchForward(E e);
	
	/**
	 * Procura o elemento <code>e</code> no vector
	 * @param e elemento a procurar do vector
	 * @return <code>true</code> se o elemento existe no vector,
	 * 	     <code>false</code> caso contrario
	 */
	boolean searchBackward(E e);

	/**
	 * Procura a posicao do elemento <code>e</code> no vector
	 * @param e elemento a procurar do vector
	 * @return a posicao do elemento no vector,
	 * 			<code>-1</code> caso o elemento nao exista
	 */
	int searchIndexOf(E e);

	/**
	 * Devolve o elemento na posicao <code>pos</code> do vector
	 * @param pos posicao do vector do elemento a devolver
	 * @return o elemento na posicao <code>pos</code>,
	 * @pre pos < size()
	 */
	E get(int pos);

	/**
	 * Devolve o numero de elementos no vector
	 * @return o numero de elementos no vector
	 */
	int size();

	/**
	 * Devolve um iterador os elementos do vector
	 * @return iterador para os elementos 
	 */
	Iterator<E> iterator();
	
	/**
	 * Devolve uma cópia do array com os elementos ordenados
	 * @return array ordenado
	 */
	Array<E> sort();
}
