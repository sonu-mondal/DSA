package LinkedList_Int;

import LinkedList_Int.*;

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
	public void addAtEnd(int data) {
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
	public void addAtBeginning(int data) {
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
		public String searchElement(int key) {
			Node temp=this.head;
			while(temp!=null) {
				if(temp.getData()==(key)) {
					return "present";
				}
				else {
					temp=temp.getNext();
				}
			}
			return "not present";
		}
		
		//search/finding an element in a LL
		public Node find(int key) {
			Node temp=this.head;
			while(temp!=null) {
				if(temp.getData()==(key)) {
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
		
		public void insert(int data, int dataBefore) {
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
		public void insert1(int data, int index) {
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
		public int deleteFirst() {
			if(this.head==null) {
				this.tail=null;
			}
			int value=this.head.getData();
			head=head.getNext();
			return value;
		}
		
		//Delete last element of LL
		public int deleteLast() {
			if(this.head==null) {
				this.tail=null;
			}
			if(length()<=1) {
				return deleteFirst();
			}
			int temp=this.tail.getData();
			Node previousElement=this.head;
			while(previousElement.getNext().getNext()!=null) {
				previousElement=previousElement.getNext();
			}
			previousElement.setNext(null);
			tail=previousElement;
			return temp;
		}
		
		//or 2nd method to delete last element of LL
		public int deleteLast1() {
			if(length()<=1) {
				return deleteFirst();
			}
			Node secondLast=get(length()-2);
			int value=tail.getData();
			this.tail=secondLast;
			tail.setNext(null);
			return value;
		}
		
		//Delete element at particular index
		public int deleteAtIndex(int index) {
			int element=head.getData();
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
		public int deleteAtIndex1(int index) {
			if(index==0) {
				return deleteFirst();
			}
			if(index==length()) {
				return deleteLast();
			}
					
			Node previous=get(index-1);
			int value=previous.getNext().getData();
			previous.setNext(previous.getNext().getNext());
			return value;
			
		}
		
		//inserting element using recusrion
		public void insertUsingRecursion(int data, int index) {
			//head=... because we need to update the head if ant element is inserted at 0th position 
			//or else the head remain as it was
			head=insertUsingRecursion(data, index, this.head);
		}
		
		private Node insertUsingRecursion(int data, int index, Node node) {
			if(index==0) {//index=0 means if we moved to position where we need to insert the data
				//otherwise we will move to next index and decrement the index value till it become 0
				Node newNode=new Node(data, node);
				return newNode;				
			}
			node.setNext(insertUsingRecursion(data, index-1, node.getNext()));
			return node;
		}
		
		//## Remove duplicates from the LL
		public void removeDuplicates() {
			Node node=this.head;
			while(node.getNext()!=null) {
				if(node.getData()==(node.getNext().getData())) {
					node.setNext(node.getNext().getNext());
				}
				else {
					node=node.getNext();
				}
				if(node.getNext()==null) {
					tail=node;
					tail.setNext(null);
				}
			}
		}

	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.addAtEnd(1);
		list.addAtEnd(3);
		list.addAtEnd(34);
		list.addAtEnd(8);
		list.addAtEnd(6);
		list.addAtEnd(90);
		
		System.out.println("Added the element to the linkedlist");
		System.out.println("Displaying the linked list element");
		list.display();
		
		System.out.println();
		System.out.println("Length of linked list is : "+list.length());
		
		System.out.println();
		System.out.println("Adding the data to the beginning of the linked list");
		list.addAtBeginning(78);
		list.addAtBeginning(5);
		list.display();
		
		System.out.println();
		System.out.println("The key is : "+list.searchElement(5));
		
		System.out.println();
		System.out.println("Inserting element in LL");
		list.insert(17,8);
		list.display();
		
		System.out.println();
		System.out.println("Inserting element in LL when index is given");
		list.insert1(77, list.length());
		list.insert1(777, 0);
		list.insert1(7777, 5);
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
		
		
		//Inserting using recursion
		System.out.println();
		System.out.println("Insert operation using recursion");
		list.insertUsingRecursion(656, 0);
		list.display();
		
		//Creating another list to perform remove duplicate operation
		//given list is in sorted order
		LinkedList list2=new LinkedList();
		list2.addAtEnd(22);
		list2.addAtEnd(22);
		list2.addAtEnd(33);
		list2.addAtEnd(33);
		list2.addAtEnd(44);
		list2.addAtEnd(44);
		list2.addAtEnd(44);
		list2.addAtEnd(55);
		
		
		System.out.println();
		System.out.println("List before removing duplicates");
		list2.display();
		System.out.println("List after removing the duplicates");
		list2.removeDuplicates();
		list2.display();
		

	}

}
