package eBayPrep;

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
		List<List<Integer>> outputList=new ArrayList<>();
		if(numRows==0)return outputList;
		List<Integer> individualList=new ArrayList<>();
		individualList.add(1);
		outputList.add(individualList);
		if(numRows==1)
			return outputList;
		else{
			for (int i = 2; i <=numRows; i++) {
				individualList=outputList.get(outputList.size()-1);
				List<Integer> tempList=new ArrayList<>();
				for (int j = 0; j <=individualList.size(); j++) {
					if(j==0||j==individualList.size())
					{
						tempList.add(individualList.get(0));
					}
					else{
						tempList.add(individualList.get(j)+individualList.get(j-1));
					}
				}
				outputList.add(tempList);
			}
		}
		return outputList;
	}

}

