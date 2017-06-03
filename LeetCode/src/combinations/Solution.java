package combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if(n <= 0 || n < k) return result;
        
        solve(n, k, 1, new ArrayList<Integer>(), result);
        return result;
    }
	
	private void solve(int n, int k, int star, List<Integer> item, List<List<Integer>> result){
		if(item.size() == k) {
			result.add(new ArrayList<>(item));
			return;
		}
		
		for(int i = star; i <= n; i++){
			item.add(i);
			solve(n, k, i + 1, item, result);
			item.remove(item.size() - 1);
		}
	}
}
