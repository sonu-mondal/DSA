package STACK;

import java.util.Stack;

public class validParanthesis {
	public boolean isValidParenthesis(String str) {
		Stack<Character> stack=new Stack<>();
		for(char ch:str.toCharArray()) {
			if(ch=='(' || ch=='{' || ch=='[') {
				stack.push(ch);
			}
			else {
				if(ch==')') {
					if(stack.isEmpty() || stack.pop()!='(') {
						return false;
					}
				}
				if(ch=='}') {
					if(stack.isEmpty() || stack.pop()!='}') {
						return false;
					}
				}
				if(ch==']') {
					if(stack.isEmpty() || stack.pop()!='[') {
						return false;
					}
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
