package TopCoder;

import java.util.Arrays;

/*
 * SRM 149 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1331&rd=4550
 */



public class SRM165BritishCoins {
	public static int[] coins(int pence){
		int []outputArray=new int[3];
		outputArray[0]=pence/240;
		outputArray[1]=pence%240/12;
		outputArray[2]=pence%240%12;
		return outputArray;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(coins(533)));
		System.out.println(Arrays.toString(coins(0)));
		System.out.println(Arrays.toString(coins(6)));
		System.out.println(Arrays.toString(coins(4091)));
		System.out.println(Arrays.toString(coins(10000)));
	}
}
