package PracticeLeetCode;

public class _014LongestCommonPrefix {
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
		System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
	}
    public static String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0)
    	{
    		return "";
    	}
    	
    	if(strs.length == 1)
    	{
    		return strs[0];
    	}
    	int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
			minLen = Math.min(strs[i].length(), minLen);
		}
        for (int i = 0; i < minLen; i++) {
        	char startingChar = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if(startingChar != strs[j].charAt(i)) {
					return strs[j].substring(0, i);
				}
			}
		}
        return strs[0].substring(0, minLen);
    }

}
