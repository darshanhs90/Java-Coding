package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Link : https://leetcode.com/problems/move-zeroes/
 */

public class _022GenerateParentheses {
	public static List<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
	    dfs(result, "", n, n);
	    return result;
	}
	public static void dfs(ArrayList<String> result, String s, int left, int right){
	    if(left > right)
	        return;
	 
	    if(left==0&&right==0){
	        result.add(s);
	        return;
	    }
	 
	    if(left>0){
	        dfs(result, s+"(", left-1, right);
	    }
	 
	    if(right>0){
	        dfs(result, s+")", left, right-1);
	    }
	}
	
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(generateParenthesis(3).toArray()));
	}
}