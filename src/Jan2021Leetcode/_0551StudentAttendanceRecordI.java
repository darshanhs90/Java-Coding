package Jan2021Leetcode;

public class _0551StudentAttendanceRecordI {
	public static void main(String[] args) {
		System.out.println(checkRecord("PPALLP"));
		System.out.println(checkRecord("PPALLL"));
	}

	public static boolean checkRecord(String s) {
		if (s == null || s.length() < 2)
			return true;
		char prev = s.charAt(0);
		int noOfAs = prev == 'A' ? 1 : 0;
		int noOfLs = prev == 'L' ? 1 : 0;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'L') {
				noOfLs++;
			} else if (c == 'A') {
				noOfAs++;
				noOfLs = 0;
			} else {
				noOfLs = 0;
			}

			if (noOfLs > 2)
				return false;
			else if (noOfAs > 1)
				return false;
		}
		return true;
	}

}
