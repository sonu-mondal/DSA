package STACK;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement_I {
	public static int[] nextGreaterElement_I(int[] arr1, int[] arr2) {
		int n=arr1.length;
		int m=arr2.length;
		int[] ans=new int[n];
		Stack<Integer> stack=new Stack<>();
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		
		for(int i=m-1;i>=0;i--) {
			int element=arr2[i];
			if(stack.isEmpty()) {
				stack.push(-1);
				
				
			}
		}
	}

	public static void main(String[] args) {
		

	}

}
