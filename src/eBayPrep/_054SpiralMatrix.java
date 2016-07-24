package eBayPrep;

import java.util.ArrayList;
import java.util.List;

public class _054SpiralMatrix {

	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][]{ {1,  2,  3,  4,  5,  6},
			{7,  8,  9,  10, 11, 12},
			{13, 14, 15, 16, 17, 18}
		}));
		System.out.println(spiralOrder(new int[][]{ {2,5,8},
			{4,0,-1}
		}));
	}
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> aList=new ArrayList<>();
	    if(matrix==null||matrix.length==0)
	        return aList;
		int top=0,left=0,right=matrix[0].length-1,bottom=matrix.length-1;
		while(top<=bottom && left<=right)
		{
			for (int i = left; i <=right; i++) {
				//System.out.print(matrix[top][i]+"/");
				aList.add(matrix[top][i]);
			}
			//System.out.println();
			top++;

			for (int i = top; i <=bottom; i++) {
				//System.out.print(matrix[i][right]+"/");
				aList.add(matrix[i][right]);
			}
			//System.out.println();
			right--;

			if(top<=bottom){
				for (int i = right; i >=left; i--) {
					//System.out.print(matrix[bottom][i]+"/");
					aList.add(matrix[bottom][i]);
				}
				//System.out.println();
				bottom--;
			}

			if(left<=right){
				for (int i = bottom; i >=top; i--) {
					//System.out.print(matrix[i][left]+"/");
					aList.add(matrix[i][left]);
				}
				//System.out.println();
				left++;
			}
		}
		return aList;
	}
}

