package reverseWordsInAString;

public class Solution {
	private static final String empty = " ";
	public String reverseWords(String s) {
        if(isEmtpy(s)) return "";

        String[] container = s.split(empty);
        StringBuilder str = new StringBuilder();
        int length = container.length - 1;
        boolean flag = false;
        
        for(int i = length; i >= 0; i--) {
        	if(isEmtpy(container[i])) continue;
        	str.append(container[i]);
        	str.append(empty);
        	flag = true;
        }
        
        if(flag) str.replace(str.length() - 1, str.length(), "");
        
        return str.toString();
    }
	
	private boolean isEmtpy(String str){
		return str == null || str.length() == 0;
	}
}
