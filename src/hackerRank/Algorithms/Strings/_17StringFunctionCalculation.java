package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/string-function-calculation
 */
public class _17StringFunctionCalculation {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputString=scanner.nextLine();
		System.out.println(findMAxStringFunction(inputString));
	}

	private static int findMAxStringFunction(String input) {
		int max=0;
		HashSet<String> setString=new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			for (int j = i; j < input.length(); j++) {
				String subStringInput=input.substring(i,j+1);
				if(!setString.contains(subStringInput))
				{
					setString.add(subStringInput);
					int count=countOccurences(input,subStringInput);
					if(count*subStringInput.length()>max)
						max=count*subStringInput.length();
				}
			}
		}
		return max;
	}

	private static int countOccurences(String mainString,String pattern) {
		if(mainString.indexOf(pattern)!=-1)
		{
			int count=0;
			int index=mainString.indexOf(pattern, 0);
			while(index!=-1 && index<mainString.length())
			{
				count++;
				index=mainString.indexOf(pattern, index+1);
			}
			return count;
		}
		else
			return -1;
	}
}
