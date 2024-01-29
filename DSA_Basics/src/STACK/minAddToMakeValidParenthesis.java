package STACK;

import java.util.Stack;

public class minAddToMakeValidParenthesis {
	public int minAddLengthTomakeValid(String str) {
		Stack<Character> stack=new Stack<>();
		for(char ch:str.toCharArray()) {
			if(ch==')') {
				if(!stack.isEmpty() && stack.peek()=='(') {
					stack.pop();
				}
				else {
					stack.pop();
				}
			}
			else {
				stack.pop();
			}
		}
		return stack.size();
	}

	public static void main(String[] args) {
		

	}

}
