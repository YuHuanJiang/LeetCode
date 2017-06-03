package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        result.add(item);
        if(nums == null || nums.length == 0) return result;
        else {
        	Arrays.sort(nums);
        	for(int i = 1; i <= nums.length; i++){
        		item.clear();
        		solve(nums, 0, i, item, result);
        	}
        }
        return result;
    }
	
	private void solve(int[] nums, int star, int end, List<Integer> item, List<List<Integer>> result){
		if(end == item.size()){
			result.add(new ArrayList<Integer>(item));
			return;
		}
		
		for(int i = star; i < nums.length; i++){
			item.add(nums[i]);
			solve(nums, i + 1, end, item, result);
			item.remove(item.size() - 1);
		}
	}
}
