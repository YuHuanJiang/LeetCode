package wordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
	private static final char start = 'a';
	private static final char end = 'z';
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(isEmtpy(beginWord) || isEmtpy(endWord) || beginWord.length() != endWord.length()) return 0;

        Set<String> set = new HashSet<String>(wordList);
        if (set.contains(beginWord)) set.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        int level = 1, curnum = 1, nextnum = 0;
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            curnum--;
  
            for (int i = 0; i < word.length(); i++) {
                char[] wordunit = word.toCharArray();
                for (char j = start; j <= end; j++) {
                    wordunit[i] = j;
                    String temp = new String(wordunit);
  
                    if (set.contains(temp)) {
                        if (temp.equals(endWord)) return level + 1;  
                        nextnum++;
                        queue.add(temp);
                        set.remove(temp);
                    }
                }
            }
            if (curnum == 0) {
                curnum = nextnum;
                nextnum = 0;
                level++;
            }
        }
        return 0;
    }
	
	private boolean isEmtpy(String str){
		return str == null || str.length() == 0;
	}
}
