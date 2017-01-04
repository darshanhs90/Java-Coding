package PracticeLeetCode;

public class _221MaximalSquare {
	public static void main(String[] args) {
		System.out.println(maximalSquare(new char[][]{
			{'1','0','1','0','0'},
			{'1','0','1','1','1'},
			{'1','1','1','1','1'},
			{'1','0','0','1','0'}
		}));
	}
	public static int maximalSquare(char[][] matrix) {
		if(matrix==null||matrix.length==0)
			return 0;
		int s[][]=new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			s[i][0]=matrix[i][0]=='1'?1:0;
		}
		for (int i = 0; i < matrix[0].length; i++) {
			s[0][i]=matrix[0][i]=='1'?1:0;;
		}
		
		for (int i = 1; i < s.length; i++) {
			for (int j = 1; j < s[0].length; j++) {
				if(matrix[i][j]=='0')
					s[i][j]=0;
				else{
					s[i][j]=Math.min(s[i-1][j],Math.min(s[i][j-1], s[i-1][j-1]))+1;
				}
			}
		}
		int max=0;
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[0].length; j++) {
				max=Math.max(max, s[i][j]);
			}
		}
		return max*max;
	}

}