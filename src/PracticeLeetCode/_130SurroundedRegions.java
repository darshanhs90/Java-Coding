package PracticeLeetCode;

import java.util.Arrays;

public class _130SurroundedRegions {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		solve(new char[][]{
			{'X','X','X','X'},
			{'X','O','O','X'},
			{'X','X','O','X'},
			{'X','O','X','X'}});
	}
	private static void solve(char[][] cs) {
		if(cs==null||cs.length==0)
			return;
		for (int i = 0; i < cs.length; i++) {
			if(cs[i][0]=='O')
				floodFill(i,0,cs);
			if(cs[i][cs[0].length-1]=='O')
				floodFill(i,cs[0].length-1,cs);
		}
		for (int i = 0; i < cs[0].length; i++) {
			if(cs[0][i]=='O')
				floodFill(0,i,cs);
			if(cs[cs.length-1][i]=='O')
				floodFill(cs.length-1,i,cs);
		}
		for (int i = 0; i < cs.length; i++) {
			for (int j = 0; j < cs[0].length; j++) {
				if(cs[i][j]=='O')
					cs[i][j]='X';
				else if(cs[i][j]=='#')
					cs[i][j]='O';
			}
			System.out.println(Arrays.toString(cs[i]));
		}
	}
	private static void floodFill(int i, int j, char[][] cs) {
		if(i<0||j<0||i>cs.length-1||j>cs[0].length-1||cs[i][j]!='O')
			return;
		cs[i][j]='#';
		floodFill(i+1, j, cs);
		floodFill(i-1, j, cs);
		floodFill(i, j+1, cs);
		floodFill(i, j-1, cs);
	}





}
