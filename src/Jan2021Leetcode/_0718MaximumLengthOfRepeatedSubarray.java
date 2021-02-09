package Jan2021Leetcode;

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

			if (sb.indexOf("/" + B[i] + "/") > -1) {
				int count = 1;
				StringBuilder sb1 = new StringBuilder("/" + B[i] + "/");
				for (int j = i + 1; j < B.length; j++) {
					sb1.append(B[j] + "/");
					if (sb.toString().indexOf(sb1.toString()) > -1) {
						count++;
					} else {
						break;
					}
				}
				maxLength = Math.max(maxLength, count);
			}
		}
		return maxLength;
	}
}
