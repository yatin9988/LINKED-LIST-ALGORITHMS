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
		if (temp == null)
			throw new Exception("INVALID INDEX");
		Node temp2 = temp.next;
		temp.next = nn;
		nn.next = temp2;
	}

	// O(n)
	public void deleteKeyI(int key) {

		Node prev = null;
		Node curr = head;

		while (curr != null) {

			if (curr.data == key) {

				if (prev == null) {
					this.head = curr.next;
					return;
				} else {
					prev.next = curr.next;
				}
			}

			prev = curr;
			curr = curr.next;
		}
	}

	// O(n)
	public void deleteKeyR(int key) {
		deleteKeyR(null, head, key);
	}

	// O(n)
	private void deleteKeyR(Node prev, Node curr, int key) {

		if (curr.data == key) {
			if (prev == null) {
				this.head = curr.next;
			} else {
				prev.next = curr.next;
			}
			return;
		}

		deleteKeyR(curr, curr.next, key);
	}

	// O(1)
	public void removeFirst() throws Exception {

		if (this.isEmpty())
			throw new Exception("UNDERFLOW");

		this.head = this.head.next;

	}

	// O(n)
	public void removeLast() throws Exception {

		if (this.isEmpty())
			throw new Exception("UNDERFLOW");

		if (head.next == null)
			head = head.next;
		else {
			Node temp = head;
			while (temp.next.next != null)
				temp = temp.next;
			temp.next = null;
		}
	}

	// O(n)
	public void removeAt(int index) throws Exception {

		if (this.isEmpty())
			throw new Exception("UNDERFLOW");

		if (index < 0)
			throw new Exception("INVALID INDEX");

		if (index == 0) {
			removeFirst();
			return;
		}

		Node temp = head;
		for (int i = 0; i < index - 1; i++) {

			if (temp == null)
				throw new Exception("INVALID INDEX");
			temp = temp.next;
		}

		if (temp == null || temp.next == null)
			throw new Exception("INVALID INDEX");

		temp.next = temp.next.next;
	}

	// O(1) in java since the garbage collector will take care of removing those
	// nodes from the memory
	public void deleteLL() {
		this.head = null;
	}

	// O(n)
	public int lengthI() {

		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	// O(n)
	public int lengthR() {
		return lengthR(head);
	}

	// O(n)
	private int lengthR(Node temp) {

		if (temp == null)
			return 0;

		return lengthR(temp.next) + 1;
	}

	// O(n)
	public boolean SearchI(int item) {

		Node temp = head;
		while (temp != null) {
			if (temp.data == item)
				return true;
			temp = temp.next;
		}
		return false;
	}

	// O(n)
	public boolean SearchR(int item) {
		return SearchR(head, item);
	}

	// O(n)
	private boolean SearchR(Node temp, int item) {

		if (temp == null)
			return false;

		if (temp.data == item)
			return true;

		return SearchR(temp.next, item);
	}

	// O(n)
	public int nthNodeI(int index) throws Exception {

		if (index < 0)
			throw new Exception("INVALID INDEX");
		Node temp = head;
		for (int i = 0; i < index; i++) {
			if (temp == null)
				throw new Exception("INVALID INDEX");
			temp = temp.next;
		}
		if (temp == null)
			throw new Exception("INVALID INDEX");
		return temp.data;
	}

	// O(n)
	public int nthNodeR(int index) throws Exception {
		return nthNodeR(head, index, 0);
	}

	// O(n)
	private int nthNodeR(Node temp, int index, int count) {
		if (index < 0)
			return -1;

		if (temp == null)
			return -1;

		if (count == index)
			return temp.data;

		return nthNodeR(temp.next, index, count + 1);
	}
}
