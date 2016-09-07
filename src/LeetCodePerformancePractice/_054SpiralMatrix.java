package LeetCodePerformancePractice;

import java.util.List;

public class _054SpiralMatrix {
	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][]{
			{2,5,8},
			{4,0,-1}}));
		System.out.println(spiralOrder(new int[][]{
			{1,2,3},
			{4,5,6},
			{7,8,9}}));
	}
	public static List<Integer> spiralOrder(int[][] matrix) {
		int top=0,left=0,right=matrix[0].length-1,bottom=matrix.length-1;
		
	}
}

