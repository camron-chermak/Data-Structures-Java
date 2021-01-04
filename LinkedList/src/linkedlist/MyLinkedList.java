package linkedlist;

public class MyLinkedList<E> implements LinkedListInterface<E> {
	
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
		
		public Node(T value) {
			this.value = value;
			this.next = null;
			this.prev = null;
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
	 * @return true if the element is added to the list, false otherwise
	 */
	@Override
	public boolean add(E e) {
		
		// Check for null and don't add if null
		if (e == null) {
			return false;
		}
		
		// Create a new Node for this element
		Node<E> n = new Node<E>(e);
		
		// If this is the front of the list then the head will be this node
		if (this.size == 0) {
			this.head = n;
		}
		else {
			// Otherwise go through the list until find an element that is 
			// null and then add it to the list and make this the tail
			Node<E> curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
		
			// Add it to the end of the list
			n.prev = curr;
			curr.next = n;
			this.tail = n;
		}
		
		// Updating the size and returning
		this.size++;
		return true;
	}

	@Override
	public boolean add(int index, E e) {
		
		// Checking for null element
		if (e == null) {
			return false;
		}
		
		// Checking for a bad index
		if (index > this.size || index < 0) {
			return false;
		}
		
		// If adding to the end then just a normal add
		if (index == this.size) {
			return add(e);
		}
		
		// If adding to the beginning of the list have to make it the head
		Node<E> n = new Node<E>(e);
		if (index == 0) {
			n.next = head;
			head.prev = n;
			head = n;
		}
		else {
			
			// Get the node in current spot
			Node<E> curr = this.head;
			for (int i = 0; i < index; i++) {
				curr = curr.next;
			}
		
			// Add our node and push the others back
			n.prev = curr.prev;
			n.next = curr;
			curr.prev.next = n;
			curr.prev = n;
		}
		
		this.size++;
		return true;
	}

	@Override
	public void clear() {
		// Reset the list with size 0 and head and tail being null
		this.size = 0;
		this.head = null;
		this.tail = null;
		
	}

	@Override
	public boolean conatins(Object o) {
		
		// Check if object is null
		if (o == null) {
			return false;
		}
		
		// Checking if list is empty
		if (this.size == 0) {
			return false;
		}
		
		// Go through the list and if it is found return true, otherwise false
		Node<E> curr = this.head;
		while (curr != null) {
			if (curr.value.equals(o)) {
				return true;
			}
			curr = curr.next;
		}
		
		// If it makes it here it means it was not found
		return false;
	}

	@Override
	public E get(int index) {
		
		// If bad index return null
		if (index < 0 || index > this.size) {
			return null;
		}
		
		// Go through list to get the Node with the correct index
		Node<E> curr = this.head;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}
		
		return curr.value;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		
		if (this.size == 0) {
			return true;
		}
		
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
	public LinkedListInterface<E> sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		
		// String for holding return value
		String returnString = "";
		
		// If size is 0 return empty string
		if (size == 0) {
			return returnString;
		}
		
		// Go through the list and add elements of the list to the
		// return string separated by -->
		Node<E> curr = this.head;
		while (curr.next != null) {
			returnString += curr.value.toString() + " --> ";
			curr = curr.next;
		}
		returnString += curr.value.toString();
		
		// Return the string
		return returnString;
	}

}
