package hackerRank.WeekOfCode29;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w29/challenges/a-circle-and-a-square
 */
public class _04MegaPrimeNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long first = in.nextLong();
		long last = in.nextLong();
		// your code goes here
		long current=first;
		long count=0;
		while(current<=last)
		{
			String str=current+"";
			if(str.charAt(0)=='9'||
					str.charAt(0)=='4'||
					str.charAt(0)=='6'||
					str.charAt(0)=='8'||
					str.charAt(0)=='1')
			{
				long value=(long) Math.pow(10, str.length()-1);
				current=(current/value)*value+value;
			}
			else if(str.contains("1") || 
					str.contains("4") || 
					str.contains("6") || 
					str.contains("8") || 
					str.contains("9")||
					str.contains("0"))
			{
				int index=str.indexOf('1');
				while(index!=-1){
					long value=(long) Math.pow(10, str.length()-1-index);
					current=(current/value)*value+value;
					str=current+"";
					index=str.indexOf('1');
				}
				index=str.indexOf('4');
				while(index!=-1){
					long value=(long) Math.pow(10, str.length()-1-index);
					current=(current/value)*value+value;
					str=current+"";
					index=str.indexOf('4');
				}

				index=str.indexOf('6');
				while(index!=-1){
					long value=(long) Math.pow(10, str.length()-1-index);
					current=(current/value)*value+value;
					str=current+"";
					index=str.indexOf('6');
				}
				index=str.indexOf('8');
				while(index!=-1){
					long value=(long) Math.pow(10, str.length()-1-index);
					current=(current/value)*value+value;
					str=current+"";
					index=str.indexOf('8');
				}
				index=str.indexOf('9');
				while(index!=-1){
					long value=(long) Math.pow(10, str.length()-1-index);
					current=(current/value)*value+value;
					str=current+"";
					index=str.indexOf('9');
				}
				index=str.indexOf('0');
				while(index!=-1){
					long value=(long) Math.pow(10, str.length()-1-index);
					current=(current/value)*value+value;
					str=current+"";
					index=str.indexOf('0');
				}
			}
			else{
				if(isPrime(current)){
					count++;
				}
				current++;
			}
		}
		System.out.println(count);
	}
	private static boolean isPrime(long num) {
		if (num < 2) return false;
		if (num == 2) return true;
		if (num % 2 == 0) return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0) return false;
		return true;
	}

}
