package geeksforgeeks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;






/*
 * http://www.geeksforgeeks.org/amazon-interview-set-23/
 * Given a file with many product name of an company.
 * You have to find out unique name in the file.
 * Suppose mobile,laptop,notepad,desktop,pen,mobile,pen .. etc is given we
 * have to print laptop,notepad,desktop.
 * Pen and mobile should be remove due to duplicity. 
 */;
 public class _01AmazonInterview_23_01 {
	 public static void main(String[] args) {
		String inputArray[]={"mobile","laptop","notepad","desktop","pen","mobile","pen"};
		HashMap<String,Integer> elementMap=new HashMap<String,Integer>();
		for (int i = 0; i < inputArray.length; i++) {
			if(elementMap.containsKey(inputArray[i])){
				elementMap.put(inputArray[i],1);
			}
			else{
				elementMap.put(inputArray[i],0);
			}
		}
		
		Set<Entry<String, Integer>> set=elementMap.entrySet();
		Iterator itr=set.iterator();
		while(itr.hasNext()){
			Entry<String, Integer> entry=(Entry<String, Integer>) itr.next();
			if(entry.getValue()==0){
				System.out.println(entry.getKey());
			}
		}
		 
	 }
 }