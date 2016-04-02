package Warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class _70snapChatAssessment{
	public static void main(String[] args) {
		System.out.println(Arrays.toString(simpleWords(
				new String[]{"chat","ever","snapchat","snap","salesperson","per","person","sales","son","whatsoever","what","so"})));
		//not working for third test case
		//output
		/*chat
		ever
		snap
		per
		sales
		son
		what
		so*/
	}
	static String[] simpleWords(String[] words) {
		ArrayList<String> outputList=new ArrayList<>();
		HashMap<Integer, String> pointerMap=new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			pointerMap.put(i, words[i]);
		}
		Arrays.sort(words, new compareStringLength());
		System.out.println(Arrays.toString(words));
		boolean flag[]=new boolean[words.length];
		for (int i =0;i<words.length;i++) {
			for (int j = i+1; j < words.length; j++) {
				if(words[i].contains(words[j]))
				{	
					if(flag[i]==true)
						flag[i]=false;
					flag[j]=true;
				}
			}
		}
		for (int i = 0; i < flag.length; i++) {
			if(flag[i])
				System.out.println(words[i]);
		}
		return null;
	}
	public static class compareStringLength implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			int diff = s2.length() - s1.length();
			return diff != 0? diff: s2.compareTo(s1);
		}
	}
}
