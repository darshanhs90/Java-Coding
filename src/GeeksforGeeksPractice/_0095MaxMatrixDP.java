package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class _0095MaxMatrixDP {
	public static void main(String[] args) {
		int mat[][] =  {{0, 1, 1, 0, 1}, 
				{1, 1, 0, 1, 0}, 
				{0, 1, 1, 1, 0},
				{1, 1, 1, 1, 0},
				{1, 1, 1, 1, 1},
				{0, 0, 0, 0, 0}};
		printMaxSubSquare(mat);
	}

	private static void printMaxSubSquare(int[][] mat) {
		int s[][]=new int[mat.length][mat[0].length];
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[0].length; j++) {
				if(i==0||j==0)
					s[i][j]=mat[i][j];
				else if(mat[i][j]==1){
					s[i][j]=Math.min(s[i][j-1],Math.min(s[i-1][j],s[i-1][j-1]))+1;
				}
				else
					s[i][j]=0;
			}
		}
		
		int max=Integer.MIN_VALUE,max_i=0,max_j=0;
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[0].length; j++) {
				if(s[i][j]>max)
				{
					max=s[i][j];
					max_i=i;
					max_j=j;
				}
			}
		}
		
		for (int i = max_i; i > max_i-max; i--) {
			for (int j = max_j; j >max_j-max; j--) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
	}



}
