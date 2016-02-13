package hackerEarth.BasicProgramming.StringManipulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/*
 * Link:https://www.hackerearth.com/problem/algorithm/sumit-and-rohil/
*/public class _01SumitAndRohil {
	public static void main(String args[] ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        HashMap<Character,ArrayList<String>> charStartMap=new HashMap<Character,ArrayList<String>>();
        HashMap<Character,ArrayList<String>> charEndMap=new HashMap<Character,ArrayList<String>>();
        int count=0;
        for (int i = 0; i < N; i++) {
			String input=br.readLine().trim();
			String sortedInput=sorter(input);
			char startChar=input.charAt(0);
			char endChar=input.charAt(input.length()-1);
			boolean hasStartString=false,hasEndString=false;
			if(charStartMap.containsKey(startChar))
			{
				hasStartString=check(charStartMap,sortedInput,startChar);
			}
			if(charEndMap.containsKey(endChar))
			{
				hasEndString=check(charEndMap,sortedInput,endChar);
			}
			if(!hasStartString || !hasEndString)
			{
				count++;
				ArrayList<String> aList=charStartMap.containsKey(startChar)?charStartMap.get(startChar):new ArrayList<String>();
				aList.add(sortedInput);
				charStartMap.put(startChar, aList);
				aList=charEndMap.containsKey(endChar)?charEndMap.get(endChar):new ArrayList<String>();
				aList.add(sortedInput);
				charEndMap.put(endChar, aList);
			}
		}
        System.out.println(count);
	}

	private static boolean check(HashMap<Character, ArrayList<String>> charStartMap, String sortedInput,
			char startChar) {
		ArrayList<String> aList=charStartMap.get(startChar);
		return aList.contains(sortedInput);
	}

	private static String sorter(String input) {
		char cArr[]=input.toCharArray();
		Arrays.sort(cArr);
		return new String(cArr);
	}
}
