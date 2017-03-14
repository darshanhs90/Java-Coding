package hackerRank.WeekOfCode29;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w29/challenges/minimal-distance-to-pi
 */
public class _05MinimalDistanceToPi {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long min = in.nextLong();
		long max = in.nextLong();
		// your code goes here
		String pi="3.1415926535897932384626433832795028841971693993751";
		Double piValue=new Double(pi);
		long numer=0;
		long denom=0;
		double minDiff=Double.MAX_VALUE;
		boolean printed=false;
		for (int i = (int) min; i <=max; i++) {
			long minVal=(long) Math.floor(i*3.14159265358978);
			long maxVal=(long) Math.ceil(i*3.14159265358980);
			for (int j = (int) minVal; j <=maxVal; j++) {
				double divVal=j/(double)i;
				double diff=Math.abs(divVal-piValue);
				if(diff==0){
					System.out.println(j+"/"+i);
					printed=true;
					break;
				}
				else if(diff<minDiff)
				{
					minDiff=diff;
					numer=j;
					denom=i;
				}
			}	
		}
		if(!printed)
			System.out.println(numer+"/"+denom);
	}
}