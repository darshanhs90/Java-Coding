package LeetCodePractice;

import java.util.HashMap;

public class _168ExcelSheetColumnTitle {

	public static void main(String[] args) {
		System.out.println(convertToTitle(52));
	}

	public static String convertToTitle(int n) {
		HashMap<Integer, String> elemMap=new HashMap<>();
		for (int i = 1; i <=26; i++) {
			elemMap.put(i, (char)(64+i)+"");
		}	
		if(n<=26)
			return elemMap.get(n);
		StringBuilder sb=new StringBuilder();
		while(n>0)
		{
			n--;
			sb.append(elemMap.get(n%26));
			n=n/26;

		}
		
		return sb.toString();
	}
}

