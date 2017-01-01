package PracticeLeetCode;

public class _062UniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePaths(1, 2));
	}

	public static int uniquePaths(int m, int n) {
		if(m<0||n<0)
			return 0;
		if(m==1 && n==1)
			return 1;
		return uniquePaths(m-1, n)+uniquePaths(m, n-1);
	}
}

