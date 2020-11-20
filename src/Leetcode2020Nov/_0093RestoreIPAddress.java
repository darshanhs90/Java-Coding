package Leetcode2020Nov;

import java.util.ArrayList;
import java.util.HashSet;
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
		if (s.length() > 12 || s.length() < 4)
			return output;
		restoreIpAddresses("", s, s.length(), output, new HashSet<String>());
		return output;
	}

	public static void restoreIpAddresses(String currString, String s, int length, List<String> output,
			HashSet<String> set) {
		String concatString = currString + s;
		if (!set.contains(concatString) && concatString.length() == length + 3 && isValid(concatString)) {
			set.add(concatString);
			output.add((currString + s).replaceAll(",", "."));
			return;
		}
		if (s.length() == 0 || currString.length() > length + 3)
			return;

		for (int i = 1; i <= s.length(); i++) {
			String subString = s.substring(0, i);
			if (currString.length() > 0) {
				String subStringLater = s.substring(i, s.length());
				if (subString.length() < 4)
					restoreIpAddresses(currString + "," + subString, subStringLater, length, output, set);
			} else {
				if (subString.length() < 4)
					restoreIpAddresses(s.substring(0, i), s.substring(i, s.length()), length, output, set);
			}
		}
	}

	public static boolean isValid(String currString) {

		if (currString.length() < 7 || currString.length() > 15)
			return false;

		String[] parts = currString.split(",");
		if (parts.length > 4)
			return false;

		for (int i = 0; i < parts.length; i++) {
			if (parts[i].length() == 0 || (parts[i].length() > 1 && parts[i].charAt(0) == '0') || parts[i].length() > 3)
				return false;
			if (Integer.parseInt(parts[i]) > 255)
				return false;
		}

		return true;
	}
}
