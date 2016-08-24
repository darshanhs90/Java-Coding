package hackerRank.HourRank8;

import java.util.Scanner;

public class _01BeautifulBinaryString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		String str=scanner.next();
		int index=0;
		int count=0;
		while(str.indexOf("010", index)!=-1)
		{
			count+=1;
			index=str.indexOf("010", index)+3;
		}
		System.out.println(count);
	}
}

