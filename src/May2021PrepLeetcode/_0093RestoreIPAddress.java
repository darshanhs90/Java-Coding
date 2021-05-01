package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0093RestoreIPAddress {

	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("25525511135"));
		System.out.println(restoreIpAddresses("0000"));
		System.out.println(restoreIpAddresses("1111"));
		System.out.println(restoreIpAddresses("010010"));
		System.out.println(restoreIpAddresses("101023"));
	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> lst = new ArrayList<String>();
		dfs(0, s, new ArrayList<String>(), lst);
		return lst;
	}

	public static void dfs(int index, String s, List<String> tempList, List<String> output) {
		if (index == s.length() && tempList.size() == 4) {
			output.add(String.join(".", tempList));
			return;
		}

		if (index >= s.length() || tempList.size() >= 4)
			return;

		for (int i = index; i < index + 3 && i < s.length(); i++) {
			String subString = s.substring(index, i + 1);
			if (subString.length() > 1 && subString.charAt(0) == '0')
				continue;

			int val = Integer.parseInt(subString);
			if (val > 255)
				continue;
			tempList.add(subString);
			dfs(i + 1, s, tempList, output);
			tempList.remove(tempList.size() - 1);
		}
	}
}
