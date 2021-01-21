package Dec2020Leetcode;

public class _0718MaximumLengthOfRepeatedSubarray {
	public static void main(String[] args) {
		System.out.println(findLength(new int[] { 1, 2, 3, 2, 1 }, new int[] { 3, 2, 1, 4, 7 }));
	}

	public static int findLength(int[] A, int[] B) {
		StringBuilder sb = new StringBuilder("/");
		for (int i = 0; i < A.length; i++) {
			sb.append(A[i] + "/");
		}
		int maxLength = 0;
		for (int i = 0; i < B.length; i++) {
			int count = 0;
			StringBuilder temp = new StringBuilder();
			if (sb.indexOf("/" + B[i] + "/") > -1) {
				count++;
				temp.append("/" + B[i] + "/");
				for (int j = i + 1; j < B.length; j++) {
					temp.append(B[j] + "/");
					if (sb.indexOf(temp.toString()) > -1)
						count++;
					else
						break;
				}
				maxLength = Math.max(count, maxLength);
			}
		}
		return maxLength;
	}
}
