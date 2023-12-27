package Doubly_LinkedList;

public class DoublyLinkedList {
	public Node head;
	public Node tail;

	public DoublyLinkedList(Node head, Node tail) {
		super();
		this.head = head;
		this.tail = tail;
	}
	
	public DoublyLinkedList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	
	//add element to the end of the DLL
	public void addAtEnd(int data) {
		Node node=new Node(data);
		node.setNext(null);
		if(this.head==null) {
			node.setPrevious(null);
			this.head=this.tail=node;
		}
		tail.setNext(node);
		node.setPrevious(tail);
		tail=node;
		tail.setNext(null);
		
	}
	
	//add element at the begining of the DLL
	public void addAtBegining(int data) {
		Node node=new Node(data);
		node.setNext(head);
		node.setPrevious(null);
		if(head!=null) {
			head.setPrevious(node);
		}
		head=node;
		
	}
	
	//Displaying the elements of DLL
	public void display() {
		Node temp=this.head;
		while(temp!=null) {
			System.out.print(temp.getData()+" <-> ");
			temp=temp.getNext();
		}
		System.out.print("null");
	}
	
	//display reverse
	public void displayReverse() {
		Node temp=tail;
		while(temp!=null) {
			System.out.print(temp.getData()+" <->");
			temp=temp.getPrevious();
		}
		System.out.print("null");
	}
	
	//length of DLL
	public int length() {
		int count=0;
		Node temp=this.head;
		while(temp!=null) {
			temp=temp.getNext();
			count++;
		}
		return count;
	}
	
	//insert at a particular index
	public void insert(int data, int index) {
		if(index==0) {
			addAtBegining(data);
			return;
		}
		if(index==length()) {
			addAtEnd(data);
			return;
		}
		if(index>length()) {
			System.out.println();
			System.out.println("Node does not exist");
			return;
		}
		Node node=new Node(data);
		Node temp=head;
		for(int i=1;i<index;i++) {
			temp=temp.getNext();
		}
		Node nextTonext=temp.getNext();
		node.setNext(temp.getNext());
		nextTonext.setPrevious(node);
		node.setPrevious(temp);
		temp.setNext(node);
	}

	public static void main(String[] args) {
		DoublyLinkedList list=new DoublyLinkedList();
		System.out.println("adding element at the end of DLL");
		list.addAtEnd(2);
		list.addAtEnd(23);
		list.addAtEnd(56);
		list.addAtEnd(90);
		list.addAtEnd(78);
		list.display();
		
		//add at begining
		System.out.println();
		System.out.println("adding element at the begining of DLL");
		list.addAtBegining(100);
		list.addAtBegining(250);
		list.display();
				
		//displaying element
		System.out.println();
		System.out.println("dispalying in reverse order");
		list.displayReverse();
		
		
		//inserting an element at particular index position
		System.out.println();
		System.out.println("List before inserting element");
		list.display();
		list.insert(1001, 4);
		list.insert(1111, 0);
		list.insert(2023, list.length());
		list.insert(55, 100);//exception case
		System.out.println();
		System.out.println("List after inserting element");
		list.display();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
