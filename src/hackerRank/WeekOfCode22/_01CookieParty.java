package hackerRank.WeekOfCode22;


import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w19/challenges/fix-the-cycles
 */
public class _01CookieParty {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		long noOfGuests=scanner.nextInt();
		long noOfCookies=scanner.nextInt();
		int guests[]=new int[(int) noOfGuests];
		int index=0;
		for (int i =0; i <noOfCookies; i++) {
			guests[index]++;
			index++;
			if(index>=noOfGuests)
				index=0;
		}
		if(noOfGuests%noOfCookies==0)
			System.out.println(0);
		else{
			int max=guests[0];
			for (int i = 0; i < guests.length; i++) {
				if(guests[i]<max)
				{
					index=i;
					break;
				}
			}
			System.out.println(guests.length-index);
		}
	}
}
//3 2->1
//5 2->3
//50 21->29


//2 5->1
//20 51->9