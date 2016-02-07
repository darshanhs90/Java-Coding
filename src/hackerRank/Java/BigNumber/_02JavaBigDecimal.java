package hackerRank.Java.BigNumber;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/java-bigdecimal
 */

public class _02JavaBigDecimal {
	public static void main(String []argv)
	{
		Scanner scanner=new Scanner(System.in);
		int noOfElements=Integer.parseInt(scanner.nextLine());
		String[] numberArray=new String[noOfElements];
		for (int i = 0; i < noOfElements; i++) {
			numberArray[i]=(scanner.nextLine());
		}
		Arrays.sort(numberArray, new Comparator<String>() {
			public int compare(String first, String second) {
				BigDecimal bdFirst = new BigDecimal(first);
				BigDecimal bdSecond = new BigDecimal(second);
				int res = first.compareTo(second);
				return (res == 0) ? res : bdSecond.compareTo(bdFirst);
			}
		});

		for (int i = 0; i<numberArray.length; i++) {
			System.out.println(numberArray[i]);
		}
	}
}
