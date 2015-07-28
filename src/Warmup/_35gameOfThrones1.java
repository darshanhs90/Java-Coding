package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class _35gameOfThrones1 {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		String input=(scanner.readLine());
		if(input.length()==1)
		{
			System.out.println("YES");
			System.exit(1);
		}
		HashMap<Character,Integer> charCount=new HashMap<Character, Integer>();
		for (int i = 0; i < input.length(); i++) {
			Character c=input.charAt(i);
			if(charCount.containsKey(c))
				charCount.put(c,charCount.get(c)+1);
			else
				charCount.put(c,1);
		}
		Boolean oddCharEncountered=false;
		Iterator iter=charCount.values().iterator();
		while(iter.hasNext())
		{
			
			if(((int)iter.next())%2!=0)
			{
				if(!oddCharEncountered)
					oddCharEncountered=true;
				else
				{
					System.out.println("NO");
					System.exit(0);
				}
			}
		}
		System.out.println("YES");
		

	}
}
