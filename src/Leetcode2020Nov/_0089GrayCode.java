package Leetcode2020Nov;

import java.util.ArrayList;
import java.util.List;

public class _0089GrayCode {

	public static void main(String[] args) {
		System.out.println(grayCode(0));
		System.out.println(grayCode(1));
		System.out.println(grayCode(2));
		System.out.println(grayCode(3));
	}

	public static List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<Integer>();
		if (n == 0) {
			list.add(0);
			return list;
		}
		list.add(0);
		list.add(1);
		List<Integer> listLeftOut, listRightOut;
		List<String> listCombined = new ArrayList<String>();
		listCombined.add("0");
		listCombined.add("1");
		List<String> listLeft, listRight;
		for (int i = 2; i <= n; i++) {
			listLeft = new ArrayList<String>();
			listRight = new ArrayList<String>();
			listLeftOut = new ArrayList<Integer>();
			listRightOut = new ArrayList<Integer>();
			for (int j = 0; j < listCombined.size(); j++) {
				listLeft.add(0 + "" + listCombined.get(j));
				listLeftOut.add(Integer.parseInt(0 + "" + listCombined.get(j), 2));
				listRight.add(0, 1 + "" + listCombined.get(j));
				listRightOut.add(0, Integer.parseInt(1 + "" + listCombined.get(j), 2));
			}
			listLeft.addAll(listRight);
			listLeftOut.addAll(listRightOut);
			list = new ArrayList<Integer>(listLeftOut);
			listCombined = new ArrayList<String>(listLeft);
		}
		return list;
	}
}
