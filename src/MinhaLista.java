import java.util.Iterator;

interface MinhaLista {
	int size();

	boolean add(Object elemento);

	void add(int index, Object elemento);

	Object get(int index);

	Object remove(int index);

	boolean remove(Object elemento);

	void clear();

	boolean contains(Object elemento);

	int indexOf(Object elemento);

	Iterator iterator();
}
