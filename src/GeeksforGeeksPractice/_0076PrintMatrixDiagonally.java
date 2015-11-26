package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/print-matrix-diagonally/
 */
public class _0076PrintMatrixDiagonally {

	public static void main(String[] args) {
		int mat[][] = {{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16},
				{17, 18, 19, 20},
		};
		printDiagonally(mat);
	}

	private static void printDiagonally(int[][] mat) {
		int row=mat.length,col=mat[0].length;
		for(int line=0;line<=row+col-1;line++)
		{
			int start_col=Math.max(0, line-row);
			int count=Math.min(Math.min(line,row),col-start_col);
			
			for (int i = 0; i < count; i++) {
				System.out.print(mat[Math.min(row,line)-i-1][start_col+i]+"  ");
			}
			System.out.println();
		}

	}


}
