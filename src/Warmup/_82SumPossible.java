package Warmup;

import java.util.Arrays;

/*
 * Link:https://www.careercup.com/question?id=23884662
 */
public class _82SumPossible {


	public static void main(String a[]){
		System.out.println(isScorePossible(new int[]{3,7},10));
		System.out.println(isScorePossible(new int[]{7,4,6},9 ));
		System.out.println(isScorePossible(new int[]{3,7}, 7));
	}



	public static boolean isScorePossible(int[] points, int value){
		int status [] =new int [value+1];
		status [0]=1;
		for (int i=0;i<points.length;++i){
			for (int j=points[i];j<=value;++j){
				status[j]+=status[j-points[i]];
			}
			System.out.println(Arrays.toString(status));
		}
		return status[value]>0;
	}
}






