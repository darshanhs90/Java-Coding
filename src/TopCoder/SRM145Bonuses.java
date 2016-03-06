package TopCoder;

import java.util.Arrays;

/*
 * SRM 145 Div1
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1677&rd=4530
 */



public class SRM145Bonuses {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getDivision(new int[]{1,2,3,4,5})));
		System.out.println(Arrays.toString(getDivision(new int[]{5,5,5,5,5,5})));
		System.out.println(Arrays.toString(getDivision(new int[]{485, 324, 263, 143, 470, 292, 304, 188, 100, 254, 296,
				255, 360, 231, 311, 275,  93, 463, 115, 366, 197, 470})));
	}
	public static int[] getDivision(int[] points){
		int[] outputArray=new int[points.length];
		int total=0;
		for (int i = 0; i < points.length; i++) {
			total+=points[i];
		}
		double percentageDiff[]=new double[points.length];
		double extraBonus=0;
		for (int i = 0; i < percentageDiff.length; i++) {
			double divVal=points[i]*100/(float)total;
			outputArray[i]=(int)Math.floor(divVal);
			extraBonus+=divVal-outputArray[i];
		}
		extraBonus=(Math.ceil(extraBonus)-extraBonus)>(-Math.floor(extraBonus)+extraBonus)?Math.floor(extraBonus):Math.ceil(extraBonus);
		boolean visited[]=new boolean[points.length];
		while(extraBonus>0.0){
			int index=findMax(points,visited);
			outputArray[index]++;
			visited[index]=true;
			extraBonus--;
		}
		return outputArray;
	}
	private static int findMax(int[] points, boolean[] visited) {
		int max=Integer.MIN_VALUE;
		int index=-1;
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i])
			{
				if(points[i]>max){
					max=points[i];
					index=i;
				}
			}
		}
		return index;
	}
}
