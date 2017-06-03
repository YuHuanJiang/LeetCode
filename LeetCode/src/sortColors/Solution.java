package sortColors;

public class Solution {
	public void sortColors(int[] nums) {
		if(nums == null || nums.length < 2) return;
		
		int length = nums.length;
		int count = 0, sum = 0, i = 0;
		
		for(; i < length; i++) {
			if(nums[i] == 1) count++;
			
			sum += nums[i];
		}
		
		sum = (sum - count) / 2;
		count = length - count - sum;
		sum = length - sum;
		
		for(i = 0; i < count; i++) nums[i] = 0;
		for(; i < sum; i++) nums[i] = 1;
		for(; i < length; i++) nums[i] = 2;
    }
}
