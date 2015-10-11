package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 * Link : https://leetcode.com/problems/pascals-triangle/
 */

public class _118PascalsTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		int a[][]=new int[numRows][numRows];
		for (int i = 0; i < a.length; i++) {
			List<Integer> innerList=new ArrayList<>();
			if(i==0){
				a[i][i]=1;
				innerList.add(a[i][i]);
				list.add(innerList);
				continue;
			}
			for (int j = 0; j <=i; j++) {
				if(j==0 || j==i){
					a[i][j]=1;
					innerList.add(a[i][j]);
				}
				else{
					a[i][j]=a[i-1][j]+a[i-1][j-1];
					innerList.add(a[i][j]);
				}
			}
			list.add(innerList);
		}
		return list;
	}
	public static void main(String[] args) {
		generate(5);
	}
}