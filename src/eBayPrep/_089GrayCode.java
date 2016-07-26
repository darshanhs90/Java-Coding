package eBayPrep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _089GrayCode {

	public static void main(String[] args) {
		System.out.println(grayCode(2));
		System.out.println(grayCode(0));
		
	}

	public static List<Integer> grayCode(int n) {
		List<Integer> outputList=new ArrayList<>();
		List<String> oldEntries=new ArrayList<>();
		List<String> newEntries=new ArrayList<>();
		if(n==0){
			outputList.add(0);
			return outputList;
		}
		oldEntries.add("0");
		newEntries.add("1");
		oldEntries.addAll(newEntries);
		for (int i = 2; i <=n; i++) {
			newEntries=new ArrayList<>();
			newEntries.addAll(oldEntries);
			Collections.reverse(newEntries);
			for (int j = 0; j < oldEntries.size(); j++) {
				String str=oldEntries.remove(j);
				oldEntries.add(j,"0"+str);
			}
			for (int j = 0; j < newEntries.size(); j++) {
				String str=newEntries.remove(j);
				newEntries.add(j,"1"+str);
			}
			oldEntries.addAll(newEntries);
		}
		for (int i = 0; i < oldEntries.size(); i++) {
			outputList.add(Integer.parseInt(oldEntries.get(i),2));
		}
		return outputList;
	}
}

