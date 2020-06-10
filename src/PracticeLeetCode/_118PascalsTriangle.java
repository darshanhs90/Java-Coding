package PracticeLeetCode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class _118PascalsTriangle {
	public static void main(String[] args) {

	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> outputList = new LinkedList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			if(outputList.size() == 0)
			{
				List<Integer> list = new LinkedList<Integer>();
				list.add(1);
				outputList.add(list);
			}
			else
			{
				List<Integer> prevList =  outputList.get(i);
				Iterator<Integer> iter = prevList.iterator();
				while(iter.hasNext())
				{
					
				}
			}
		}
	}

}
