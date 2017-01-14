package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _118PascalsTriangle {
	public static void main(String[] args) {
		System.out.println(generate(5));
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(numRows<=0)
			return outputList;
		List<Integer> list=new ArrayList<>();
		list.add(1);
		outputList.add(list);
		for (int i = 1; i < numRows; i++) {
			List<Integer> prevList=outputList.get(outputList.size()-1);
			List<Integer> newList=new ArrayList<>();
			for (int j = 0; j <=prevList.size(); j++) {
				if(j==0||j==prevList.size())
				{
					newList.add(1);
				}
				else{
					newList.add(prevList.get(j)+prevList.get(j-1));
				}
			}
			outputList.add(newList);
		}
		return outputList;
	}

}
