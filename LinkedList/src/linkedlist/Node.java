package linkedlist;

/*
 * Inner class for the nodes of the linked list
 */
public class Node<T> {
	public Node<T> prev;
	public Node<T> next;
	public T value;
	
	public Node(T value) {
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}
