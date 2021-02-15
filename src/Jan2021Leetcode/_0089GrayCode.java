package Jan2021Leetcode;

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
		List<Integer> output = new ArrayList<Integer>();

		if (n == 0) {
			output.add(0);
			return output;
		} else if (n == 1) {
			output.add(0);
			output.add(1);
			return output;
		}

		List<String> list = new ArrayList<String>();
		list.add("0");
		list.add("1");

		for (int i = 2; i <= n; i++) {
			List<String> listCopy = new ArrayList<String>();

			for (int j = 0; j < list.size(); j++) {
				listCopy.add("0" + list.get(j));
			}

			for (int j = list.size() - 1; j >= 0; j--) {
				listCopy.add("1" + list.get(j));
			}

			list = listCopy;
		}

		for (int i = 0; i < list.size(); i++) {
			output.add(Integer.valueOf(list.get(i), 2));
		}

		return output;
	}
}
