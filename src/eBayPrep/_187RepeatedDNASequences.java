package eBayPrep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _187RepeatedDNASequences {
	public static void main(String[] args) {
		System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
		
	}

	public static List<String> findRepeatedDnaSequences(String s) {
		List<String> outputList=new ArrayList<>();
		HashSet<String> set=new HashSet<>();
		HashSet<String> outputSet=new HashSet<>();
		for (int i = 0; i <=s.length()-10; i++) {
			String st=s.substring(i,i+10);
			if(st.length()==10 && !set.contains(st))
			{
				set.add(st);
			}
			else if(st.length()==10 && set.contains(st) && !outputSet.contains(st))
			{
				outputList.add(st);
				outputSet.add(st);
			}
		}
		return outputList;
	}
}

