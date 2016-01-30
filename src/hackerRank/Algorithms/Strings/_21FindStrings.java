package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/find-strings
 */
public class _21FindStrings {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfStrings=Integer.parseInt(scanner.nextLine().trim());
		ArrayList<String> stringList=new ArrayList<>();
		for (int i = 0; i < noOfStrings; i++) {
			stringList.add(scanner.nextLine().replaceAll(" ",""));
		}
		stringList=findLexicographUnionSet(stringList);
		Object arr[]=(stringList.toArray());
		Arrays.sort(arr);
		int noOfTestCases=Integer.parseInt(scanner.nextLine().replaceAll(" ",""));
		for (int i = 0; i < noOfTestCases; i++) {
			int index=Integer.parseInt(scanner.nextLine().replaceAll(" ",""));
			if(index>stringList.size()){
				System.out.println("INVALID");
				continue;
			}
			System.out.println(findStringIndexed(index-1,stringList));
		}
	}

	private static String findStringIndexed(int index,ArrayList<String> stringList) {
		return stringList.get(index);
	}

	private static ArrayList<String> findLexicographUnionSet(ArrayList<String> stringList) {
		ArrayList<String> outputList=new ArrayList<String>();
		HashSet<String> stringSet=new HashSet<String>();
		for (int i = 0; i < stringList.size(); i++) {
			ArrayList<String> splitStringList=getListOfString(stringList.get(i));
			for (int j = 0; j < splitStringList.size(); j++) {
				if(!stringSet.contains(splitStringList.get(j).replaceAll(" ","")))
				{
					outputList.add(splitStringList.get(j).replaceAll(" ",""));
					stringSet.add(splitStringList.get(j).replaceAll(" ",""));
				}
			}
		}
		return outputList;
	}

	private static ArrayList<String> getListOfString(String string) {
		ArrayList<String> stringList=new ArrayList<String>();
		HashSet<String> stringSet=new HashSet<String>();
		for (int i = 0; i < string.length(); i++) {
			String s=string.substring(i).trim();
			for (int j = 0; j < s.length(); j++) {
				String split=s.substring(0, j+1).trim().replaceAll(" ","");
				if(!stringSet.contains(split.trim()))
				{
					stringList.add(split.trim());
					stringSet.add(split.trim());
				}
			}
		}
		return stringList;
	}
}
