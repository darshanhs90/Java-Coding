package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _119PascalsTriangle2 {
	public static void main(String[] args) {
		System.out.println(getRow(0));
	}
	public static List<Integer> getRow(int rowIndex) {
		List<List<Integer>> list=generate(rowIndex+1);
		return list.get(rowIndex);
	}
	public static List<List<Integer>> generate(int numRows) {
		
	}
}
