package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 */
public class _0100LongestSubstringDP {
	public static void main(String[] args) {
		String str= "ABDEFGABEF";
		System.out.println(findLongestSubstringLength(str));	
	}

	private static int findLongestSubstringLength(String str) {

		int n=str.length();
		int cur_length=1,max_length=1;
		int prev_index;
		int []visited=new int[128];
		Arrays.fill(visited,-1);
		visited[str.charAt(0)]=0;
		for (int i = 1; i < n; i++) {
			prev_index=visited[str.charAt(i)];
			if(prev_index==-1||i-cur_length>prev_index)
				cur_length++;
			
			else
			{
				if(cur_length>max_length)
					max_length=cur_length;
				cur_length=i-prev_index;
			}
			visited[str.charAt(i)]=i;			
		}
		return cur_length>max_length?cur_length:max_length;
	}



}
