package compareVersionNumbers;

public class Solution {
	private static final String regex = "\\.";
	private static final int zone = 0;
	private static final int result = 1;
	private static final int error = -1;
	public int compareVersion(String version1, String version2) {
        if(isEmpty(version1) || isEmpty(version2)) return zone;
        
        String[] v1 = version1.split(regex);
        String[] v2 = version2.split(regex);
        
        int len1 = v1.length, len2 = v2.length, i = zone, x1, x2;
        
        while(i < len1 || i < len2) {
        	x1 = i < len1 ? Integer.parseInt(v1[i]) : zone;
        	x2 = i < len2 ? Integer.parseInt(v2[i]) : zone;
        	if(x1 > x2) return result;
        	else if(x1 < x2) return error;
        	else i++;
        }
        
        return zone;
    }
	
	private boolean isEmpty(String str) {
		return str == null || "".equals(str);
	}
}
