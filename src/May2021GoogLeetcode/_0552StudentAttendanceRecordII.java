package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0552StudentAttendanceRecordII {
	public static void main(String[] args) {
		System.out.println(checkRecord(2));
		System.out.println(checkRecord(1));
		System.out.println(checkRecord(10101));
	}

	public static int checkRecord(int n) {
		List<String> output = new ArrayList<String>();
		dfs(0, "", n, output);
		System.out.println(output);
		return output.size();
	}

	public static void dfs(int noOfAbsents, String str, int n, List<String> output) {
		if (noOfAbsents > 1 || str.indexOf("LLL") > -1)
			return;
		if (str.length() == n) {
			output.add(str);
			return;
		}

		dfs(noOfAbsents, str + "P", n, output);
		dfs(noOfAbsents, str + "L", n, output);
		dfs(noOfAbsents + 1, str + "A", n, output);
	}

}
