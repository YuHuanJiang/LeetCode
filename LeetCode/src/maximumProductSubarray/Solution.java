package maximumProductSubarray;

public class Solution {
	public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int result = nums[0], max = nums[0], min = nums[0], t_max, t_min, tmp;
        
        for(int i = 1; i < nums.length; i++) {
        	tmp = nums[i];
        	t_max = Math.max(max * tmp, min * tmp);
        	t_min = Math.min(max * tmp, min * tmp);
        	max = Math.max(t_max, tmp);
        	min = Math.min(t_min, tmp);
        	result = Math.max(result, max);
        }
        
        return result;
    }
}
