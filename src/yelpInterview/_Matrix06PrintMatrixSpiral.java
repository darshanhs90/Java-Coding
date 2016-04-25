package yelpInterview;

public class _Matrix06PrintMatrixSpiral {
	public static void main(String a[]){
		int mat[][] = { {1,  2,  3,  4,  5,  6},
				{7,  8,  9,  10, 11, 12},
				{13, 14, 15, 16, 17, 18}
		};
		printSpirally(mat);
		mat= new int[][]{ {1,  2,  3,  4,},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		printSpirally(mat);
	}

	private static void printSpirally(int[][] mat) {
		int rowStart=0,rowEnd=mat.length;
		int colStart=0,colEnd=mat[0].length;
		while(rowStart<rowEnd && colStart<colEnd)
		{
			//first row
			for (int i = colStart; i < colEnd; i++) {
				System.out.print(mat[rowStart][i]+" ");
			}
			rowStart++;

			//last col
			for (int i = rowStart; i < rowEnd; i++) {
				System.out.print(mat[i][colEnd-1]+" ");
			}
			colEnd--;
			//last row
			if(rowStart<rowEnd)
			{
				for (int i = colEnd-1; i >=colStart; i--) {
					System.out.print(mat[rowEnd-1][i]+" ");
				}
				rowEnd--;
			}

			//first col
			if(colStart<colEnd)
			{
				for (int i = rowEnd-1; i >=rowStart; i--) {
					System.out.print(mat[i][colStart]+" ");
				}
				colStart++;
			}

		}
		System.out.println();
	}


}