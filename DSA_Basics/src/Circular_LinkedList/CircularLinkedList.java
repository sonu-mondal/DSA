package Circular_LinkedList;

public class CircularLinkedList {
	private Node head;
	private Node tail;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	//inserting element at end
	public void addAtEnd(int data) {
		Node node=new Node(data);
		if(head==null) {
			head=tail=node;
			return;
		}
		tail.setNext(node);
		node.setNext(head);
		tail=node;
	}
	
	//delete element
	public void delete(int data) {
		if(head==null) {
			return;
		}
		Node temp=this.head;
		if(temp.getData()==data) {//if head value need to delete then set the nexy element as the head and point the tail to the new head
			head=head.getNext();
			tail.setNext(head);
			return;
		}
		
		do {
			Node next=temp.getNext();
			if(next.getData()==data) {
				temp.setNext(next.getNext());
				break;		
			}
			temp=temp.getNext();
		}
		while(temp!=head);
		
	}
	
	// insert at particular index position
	public void insert(int data, int index) {
		Node node=new Node(data);
		if(index==0 || index==length()) {
			addAtEnd(data);
			return;
		}
		Node temp=this.head;
		for(int i=1;i<index;i++) {
			temp=temp.getNext();
		}
		node.setNext(temp.getNext());
		temp.setNext(node);
		
		
	}
	
	
	
	//displaying element
	public void display() {
		Node temp=this.head;
		while(temp!=tail) {
			System.out.print(temp.getData()+" -> ");
			temp=temp.getNext();
		}
		System.out.print(tail.getData());
	}
	
	//length of CLL
	public int length() {
		Node temp=this.head;
		int count=0;
		do {
				count++;
				temp=temp.getNext();
		}while(temp!=head);
		return count;
		
	}
	
	
	
	public static void main(String[] args) {
		CircularLinkedList list=new CircularLinkedList();
		list.addAtEnd(2);
		list.addAtEnd(23);
		list.addAtEnd(245);
		list.addAtEnd(25);
		list.addAtEnd(90);
		list.addAtEnd(76);
		
		list.display();
		
		//deleting
		System.out.println();
		System.out.println("Before deleting");
		list.display();
		list.delete(90);
	
		System.out.println();
		System.out.println("After deleting");
		list.display();
		System.out.println();
		list.delete(250);
		
		//length
		System.out.println();
		System.out.println("length of CLL "+list.length());
		
		//insert at particular index position
		System.out.println();
		System.out.println("Before inserting");
		list.display();
		System.out.println();
		System.out.println("After inserting element ");
		list.insert(2023, 3);
		list.display();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
