package June2021GoogLeetcode;

public class _0552StudentAttendanceRecordII {
	public static void main(String[] args) {
		System.out.println(checkRecord(2));
		System.out.println(checkRecord(1));
		System.out.println(checkRecord(10101));
	}

	static int count;

	public static int checkRecord(int n) {
		count = 0;
		dfs("", 0, n);
		return count;
	}

	public static void dfs(String str, long noOfA, int n) {
		if (noOfA > 1)
			return;
		if (str.indexOf("LLL") != -1)
			return;
		if (str.length() == n) {
			count++;
			return;
		}

		dfs(str + "P", noOfA, n);
		dfs(str + "L", noOfA, n);
		dfs(str + "A", noOfA + 1, n);
	}

}
