package LinkedList;

public class LinkedList {
	private Node head;
	private Node tail;//advantage of taking tail is that when we need to add an element at the last of LL 
	//then that we can do in the O(1) complexity i.e constant time , if tail is not there then we need
	//to traverse to last element then need to insert so in that case TC is O(n)
	
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
	
	//adding element at end of linked list
//	algo: create the node with the given data
	//check list is empty or not if empty make the node as the head and tail node
	//else make the link/next of the tail refer to the node
	//make the tail refer to the node or make the node as the tail node
	public void addAtEnd(String data) {
		Node node=new Node(data);
		if(this.head==null) {
			this.head=this.tail=node;
		}
		this.tail.setNext(node);
		this.tail=node;
	}
	
	//Adding elemnt to the beginning of the linked list
//	algo: create the node with the given data
	//check list is empty or not if empty make the node as the head and tail node
	//else add the node to the beginning of the head
	//make the node as the head node
	public void addAtBeginning(String data) {
		Node node=new Node(data);
		if(this.head==null) {
			this.head=this.tail=node;
		}
		node.setNext(this.head);
		this.head=node;
	}
	
	
	//Displaying linkedlist data
	public void display() {
		Node temp=this.head;
		while(temp!=null) {
			System.out.print(temp.getData()+" -> ");
			temp=temp.getNext();
			}
		System.out.println("null");
	}
	
	//Length of linked list
		public int length() {
			int countLength=0;
			if(this.head==null) return countLength;
			Node temp=this.head;
			while(temp!=null) {
				countLength++;
				temp=temp.getNext();
			}
			return countLength;			
		}
		
		//Search element is LL
		public String searchElement(String key) {
			Node temp=this.head;
			while(temp!=null) {
				if(temp.getData().equals(key)) {
					return "present";
				}
				else {
					temp=temp.getNext();
				}
			}
			return "not present";
		}
		
		//search/finding an element in a LL
		public Node find(String key) {
			Node temp=this.head;
			while(temp!=null) {
				if(temp.getData().equals(key)) {
					return temp;
				}
				else {
					temp=temp.getNext();			
				}
			}
			return null;
		}
		
		//inserting an element in LL
		//create node with the given data
		//check if LL is empty or not if empty make the node as the head and tail node
		//else point the earlier nodeBefores next element as the next element of the node.
		//and set the nodeBefores next as the node
		//if nodeBefore is the tail then make the node as the tail
		// if node not found print message
		
		public void insert(String data, String dataBefore) {
			Node node=new Node(data);
			if(this.head==null) {
				this.head=this.tail=node;
			}
			else {
				Node nodeBefore=this.find(dataBefore);
				if(nodeBefore!=null) {
					node.setNext(nodeBefore.getNext());
					nodeBefore.setNext(node);
					if(nodeBefore==this.tail) {
						this.tail=node;
					}
				}
				else {
					System.out.println("Node not found");
				}
				
			}
		}
		
		//or another way to insert element at a paticular index
		public void insert1(String data, int index) {
			Node node=new Node(data);
			if(index==0) {
				addAtBeginning(data);
				
			}
			else if(index==length()) {
				addAtEnd(data);
			}
			else {
							
			Node temp=this.head;
			for(int i=1;i<index;i++) {
				temp=temp.getNext();
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
			}
			
		}
		
		//return the reference of a node if we provide the index position
		public Node get(int index) {
			Node node=head;
			for(int i=0;i<index;i++) {
				node=node.getNext();
			}
			return node;
		}
		
		//Delete first element of LL
		public String deleteFirst() {
			if(this.head==null) {
				this.tail=null;
			}
			String value=this.head.getData();
			head=head.getNext();
			return value;
		}
		
		//Delete last element of LL
		public String deleteLast() {
			if(this.head==null) {
				this.tail=null;
			}
			if(length()<=1) {
				return deleteFirst();
			}
			String temp=this.tail.getData();
			Node previousElement=this.head;
			while(previousElement.getNext().getNext()!=null) {
				previousElement=previousElement.getNext();
			}
			previousElement.setNext(null);
			tail=previousElement;
			return temp;
		}
		
		//or 2nd method to delete last element of LL
		public String deleteLast1() {
			if(length()<=1) {
				return deleteFirst();
			}
			Node secondLast=get(length()-2);
			String value=tail.getData();
			this.tail=secondLast;
			tail.setNext(null);
			return value;
		}
		
		//Delete element at particular index
		public String deleteAtIndex(int index) {
			String element=head.getData();
			Node temp=this.head;
			Node next=null;
			Node previous=null;
			if(index==0) {
				deleteFirst();
			}
			else if(index==length()) {
				deleteLast();
			}
			else {
				for(int i=1;i<index;i++) {
					temp=temp.getNext();
				}
			}
			previous=temp;
			temp=temp.getNext();
			next=temp.getNext();
			previous.setNext(next);
			return temp.getData();
		}
		
		//or 2nd method to delete at particular index element 
		public String deleteAtIndex1(int index) {
			if(index==0) {
				return deleteFirst();
			}
			if(index==length()) {
				return deleteLast();
			}
					
			Node previous=get(index-1);
			String value=previous.getNext().getData();
			previous.setNext(previous.getNext().getNext());
			return value;
			
		}
		
		
	
	
	
	public static void main(String args[]) {
		LinkedList list=new LinkedList();
		list.addAtEnd("Kolkata");
		list.addAtEnd("Mumbai");
		list.addAtEnd("Delhi");
		list.addAtEnd("Bangalore");
		list.addAtEnd("Hyderabad");
		list.addAtEnd("Chennai");
		
		System.out.println("Added the element to the linkedlist");
		System.out.println("Displaying the linked list element");
		list.display();
		
		System.out.println();
		System.out.println("Length of linked list is : "+list.length());
		
		System.out.println();
		System.out.println("Adding the data to the beginning of the linked list");
		list.addAtBeginning("Lotus");
		list.addAtBeginning("Rose");
		list.display();
		
		System.out.println();
		System.out.println("The key is : "+list.searchElement("Chennai"));
		
		System.out.println();
		System.out.println("Inserting element in LL");
		list.insert("Sonu", "Delhi");
		list.display();
		
		System.out.println();
		System.out.println("Inserting element in LL when index is given");
		list.insert1("indexLast", list.length());
		list.insert1("indexFirst", 0);
		list.insert1("indexMid", 5);
		list.display();
		
		System.out.println();
		System.out.println("Deleteing the first element");
		System.out.println("first deleted element is : "+ list.deleteFirst());
		System.out.println("List after deleting first element");
		list.display();
		
		System.out.println();
		System.out.println("Deleteing the last element");
		System.out.println("Last deleted element is : "+ list.deleteLast());
		System.out.println("List after deleting Last element");
		list.display();
//		list.deleteLast();
//		list.display();
		
		//2nd method to delete last element of LL
		System.out.println();
		System.out.println("- 2nd method- Deleteing the last element");
		System.out.println("Last deleted element is : "+ list.deleteLast1());
		System.out.println("List after deleting Last element");
		list.display();
		
		System.out.println();
		System.out.println("Deleteing the particular index element");
		System.out.println("Element deleted is : "+ list.deleteAtIndex(5));
		System.out.println("List after deleting element");
		list.display();
//		list.deleteAtIndex(0);
//		list.display();
//		list.deleteAtIndex(list.length());
//		list.display();
//		list.deleteAtIndex(2);
//		list.display();
//		
		//2nd method
		System.out.println();
		System.out.println("-2nd method- Deleteing the particular index element");
		System.out.println("Element deleted is : "+ list.deleteAtIndex1(5));
		System.out.println("List after deleting element");
		list.display();
		
		
	}

}
