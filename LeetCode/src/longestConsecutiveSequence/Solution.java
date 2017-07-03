package longestConsecutiveSequence;

import java.util.Arrays;

public class Solution {
	public int longestConsecutive(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		
		Arrays.sort(nums);
		int length = nums.length - 1, next;
		int result = 1, index = 0, size = 1;
		
		while(index < length) {
			next = nums[index + 1];
			if(nums[index] == next) {}
			else if(nums[index] + 1 == next) size++;
			else {
				result = Math.max(result, size);
				size = 1;
			}
			index++;
		}
		
		result = Math.max(result, size);
        return result;
    }
}
