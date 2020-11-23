package Nov2020Leetcode;

public class _0551StudentAttendanceRecordI {
	public static void main(String[] args) {
		System.out.println(checkRecord("PPALLP"));
		System.out.println(checkRecord("PPALLL"));
	}

	public static boolean checkRecord(String s) {
		if (s == null || s.length() == 0)
			return true;
		int noOfAs = 0;
		int noOfLs = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'A') {
				noOfLs = 0;
				noOfAs++;
			} else if (c == 'L') {
				noOfLs++;
			} else {
				noOfLs = 0;
			}

			if (noOfLs > 2 || noOfAs > 1)
				return false;
		}
		return true;
	}
}
