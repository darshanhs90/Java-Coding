package hackerRank.WeekOfCode33;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w30/challenges/candy-replenishing-robot
 */
public class _02PatternCount {
	static int patternCount(String s){
		// Complete this function
		int count=0;
		boolean startOneFound=false,endOneFound=false,zeroFoundAfter=false;
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if(c=='1'){
				if(startOneFound && zeroFoundAfter){
					count+=1;
					startOneFound=true;
					zeroFoundAfter=false;
				}
				else{
					startOneFound=true;
				}
			}
			else if(c=='0'){
				if(startOneFound){
					zeroFoundAfter = true;
				}
			}
			else{
				startOneFound=false;
				zeroFoundAfter=false;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int a0 = 0; a0 < q; a0++){
			String s = in.next();
			int result = patternCount(s);
			System.out.println(result);
		}
	}
}
