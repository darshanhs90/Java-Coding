package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.List;

public class _118PascalsTriangle {
	public static void main(String[] args) {
		System.out.println(generate(5));
	}
	
	
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> outputList=new ArrayList<List<Integer>>();
		if(numRows<1)
			return outputList;
		List<Integer> list=new ArrayList<>();
		list.add(1);
		outputList.add(list);
		for (int i = 2	; i <=numRows; i++) {
			list=outputList.get(outputList.size()-1);
			List<Integer> tempList=new ArrayList<>();
			for (int j = 0; j <=list.size(); j++) {
				if(j==0||j==list.size())
					tempList.add(list.get(0));
				else{
					tempList.add(list.get(j)+list.get(j-1));
				}
			}
			outputList.add(tempList);
		}
		return outputList;
	}
}
