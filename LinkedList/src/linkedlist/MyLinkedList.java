package linkedlist;

public class MyLinkedList<E> implements MyList<E> {
	
	protected int size;
	protected Node<E> head;
	protected Node<E> tail;
	
	/*
	 * Inner class for the nodes of the linked list
	 */
	protected class Node<T> {
		public Node<T> prev;
		public Node<T> next;
		public T value;
		
		Node(T value) {
			this.value = value;
		}
	}
	
	/*
	 * Constructor for creating the Linked List
	 */
	public MyLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	/*
	 * Appends the specified element to the end of this list.
	 * @param e-element to be appended to this list
	 * @return true if the element is added to the list
	 */
	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(int index, E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean conatins(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Gets how many elements are in the list
	 * @return the number of elements in the list 
	 */
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public MyList<E> sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
