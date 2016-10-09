package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _118PascalsTriangle {
	public static void main(String[] args) {
		System.out.println(generate(5));
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(numRows==0)
			return outputList;
		List<Integer> newList=new ArrayList<>();
		newList.add(1);
		outputList.add(newList);

		for (int i = 1; i < numRows; i++) {
			List<Integer> list=outputList.get(outputList.size()-1);
			newList=new ArrayList<>();
			for (int j = 0; j < list.size()+1; j++) {
				if(j==0||j==list.size())
				{
					newList.add(1);
				}
				else{
					newList.add(list.get(j)+list.get(j-1));
				}
			}	
			outputList.add(newList);
		}
		return outputList;
	}

}
