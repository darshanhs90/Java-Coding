package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _089GrayCode {
	public static void main(String[] args) {
		System.out.println(grayCode(2));
	}
	public static List<Integer> grayCode(int n) {
		List<String> list=new ArrayList<>();
		if(n==0)
			list.add("0");
		if(n==1||n>1)
		{
			list.add("0");
			list.add("1");
		}
		for (int i = 2; i <=n; i++) {
			List<String> tempList=new ArrayList<>();
			for (int j = 0; j < list.size(); j++) {
				if(j%2==0)
				{
					tempList.add(list.get(j)+"0");
					tempList.add(list.get(j)+"1");
				}
				else{
					tempList.add(list.get(j)+"1");
					tempList.add(list.get(j)+"0");
				}
			}
			list=tempList;
		}
		List<Integer> outputList=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			outputList.add(Integer.parseInt(list.get(i),2));
		}
		return outputList;
	}
}