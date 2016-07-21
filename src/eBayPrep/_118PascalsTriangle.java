package LeetCodePractice;

import java.util.ArrayList;
import java.util.List;

public class _118PascalsTriangle {

	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		System.out.println(generate(5));
	}
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> outputList=new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			if(outputList.size()==0){
				ArrayList<Integer> newList=new ArrayList<>();
				newList.add(1);
				outputList.add(newList);
			}
			else{
				ArrayList<Integer> aList=(ArrayList<Integer>) outputList.get(outputList.size()-1);
				ArrayList<Integer> newList=new ArrayList<>();
				for (int j = 0; j < aList.size(); j++) {
					if(j==0 )
					{
						newList.add(aList.get(0));
					}
					else{
						newList.add(aList.get(j-1)+aList.get(j));
					}
				}
				newList.add(aList.get(0));
				outputList.add(newList);
			}
		}
		return outputList;
	}

}

