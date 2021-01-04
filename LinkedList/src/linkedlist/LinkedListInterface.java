package linkedlist;

public interface LinkedListInterface<E> {
	
	boolean add(E e);
	boolean add(int index, E e);
	void clear();
	boolean conatins(Object o);
	boolean equals(Object o);
	E get(int index);
	int indexOf(Object o);
	boolean isEmpty();
	int lastIndexOf(Object o);
	E remove(int index);
	boolean remove(Object o);
	E set(int index, E element);
	int size();
	LinkedListInterface<E> sublist(int fromIndex, int toIndex);
	Object[] toArray();
}
