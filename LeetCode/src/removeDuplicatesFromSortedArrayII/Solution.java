package removeDuplicatesFromSortedArrayII;

public class Solution {
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length < 2) return nums.length;
		
		int pre = 1, current = 2;
		int length = nums.length;
		
		while(current < length) {
			if(!(nums[current] == nums[pre] && nums[current] == nums[pre - 1])) {
				pre++;
				nums[pre] = nums[current];
			}
			current++;
		}
		
		return pre + 1;
    }
}
