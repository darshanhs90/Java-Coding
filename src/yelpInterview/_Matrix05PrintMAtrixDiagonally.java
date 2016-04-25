package yelpInterview;

public class _Matrix05PrintMAtrixDiagonally {
	public static void main(String a[]){
		int mat[][] = {{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16},
				{17, 18, 19, 20},
		};
		printDiagonally(mat);
	}

	private static void printDiagonally(int[][] mat) {
		int row=mat.length;
		int col=mat[0].length;
		for (int line=1; line<=(row + col -1); line++)
		{
			int start_col =  Math.max(0, line-row);
			int count = Math.min(line, Math.min((col-start_col), row));
			for (int j=0; j<count; j++)
				System.out.print(mat[Math.min(row, line)-j-1][start_col+j]+" ");
			System.out.println();
		}
	}



}