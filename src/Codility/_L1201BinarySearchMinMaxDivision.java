package Codility;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/min_max_division
 */

public class _L1201BinarySearchMinMaxDivision {
	public static void main(String[] args) {
		System.out.println(solution(3,5,new int[]{2,1,5,1,2,2,2}));
	}
	public static int solution(int K, int M, int[] A){
		int max = A[0];
		int sum = 0;
		int N=A.length;
		int i;
		for (i = 0; i < N; i++){
			max = max < A[i] ? A[i] : max;
			sum += A[i];
		}
		int beg = max;
		int end = sum; 

		int min = sum; 
		while (beg <= end){
			int mid = (beg + end) / 2;
			if (check(mid, K, A, N)==1){
				min = mid;
				end = mid - 1;
			}
			else {
				beg = mid + 1;
			}
		}

		return min;
	}


	public static int check(int num, int K, int A[], int N)
	{
		int i = 0;

		int sum = 0;
		while (i < N){    
			if (A[i] > num){
				return 0;
			}
			sum += A[i];
			if (sum > num){
				sum = A[i];

				K--;
				if (K == 0){
					return 0;
				}
			}
			i++;
		}

		return 1;
	}


}