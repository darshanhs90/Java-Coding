package hackerRank.Java.Collections;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Link:https://www.hackerrank.com/challenges/java-hashset
 */

public class _06JavaHashSet {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		Set<String> nameSet=new HashSet<String>();
		for(int i=0;i<noOfTestCases;i++){
			String name=scanner.nextLine();
			if(nameSet.contains(name))
			{
				System.out.println(nameSet.size());
			}
			else{
				nameSet.add(name);
				System.out.println(nameSet.size());
			}
		}
	}
}