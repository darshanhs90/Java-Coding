package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class _40biggerIsGreater {
	static HashMap<String,Integer> elementDiffMap;
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.readLine());
		elementDiffMap=new HashMap<String, Integer>();
		for (int i = 0; i < noOfTestCases; i++) {
			String w=scanner.readLine();
			
			findLongestSequenceIndexes(w);
			getMaxIndex();
			swapElement();
			sortSuffix();
		}
	}
	private static void findLongestSequenceIndexes(String w) {
		elementDiffMap=new HashMap<String, Integer>();
		
		for (int i = 0; i < w.length(); i++) {
			
		}
	}
	private static void sortSuffix() {


	}

	private static void swapElement() {


	}

	private static void getMaxIndex() {


	}


}
//find longest decreasing sequence
//find element greater then pivot but but smaller in the sequence
//swap it
//sort the suffix
