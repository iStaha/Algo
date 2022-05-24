package LINKED;

public class LinkedLis {

	private Node head;
	Node tail;
	private int size;

	public LinkedLis() {
		size = 0;
	}
	
	private class Node {

		int value;

		Node next;

		public Node(int value) {
			this.value = value;
		}

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

	}

	public void insertFirst(int val) {
		Node node = new Node(val);
		node.next = head;
		head = node;

		if (tail == null) {
			tail = head;
		}
		size += 1;
	}

	public void insertLast(int val) {
		if (tail == null) {
			insertFirst(val);
			return;
		}
		Node node = new Node(val);
		tail.next = node;
		tail = node;
		size++;
	}

	public void insert(int val, int index) {
		if (index == 0) {
			insertFirst(val);
			return;
		}
		if (index == size) {
			insertLast(val);
			return;
		}

		Node temp = head;
		for (int i = 1; i < index; i++) {
			temp = temp.next;
		}

		Node node = new Node(val, temp.next);
		temp.next = node;

		size++;
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
		System.out.println("END");
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedLis first = new LinkedLis();

		first.insertLast(1);
		first.insertLast(3);
		first.insertLast(5);
		first.insert(4, 1);

		first.display();

		first.reverse();

	
		
		
	//	first.reverseIteratively();
		
		first.display();

	}

	private void reverseIteratively() {
		// TODO Auto-generated method stub
		Node prev = null, next = null;
		Node current = head;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		
	}

	private void reverse() {
		// TODO Auto-generated method stub
		reverseList(head);
	}

	private void reverseList(Node head2) {
		// TODO Auto-generated method stub

		if (head2.next == null) {
			head = head2;
			return;
		}

		reverseList(head2.next);

		Node n = head2.next;
		n.next = head2;
		head2.next = null;

	}

}
