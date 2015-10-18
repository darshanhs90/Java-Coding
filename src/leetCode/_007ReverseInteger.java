package leetCode;

/*
 * Link : https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class _007ReverseInteger {
	 public static int lengthOfLongestSubstring(String s) {
		int maxLength=0;
		int length=0;
		StringBuilder sb=new StringBuilder();
		 for (int i = 0; i < s.length(); i++) {
			if(sb.toString().contains(s.charAt(i)+""))
			{
				//int elementIndex=sb.indexOf(s.charAt(i)+"");
				
			}
			else{
				sb.append(s.charAt(i)+"");
				length++;
			}
		}
		 return maxLength>length?maxLength:length;        
	}
	 public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcadeftgh"));
	}
}