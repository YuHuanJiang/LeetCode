package findMinimumInRotatedSortedArray;

public class Solution {
	public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        
        int length = nums.length, pre = nums[0];

        for(int i = 1; i < length; i++) {
        	if(pre > nums[i]) return nums[i];
        	pre = nums[i];
        }
        
        return pre == nums[length - 1] ? nums[0] : pre;
    }
}
