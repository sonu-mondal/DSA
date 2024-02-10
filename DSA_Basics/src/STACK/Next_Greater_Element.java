package STACK;

import java.util.Stack;

public class Next_Greater_Element {
	    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
	        Stack<Integer> stack=new Stack<>();
	        int n=nums1.length;
	        int m=nums2.length;
	        int[] ans=new int[m];
	        
	       
	        for(int i=m-1;i>=0;i--) {
	        	int element=nums2[i];
	        	 //if stack is empty then no greater element next
	        	if(stack.isEmpty()) {
	        		stack.push(element);
	        		ans[i]=-1;
	        		continue;
	        	}
	        	//if top of the stack is greatest, then it is the next greater element
	        	if(stack.peek()>element) {
	        		stack.push(element);
	        		ans[i]=stack.peek();
	        		continue;  		
	        		
	        	}
	        	
	        	//remove all element smaller than the element
	        	while(stack.peek()<=element && !stack.isEmpty()) {
	        		stack.pop();
	        	}
	        	if(stack.isEmpty()) {
	        		ans[i]=-1;
	        	}
	        	else {
	        		ans[i]=element;
	        	}
	        	stack.push(element);
	        }
	        return ans;
	    }

	public static void main(String[] args) {
		int[] nums1= {4,1,5,2};
		int[] nums2= {1,3,4,2,5};
		int[] ans=nextGreaterElement( nums1,  nums2);
		
		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i]+" ");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
