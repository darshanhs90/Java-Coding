package hackerRank.WeekOfCode28;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Link:https://www.hackerrank.com/contests/w28/challenges/the-great-xor
 */
public class _03LuckyNumberEight {

	static long count=0,longcount=0;
	static Set<String> set=new HashSet<String>();
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String n=in.nextLine();
		String string  = in.nextLine();
		set=new HashSet<>();
		count=0;
		for (int i = 1; i <=string.length(); i++) {
			dfs(string.length(),i,0,"",string);
		}
		System.out.println((long)(count % (Math.pow(10, 9)+7)));
	}

	private static void dfs(int n, int k, int index,String str, String string) {
		if(str.length()==3)
		{
			if(set.contains(str))
				return;
			int length=string.length()-index;
			long num=Long.parseLong(new StringBuilder(str).reverse().toString());
			if(num%8==0)
			{
				int indexNew=length;
				if(indexNew>0)
				{
					count+=Math.pow(2, indexNew);
				}
				else
					count++;
			}
			set.add(str);
			return;
		}
		if(str.length()==k)
		{
			str=new StringBuilder(str).reverse().toString();
			if(Long.parseLong(str)%8==0)
				count++;
			return;
		}
		StringBuilder sb=new StringBuilder(str);
		for (int i = index; i<string.length(); i++) {
			sb.append(string.charAt(string.length()-1-i));
			dfs(n,k,i+1,sb.toString(),string);
			sb.deleteCharAt(sb.length()-1);
		}
	}


}

