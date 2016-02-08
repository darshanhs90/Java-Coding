package hackerRank.Java.Collections;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/phone-book
 */

public class _04JavaMap {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		HashMap<String,String> phoneMap=new HashMap<>();
		for (int i = 0; i < noOfTestCases; i++) {
			String name=scanner.nextLine().trim();
			String number=scanner.nextLine().trim();
			phoneMap.put(name,number);
		}
		while(scanner.hasNext())
		{
			String testString=scanner.nextLine();
			if(phoneMap.containsKey(testString))
				System.out.println(testString+"="+phoneMap.get(testString));
			else
				System.out.println("Not found");
		}
	}
}