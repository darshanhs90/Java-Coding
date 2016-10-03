package hackerRank.CrackingTheCodingInterview;

import java.util.Scanner;

public class _01ArraysLeftRotation {

		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			int k = in.nextInt();
			int a[] = new int[n];
			for(int a_i=0; a_i < n; a_i++){
				a[a_i] = in.nextInt();
			}
			k=k%n;
			a=reverseArr(0,k-1,a);
			a=reverseArr(k,n-1,a);
			a=reverseArr(0,n-1,a);
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i]+" ");
			}
		}
	
		private static int[] reverseArr(int left, int right, int[] a) {
			if(left>right||left<0||right>a.length-1)
				return a;
			while(left<=right)
			{
				int temp=a[left];
				a[left]=a[right];
				a[right]=temp;
				left++;
				right--;
			}
			return a;
		}


}
