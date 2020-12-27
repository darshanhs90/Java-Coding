package Dec2020Leetcode;

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
		List<String> output = new ArrayList<String>();
		dfs(0, s, output, new ArrayList<String>());
		return output;
	}

	public static void dfs(int index, String s, List<String> output, List<String> tempList) {
		if (index >= s.length()) {
			if (tempList.size() == 4) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < tempList.size(); i++) {
					sb.append(tempList.get(i));
					if (i != tempList.size() - 1)
						sb.append(".");
				}
				output.add(sb.toString());
			}
			return;
		}
		if (tempList.size() > 4)
			return;

		StringBuilder sb = new StringBuilder("");
		for (int i = index; i < s.length() && index <= index + 3; i++) {
			sb.append(s.charAt(i));
			if ((sb.charAt(0) == '0' && sb.length() > 1) || Integer.parseInt(sb.toString()) > 255)
				break;
			tempList.add(sb.toString());
			dfs(i + 1, s, output, tempList);
			tempList.remove(tempList.size() - 1);
		}
	}
}
