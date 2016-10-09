package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _119PascalsTriangle2 {
	public List<Integer> getRow(int rowIndex) {
		List<List<Integer>> outputList=new ArrayList<>();
		List<Integer> newList=new ArrayList<>();
		newList.add(1);
		outputList.add(newList);

		for (int i = 0; i < rowIndex; i++) {
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
		return outputList.get(outputList.size()-1);
	}
}
