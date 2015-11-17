package Codility;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/count_distinct_slices
 */

public class _L1302CaterpillarMethodDistinctSlices {
	public static void main(String[] args) {
		System.out.println(solution(6,new int[]{3,4,5,5,2}));
	}
	public static int solution(int M, int[] A)
	{
		int N = A.length;
		int[] counters = new int[M+1];
		int head = 0;
		int tail = 0;
		int result = 0;
		while (tail < N) {
			// find the most right end of the array for each tail
			while (head < N && counters[A[head]] != 2) {//repitition of elements
				counters[A[head]]++;
				if (counters[A[head]] == 2)
					break;
				head++;
			}
			result += head - tail;
			counters[A[tail]] = 0;
			tail++;
		}
		return result;
	}

}