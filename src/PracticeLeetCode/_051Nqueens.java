package PracticeLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _051Nqueens {
	//http://rleetcode.blogspot.com/2014/02/leetcode-n-queens-puzzle-is-problem-of.html


	public static void main(String[] args) {
		System.out.println(solveNQueens(4));
	}
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> result=new ArrayList<> ();
		if (n<1){
			return result;
		}
		List<String> list=new ArrayList<>();
		dfs(0, n, list,result);
		return result;
	}
	private static void dfs(int startRow, int n, List<String> list, List<List<String>> result) {
		if(startRow>=n)
		{
			result.add(new ArrayList<>(list));
			return;
		}

		for (int i = 0; i < n; i++) {
			if(!isValid(startRow,i,n,list))
			{
				continue;
			}
			char[] strArr=new char[n];
			Arrays.fill(strArr, '.');
			strArr[i]='Q';
			list.add(new String(strArr));
			dfs(startRow+1, n, list, result);
			list.remove(list.size()-1);
		}
	}
	private static boolean isValid(int startRow, int currCol,int n, List<String> list) {
		if(startRow>=n)
			return false;
		for (int i = 0; i < startRow; i++) {
			String st=list.get(i);
			int index=st.indexOf("Q");
			if(index==currCol)
				return false;
			int val1=Math.abs(i-startRow);
			int val2=Math.abs(index-currCol);
			if(val1==val2)
				return false;
		}
		return true;
	}



}

