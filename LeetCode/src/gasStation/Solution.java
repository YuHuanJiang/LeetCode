package gasStation;

public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(isEmtpy(gas) || isEmtpy(cost)) return -1;
		
		int tank = 0, total = 0, start = 0, tmp;
		
		for(int i = 0; i < gas.length; i++) {
			tmp = gas[i] - cost[i];
			total += tmp;
			tank += tmp;
			if(tank < 0) {
				start = i + 1;
				tank = 0;
			}
		}
		
		return total >= 0 ? start : -1;
    }
	
	private boolean isEmtpy(int[] container){
		return container == null || container.length == 0;
	}
}
