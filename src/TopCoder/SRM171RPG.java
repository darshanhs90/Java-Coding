package TopCoder;

import java.util.Arrays;

/*
 * SRM 171 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1944&rd=4660
 */



public class SRM171RPG {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(dieRolls(new String[]{"3d6"})));
		System.out.println(Arrays.toString(dieRolls(new String[]{"3d4","1d6"})));
		System.out.println(Arrays.toString(dieRolls(new String[]{"6d5","10d10","10d20"})));
		System.out.println(Arrays.toString(dieRolls(new String[]{"1d2","2d2","4d2","6d2","8d2"})));
	}
	public static int[] dieRolls(String[] dice){
		int min=0;
		double avgVal=0;
		int max=0;
		for (int i = 0; i < dice.length; i++) {
			String splitArray[]=dice[i].split("d");
			int n=Integer.parseInt(splitArray[0]);
			int x=Integer.parseInt(splitArray[1]);
			min+=1*n;
			max+=n*x;
			avgVal+=((n)*(x+1)/(double)2);
		}
		int outputArr[]=new int[3];
		outputArr[0]=min;
		outputArr[2]=(int)(Math.floor(avgVal));
		outputArr[1]=max;
		return outputArr;
	}
}
