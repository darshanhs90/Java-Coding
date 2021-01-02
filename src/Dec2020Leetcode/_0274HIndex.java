package Dec2020Leetcode;

import java.util.Arrays;

public class _0274HIndex {

	public static void main(String[] args) {
		System.out.println(hIndex(new int[] { 3, 0, 6, 1, 5 }));
	}

	public static int hIndex(int[] citations) {
		if (citations == null || citations.length == 0)
			return 0;
		Arrays.sort(citations);
        int i =0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
		}
		return i;
	}

}
