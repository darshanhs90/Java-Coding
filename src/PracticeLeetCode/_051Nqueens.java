package PracticeLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _051Nqueens {
	//http://rleetcode.blogspot.com/2014/02/leetcode-n-queens-puzzle-is-problem-of.html


	public static void main(String[] args) {
		System.out.println(solveNQueens(4));
		//[[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]
	}
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> outputList=new ArrayList<>();
		if(n<=0)
			return outputList;
		List<String> list=new ArrayList<>();
		dfs(0,n,list,outputList);
		return outputList;
	}
	private static void dfs(int startRow, int n, List<String> list, List<List<String>> outputList) {
		if(startRow>=n)
		{
			outputList.add(new ArrayList<>(list));
			return;
		}
		//check columns
		for (int i = 0; i < n; i++) {
			if(!isValid(startRow,i,n,list))
				continue;
			char[] charArr=new char[n];
			Arrays.fill(charArr, '.');
			charArr[i]='Q';
			list.add(new String(charArr));
			dfs(startRow+1,n,list,outputList);
			list.remove(list.size()-1);
		}
	}
	private static boolean isValid(int startRow,int column, int n, List<String> list) {
		if(column>n-1)
			return false;
		for (int i = 0; i < startRow; i++) {
			int index=list.get(i).indexOf("Q");
			if(index==column)
				return false;
			int value1=Math.abs(index-column);
			int value2=Math.abs(i-startRow);
			if(value1==value2)
				return false;	
		}
		return true;
	}



}

