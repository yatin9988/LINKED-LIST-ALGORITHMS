package LinkedList;

public class linkedlist {

	// default class - accessible within the same package
	class Node {
		int data;
		Node next;

		// Parameterized constructor
		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		// default constructor
		public Node() {

		}
	}

	// accessible within the linkedlist class only
	private Node head;

	// O(1)
	public boolean isEmpty() {
		return head == null;
	}

	// O(n)
	public void display() {

		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("END");
	}

	// O(1)
	public void addFirst(int item) {

		Node nn = new Node(item);

		if (this.isEmpty()) {
			head = nn;
		} else {
			nn.next = head;
			head = nn;
		}
	}

	// O(n)
	public void addLast(int item) {

		Node nn = new Node(item);

		if (head == null)
			head = nn;
		else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = nn;
		}
	}

	// O(n)
	public void addAt(int index, int data) throws Exception {

		if (index < 0)
			throw new Exception("INVALID INDEX");

		Node nn = new Node(data);
		Node temp = head;
		if (this.isEmpty()) {

			if (index == 0) {
				this.addFirst(data);
				return;
			} else {
				throw new Exception("INVALID INDEX");
			}

		}

		if (index == 0) {
			this.addFirst(data);
			return;
		}

		for (int i = 0; i < index - 1; i++) {
			if (temp == null)
				throw new Exception("INVALID INDEX");
			temp = temp.next;
		}
        if(temp==null)
        	throw new Exception("INVALID INDEX");
		Node temp2 = temp.next;
		temp.next = nn;
		nn.next = temp2;
	}
}
