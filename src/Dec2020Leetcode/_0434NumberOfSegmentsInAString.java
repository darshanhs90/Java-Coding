package Dec2020Leetcode;

public class _0434NumberOfSegmentsInAString {

	public static void main(String[] args) {
		System.out.println(countSegments("Hello, my name is John"));
		System.out.println(countSegments("Hello"));
		System.out.println(countSegments("love live! mu'sic forever"));
		System.out.println(countSegments(""));
		System.out.println(countSegments(", , , ,        a, eaefa"));
	}

	public static int countSegments(String s) {
		s = s.trim();
		String sArr[] = s.split(" ");
		int count = 0;
		for (int i = 0; i < sArr.length; i++) {
			if (sArr[i].trim().length() > 0)
				count++;
		}
		return count;
	}

}
