package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _089GrayCode {
	public static void main(String[] args) {
		System.out.println(grayCode(1));
	}
	public static List<Integer> grayCode(int n) {
		List<String> list=new ArrayList<String>();
		list.add("0");
		int index=0;
		while(index<n)
		{
			List<String> outputList=new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				if(list.size()%2!=0)
				{
					outputList.add(list.get(i)+"0");
					outputList.add(list.get(i)+"1");
				}
				else{					
					outputList.add(list.get(i)+"1");
					outputList.add(list.get(i)+"0");
				}
			}
			list=outputList;
			index++;
		}
		List<Integer> finalList=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			finalList.add(Integer.parseInt(list.get(i),2));
		}
		return finalList;
	}
}