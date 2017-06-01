package simplifyPath;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
	private static final String delimiter = "/";
	
	
	public String simplifyPath(String path) {
		LinkedList<String> stack = new LinkedList<String>();
	    StringBuffer temp = new StringBuffer();
	    String tmp;
	    for (int i = 0; i < path.length(); i++) {
	        while (i < path.length() && path.charAt(i) == delimiter.charAt(0)) i++;
	        while (i < path.length() && path.charAt(i) != delimiter.charAt(0)) temp.append(path.charAt(i++));

	        tmp = temp.toString();
	        if (tmp.equals("..") && !stack.isEmpty())  stack.removeLast();
	        else if (!tmp.equals(".") && !tmp.equals("..") && !tmp.equals(""))  stack.addLast(tmp);
	        temp = new StringBuffer();
	    }
	    
	    while (!stack.isEmpty()) {
	    	temp.insert(0, stack.removeLast());
	    	temp.insert(0, delimiter);  
	    }
	    
	    return temp.length() == 0 ? delimiter : temp.toString();
    }
}
