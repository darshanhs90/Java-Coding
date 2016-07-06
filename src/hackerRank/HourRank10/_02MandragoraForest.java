package hackerRank.HourRank10;

import java.util.Arrays;
import java.util.Scanner;

public class _02MandragoraForest {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			int N = in.nextInt();
			int B[] = new int[N];
			for(int B_i=0; B_i < N; B_i++){
				B[B_i] = in.nextInt();
			}
			Arrays.sort(B);
			int S=1;
			int maxVal=0;
			for (int j = 0; j < B.length; j++) {
				S=j+2;
				int value=0;
				for (int j2 = j+1; j2 < B.length; j2++) {
					value=value+(B[j2]*S);
				}
				maxVal=Math.max(maxVal, value);
			}
			System.out.println(maxVal);
		}

	}
}

