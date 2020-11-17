package Leetcode2020Nov;

import java.util.ArrayList;
import java.util.List;

public class _0043MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("2", "3"));
		System.out.println(multiply("123", "456"));
		System.out.println(multiply("140", "721"));
	}

	public static String multiply(String num1, String num2) {
		if (num1.contentEquals("0") || num2.contentEquals("0"))
			return "0";
		String str = "";
		List<String> list = new ArrayList<String>();
		for (int i = num2.length() - 1; i >= 0; i--) {
			char c = num2.charAt(i);
			StringBuilder sb = new StringBuilder();
			sb = sb.append(str);
			int carry = 0;
			for (int j = num1.length() - 1; j >= 0; j--) {
				char c1 = num1.charAt(j);
				String val = String.valueOf(carry + (Integer.parseInt(c + "") * Integer.parseInt(c1 + "")));
				carry = 0;
				if (val.length() > 1) {
					carry = Integer.parseInt(val.charAt(0) + "");
				}
				sb = sb.append(val.charAt(val.length() - 1));
			}
			if (carry != 0) {
				sb = sb.append(carry);
			}
			list.add(sb.reverse().toString());
			str += "0";
		}

		boolean exit = false;
		int index = 0, carry = 0;
		StringBuilder sb = new StringBuilder();
		while (!exit) {
			exit = true;
			int val = carry;
			carry = 0;
			for (int i = 0; i < list.size(); i++) {
				String listString = list.get(i);
				if (listString.length() - 1 - index > -1) {
					val += Integer.parseInt(listString.charAt(listString.length() - 1 - index) + "");
					exit = false;
				} else {
					exit = exit && true;
				}
			}

			if (exit) {
				carry = val;
				break;
			}

			if (val > 9) {
				String tempString = String.valueOf(val);
				sb = sb.append(tempString.charAt(tempString.length() - 1));
				carry = Integer.parseInt(tempString.charAt(0) + "");
			} else {
				sb = sb.append(val);
			}
			index++;
		}

		if (carry != 0) {
			sb = sb.append(carry);
		}
		return sb.reverse().toString();
	}
}
