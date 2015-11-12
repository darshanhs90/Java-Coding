package Codility;


/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/tape_equilibrium
 */

public class _0001TCTapeEquilibrium {

	public static void main(String[] args) {
		System.out.println(minimise(new int[]{3,1,2,4,3}));
	}

	private static int minimise(int[] inputArray) {
		int min=Integer.MAX_VALUE;
		int leftSum=0,rightSum=0;
		for (int i = 0; i < inputArray.length; i++) {
			rightSum+=inputArray[i];
		}
		int diff=0;
		for (int i = 0; i < inputArray.length; i++) {
			leftSum+=inputArray[i];
			rightSum-=inputArray[i];
			diff=Math.abs(leftSum-rightSum);
			if(diff<min)
				min=diff;
		}
		return min;
	}

}