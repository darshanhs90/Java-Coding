package Warmup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class _36gemstones {
	public static void main(String[] args) throws Exception {
		BufferedReader scanner=new BufferedReader(new InputStreamReader(System.in));
		int noOfLines=Integer.parseInt(scanner.readLine());
		HashMap<Character,Integer> charcount=new HashMap<Character, Integer>();
		for (int i = 0; i < noOfLines; i++) {
			String line=scanner.readLine();
			for (int j = 0; j < line.length(); j++) {
				if(i==0){
					charcount.put(line.charAt(j),i+1);
				}
				else
				{
					if(charcount.containsKey(line.charAt(j)))
					{
						charcount.put(line.charAt(j),i+1);
					}
				}
			}
			HashMap<Character,Integer> newCount=new HashMap<Character, Integer>(charcount);
			for (Entry<Character, Integer> entry : newCount.entrySet()) {
	            if (entry.getValue()==i) {
	                charcount.remove(entry.getKey());
	            }
	        }
		}
		Iterator iter=charcount.values().iterator();
		int counter=0;
		while(iter.hasNext())
		{
			if((Integer)iter.next()==noOfLines)
				counter++;
		}
		System.out.println(counter);
	}
}
