package hackerRank.HourRank6;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/contests/hourrank-6/challenges/bear-and-workbook
*/public class _01LisasWorkBook {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int inputArray[]=new int[n];
		for (int i = 0; i < n; i++) {
			inputArray[i]=scanner.nextInt();
		}
		ArrayList<String[]> pages=new ArrayList<>();
		int totalCount=0;
		for (int i = 0; i < inputArray.length; i++) {
			int value=inputArray[i];
			int count=0;
			while(count<value)
			{
				String[] str=new String[k];
				for (int j = count; j <count+k; j++) {
					if(j+1<=value && j+1==pages.size()+1){
						totalCount++;
					}
				}
				count+=k;
				pages.add(str);
			}
		}
		System.out.println(totalCount);
	}
}
