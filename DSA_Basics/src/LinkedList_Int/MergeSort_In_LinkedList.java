package LinkedList_Int;

public class MergeSort_In_LinkedList {
	
	public Node sortList(Node head) {
		if(head==null || head.getNext()==null) {
			return head;
		}
		
		Node mid=getMid(head);
		Node left=sortList(head);
		Node right=sortList(mid);
		
		return merge(left, right);
	}
	
	

	public static Node merge(Node list1, Node list2) {
		Node dummyHead=new Node();
		Node tail=dummyHead;
		while(list1!=null && list2!=null) {
			if(list1.getData()<list2.getData()) {
				tail.setNext(list1);
				list1=list1.getNext();
				tail=tail.getNext();
			}
			else {
				tail.setNext(list2);
				list2=list2.getNext();
				tail=tail.getNext();
			}
		}
		if(list1!=null) {
			tail.setNext(list1);
		}
		else {
			tail.setNext(list2);
		}
		return dummyHead.getNext();
		
	}
	
	
	public Node getMid(Node head) { 
		Node slow=head;
		Node fast=head;
		while(head!=null && head.getNext()!=null) {
			slow=slow.getNext();
			fast=fast.getNext().getNext();
		}
		return slow;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
