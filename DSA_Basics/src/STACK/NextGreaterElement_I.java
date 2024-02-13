package STACK;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//concept is : we use hash map where key will be each element of num2 and value will be next greater element 
//element of num2
//we use stack to store the each next greater element and will compare the each element of num2 with its next greater
//element of num2 if its less then we ass that less to the key and next greater as the value to the map
public class NextGreaterElement_I {
	public static int[] nextGreaterElement_I(int[] arr1, int[] arr2) {
		int n=arr1.length;
		int m=arr2.length;
		int[] ans=new int[n];
		Stack<Integer> stack=new Stack<>();
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		
		for(int num:arr2) {
			while(!stack.isEmpty() && stack.peek()<num) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}
		
		for(int i=0;i<n;i++) {
			if(map.containsKey(arr1[i])) {
				arr1[i]=map.get(arr1[i]);
			}
			else {
				arr1[i]=-1;
			}
		}
		return arr1;
	}

	public static void main(String[] args) {
		int[] arr1= {2,4};
		int[] arr2= {1,2,3,4};
		int[] ans=nextGreaterElement_I(arr1, arr2);
		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i]+" ");
		}
		
		

	}

}
