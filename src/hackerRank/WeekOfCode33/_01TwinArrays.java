package hackerRank.WeekOfCode33;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w30/challenges/candy-replenishing-robot
 */
public class _01TwinArrays {
	static int twinArrays(int[] ar1, int[] ar2){
		// Complete this function
		return 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar1 = new int[n];
		int min11=Integer.MAX_VALUE;
		int min21=Integer.MAX_VALUE;
		int index11=Integer.MAX_VALUE;
		int index21=Integer.MAX_VALUE;
		for(int ar1_i = 0; ar1_i < n; ar1_i++){
			int value= in.nextInt();
			ar1[ar1_i] =value;
			if(value<min11){
				min11=value;
				index11=ar1_i;
			}
		}
		int[] ar2 = new int[n];
		for(int ar2_i = 0; ar2_i < n; ar2_i++){
			int value= in.nextInt();
			ar2[ar2_i] =value;
			if(value<min21){
				min21=value;
				index21=ar2_i;
			}
		}
		int min12=Integer.MAX_VALUE;
		int min22=Integer.MAX_VALUE;
		int index12=Integer.MAX_VALUE;
		int index22=Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			//for array 1
			if(i!=index11){
				if(ar1[i]<min12){
					min12=ar1[i];
					index12=i;
				}
			}
			if(i!=index21){
				if(ar2[i]<min22){
					min22=ar2[i];
					index22=i;
				}
			}
		}

		if(index11!=index21){
			System.out.println(min11+min21);
		}
		else{
			System.out.println(Math.min(min11+min22, min21+min12));
		}

	}
}
