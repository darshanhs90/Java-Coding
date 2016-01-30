package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/ashton-and-string
 */
public class _20AshtonAndString {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String inputString=scanner.nextLine();
			int K=Integer.parseInt(scanner.nextLine());
			HashSet<String> stringSet=new HashSet<>();
			ArrayList<String> stringList=new ArrayList<>();
			for (int j = 0; j < inputString.length(); j++) {
				String substring=inputString.substring(j);
				for (int k = 0; k < substring.length(); k++) {
					String s=substring.substring(0, k+1);
					if(!stringSet.contains(s)){
						stringSet.add(s);
						stringList.add(s);
					}
				}
			}
			Object arr[]=stringList.toArray();
			Arrays.sort(arr);
			System.out.println(Arrays.toString(arr).replaceAll(" ", "").replaceAll("[^A-Za-z0-9]","").charAt(K-1));
		}
	}
}
