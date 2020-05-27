package linkedlist;

public class Driver {

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		System.out.println("Size: " + list.size());
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(10);
		list.add(null);
		System.out.println(list);
		System.out.println("Size: " + list.size());
		list.add(1, 110);
		list.add(0, 11);
		list.add(6, 27);
		System.out.println(list);
		System.out.println("Size: " + list.size());
		System.out.println(list.conatins(1));
		System.out.println(list.conatins(8));
		System.out.println(list.get(2));
		System.out.println(list.get(12));
		

	}

}
