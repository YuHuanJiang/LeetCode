package evaluateReversePolishNotation;

import java.util.LinkedList;

public class Solution {
	private static final String add = "+";
	private static final String sub = "-";
	private static final String mul = "*";
	private static final String div = "/";
	
	public int evalRPN(String[] tokens) {
		if(tokens == null || tokens.length == 0) return 0;
		
        LinkedList<Integer> stack = new LinkedList<>();
        int length = tokens.length;
        String tmp;
        
        for(int i = 0; i < length; i++) {
        	tmp = tokens[i];
        	switch (tmp) {
			case add : add(stack); break;
			case sub : sub(stack); break;
			case mul : mul(stack); break;
			case div : div(stack); break;
			default : stack.addLast(Integer.valueOf(tmp)); break;
			}
        }
        
        return stack.getFirst();
    }
	
	private void add(LinkedList<Integer> stack) {
		stack.addLast(stack.pollLast() + stack.pollLast());
	}
	
	private void sub(LinkedList<Integer> stack) {
		stack.addLast(-(stack.pollLast() - stack.pollLast()));
	}
	
	private void mul(LinkedList<Integer> stack) {
		stack.addLast(stack.pollLast() * stack.pollLast());
	}
	
	private void div(LinkedList<Integer> stack) {
		Integer next = stack.pollLast();
		Integer pre = stack.pollLast();
		stack.addLast(pre / next);
	}
}
