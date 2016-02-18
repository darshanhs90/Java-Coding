package hackerRank.WeekOfCode19;


import java.util.Scanner;
import java.util.TreeSet;

/*
 * Link:https://www.hackerrank.com/contests/w19/challenges/scalar-products
 */
public class _03ScalarProducts {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String arr[]=scanner.nextLine().split(" ");
		long C=Long.parseLong(arr[0]);
		long M=Long.parseLong(arr[1]);
		long n=Long.parseLong(arr[2]);
		if(n==1)
		{
			System.out.println("0");
			return;
		}
		long inputArr[]=new long[(int) (2*n+2)];
		inputArr[0]=0;
		inputArr[1]=C;
		for (int i = 2; i <inputArr.length; i++) {
			inputArr[i]=(inputArr[i-1]+inputArr[i-2])%M;
		}
		Pair[] pairsArr=new Pair[(int) n];
		int counter=2;
		for (int i = 0; i < n; i++) {
			pairsArr[i]=new Pair(inputArr[counter],inputArr[counter+1]);
			counter+=2;
		}
		TreeSet<Long> ts=new TreeSet<Long>();
		for (int i = 0; i < pairsArr.length; i++) {
			for (int j = 0; j < pairsArr.length; j++) {
				if(i==j)
					continue;
				Pair a=pairsArr[i];
				Pair b=pairsArr[j];
				ts.add((a.a*b.a+a.b*b.b)%M);
			}
		}
		System.out.println(ts.size());
	}
	static class Pair{
		long a,b;
		public Pair(long a,long b) {
			this.a=a;
			this.b=b;
		}
	}
}
