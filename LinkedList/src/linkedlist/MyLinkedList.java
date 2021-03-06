package linkedlist;

public class MyLinkedList<E> implements LinkedListInterface<E> 
{
	private int size;
	private Node<E> head;
	private Node<E> tail;
	
	/*
	 * Constructor for creating the Linked List
	 */
	public MyLinkedList() 
	{
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
	public boolean add(E e) 
	{
		// Check for null and don't add if null
		if (e == null) 
		{
			return false;
		}
		
		// Create a new Node for this element
		Node<E> n = new Node<E>(e);
		
		// If this is the front of the list then the head will be this node
		if (this.size == 0) 
		{
			this.head = n;
		}
		else 
		{
			// Otherwise go through the list until find an element that is 
			// null and then add it to the list and make this the tail
			Node<E> curr = head;
			while (curr.next != null) 
			{
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
	public boolean add(int index, E e) 
	{
		// Checking for null element
		if (e == null) 
		{
			return false;
		}
		
		// Checking for a bad index
		if (index > this.size || index < 0) 
		{
			return false;
		}
		
		// If adding to the end then just a normal add
		if (index == this.size) 
		{
			return add(e);
		}
		
		// If adding to the beginning of the list have to make it the head
		Node<E> n = new Node<E>(e);
		if (index == 0) 
		{
			n.next = head;
			head.prev = n;
			head = n;
		}
		else 
		{
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
	public void clear() 
	{
		// Reset the list with size 0 and head and tail being null
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	@Override
	public boolean conatins(Object o) 
	{
		// Check if object is null
		if (o == null) 
		{
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
		
		// Return -1 if o is null
		if (o == null) 
		{
			return -1;
		}
		
		// Keep track of this index
		int index = 0;
		
		// Go through list until object o is found
		Node<E> curr = this.head;
		while (curr != null) 
		{
			if (curr.value.equals(o))
			{
				return index;
			}
			
			index++;
		}
		
		// If o is not found, return -1
		return -1;
	}

	@Override
	public boolean isEmpty() 
	{
		if (this.size == 0) 
		{
			return true;
		}
		
		return false;
	}

	@Override
	public int lastIndexOf(Object o) 
	{
		// Return -1 if o is null
		if (o == null) 
		{
			return -1;
		}
		
		// Keep track of this index
		int index = 0;
		int lastIndex = -1;
		
		// Go through list until object o is found
		Node<E> curr = this.head;
		while (curr != null) 
		{
			if (curr.value.equals(o))
			{
				lastIndex = index;
			}
			
			index++;
		}
		
		return lastIndex;
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
	public E set(int index, E element) 
	{
		// If the index is out of bounds throw indexOutOfBounds Error
		if (index < 0 || index >= this.size) 
		{
			throw new IndexOutOfBoundsException();
		}
		
		// Go through the list to the index
		Node<E> curr = head;
		for (int i = 0; i < index; i++)
		{
			curr = curr.next;
		}
		
		// Save off the current value for returning
		Node<E> retValue = curr;
		
		// Replace the value
		Node<E> replacement = new Node<E>(element);
		curr.prev.next = replacement;
		curr.next.prev = replacement;
		replacement.prev = curr.prev;
		replacement.next = curr.next;
		
		// Return the old value
		return retValue.value;
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
	public Object[] toArray() 
	{
		// Create the correct size array
		Object[] retArray = new Object[this.size];
		
		// Go through the linked list adding the values
		Node<E> curr = head;
		for (int i = 0; i < this.size; i++)
		{
			retArray[i] = curr.value;
		}
		
		return retArray;
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
