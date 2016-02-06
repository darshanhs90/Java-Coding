package hackerRank.Java.Introduction;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/java-if-else
 */

public class _03JavaIfElse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();            
		String ans="";
		if(n%2==1){
			ans = "Weird";
		}
		else{
			if(n>20 || (n>=2 && n<=5))
				ans="Not Weird";
			else
				ans="Weird";
		}
		System.out.println(ans);
	}
}
