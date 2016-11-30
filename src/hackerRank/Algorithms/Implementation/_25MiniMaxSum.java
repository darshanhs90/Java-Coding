package hackerRank.Algorithms.Implementation;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * https://www.hackerrank.com/challenges/mini-max-sum
 */
public class _25MiniMaxSum {
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 	ArrayList<Long> list=new ArrayList<>();
	        long a = in.nextLong();
	        list.add(a);
	        long b = in.nextLong();
	        list.add(b);
	        long c = in.nextLong();
	        list.add(c);
	        long d = in.nextLong();
	        list.add(d);
	        long e = in.nextLong();
	        list.add(e);
	        long sum=a+b+c+d+e;
	        long min=Long.MAX_VALUE,max=Long.MIN_VALUE;
	        for (int i = 0; i < list.size(); i++) {
				min=Math.min(sum-list.get(i), min);
				max=Math.max(sum-list.get(i), max);
			}
	        System.out.println(min+" "+max);
	        
	}
}
