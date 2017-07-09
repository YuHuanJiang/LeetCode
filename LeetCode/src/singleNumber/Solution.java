package singleNumber;

public class Solution {
	public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int result = 0;
        
        for(int i = 0; i < nums.length; i++) result = result ^ nums[i];
        
        return result;
    }
}
