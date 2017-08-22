package fractionToRecurringDecimal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        if(denominator == 0) return "";
        
        StringBuilder result = new StringBuilder();
        
        if((numerator < 0) ^ (denominator < 0)) result.append('-');
        
        long num = numerator, den = denominator, res;
        num = Math.abs(num);
        den = Math.abs(den);
        res = num / den;
        result.append(res);
        
        long r = (num % den) * 10;
        if(r == 0) return result.toString();
        
        Map<Long, Integer> container = new HashMap<Long, Integer>();
        result.append('.');
        
        while(r != 0) {
        	if(container.containsKey(r)) {
        		int beg = container.get(r);
        		String part1 = result.substring(0, beg);
        		String part2 = result.substring(beg, result.length());
        		result.replace(0, result.length(), "");
        		result.append(part1);
        		result.append('(');
        		result.append(part2);
        		result.append(')');
        		return result.toString();
        	}
        	
        	container.put(r, result.length());
        	res = r / den;
        	result.append(res);
        	r = (r % den) * 10;
        }
        
        return result.toString();
    }
}
