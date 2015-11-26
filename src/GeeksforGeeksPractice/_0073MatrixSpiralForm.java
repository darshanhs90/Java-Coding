package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 */
public class _0073MatrixSpiralForm {

	public static void main(String[] args) {
		int a[][] = { {1,  2,  3,  4,  5,  6},
				{7,  8,  9,  10, 11, 12},
				{13, 14, 15, 16, 17, 18}
		};
		printSpiralForm(a);
		System.out.println();
		a=new int[][]{{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}};
			printSpiralForm(a);
	}

	private static void printSpiralForm(int[][] a) {
		int k,l,m,n;
		k=0;
		l=a.length;
		m=0;
		n=a[0].length;
		while(k<l && m<n)
		{
			for (int i = m; i < n; i++) {
				System.out.print(a[k][i]+"/");
			}
			k++;
			for (int i = k; i < l; i++) {
				System.out.print(a[i][n-1]+"/");
			}
			n--;
			if(k<l){
				for (int i = n-1; i >=k; i--) {
					System.out.print(a[l-1][i]+"/");
				}
				l--;
			}
			if(l<m){
				for (int i = l; i >=k; i--) {
					System.out.print(a[i][m]+"/");
				}
				m++;
			}
		}
	}


}
