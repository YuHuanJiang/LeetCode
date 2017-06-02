package twoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        int length = nums.length;
        Map<Integer, Integer> container = new HashMap<>();
        
        for(int i = 0; i < length; i++){	
        	if(container.containsKey(target - nums[i])) {
        		result[1] = i;
        		result[0] = container.get(target - nums[i]);
        		return result;
        	} else container.put(nums[i], i);
        }
        
        return result;
    }
}
