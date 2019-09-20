package LinkedList;

public class linkedlistClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        linkedlist list = new linkedlist();
        list.addAt(0,0);
        list.addLast(10);
        list.addFirst(20);
        list.addAt(4,11);
        list.display();
	}

}
