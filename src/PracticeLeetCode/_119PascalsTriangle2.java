package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _119PascalsTriangle2 {
	public static void main(String[] args) {
		System.out.println(getRow(0));
	}
	public static List<Integer> getRow(int rowIndex) {
		List<List<Integer>> list=generate(rowIndex+1);
		return list.get(rowIndex);
	}
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> outputList=new ArrayList<>();
		if(numRows<=0)
		{
			return outputList;
		}
		List<Integer> list=new ArrayList<>();
		list.add(1);
		outputList.add(list);
		for (int i = 1; i <numRows; i++) {
			List<Integer> newList=outputList.get(outputList.size()-1);
			list=new ArrayList<>();
			for (int j = 0; j < newList.size(); j++) {
				if(j==0)
				{
					list.add(1);
				}
				else{
					list.add(newList.get(j)+newList.get(j-1));
				}
			}
			list.add(1);
			outputList.add(list);
		}
		return outputList;
	}
}
