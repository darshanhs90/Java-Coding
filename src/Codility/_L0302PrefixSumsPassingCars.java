package Codility;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/passing_cars
 */

public class _L0302PrefixSumsPassingCars {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{0,1,0,1,1,0,1,1}));
	}
	public static int solution(int[] A){
		int count=0;
		int previous=0;
		for (int i = A.length-1; i >=0; i--) {
			if(A[i]==0)
			{
				previous+=count;
			}
			else{
				count++;
			}			
		}
		return previous;
	}
}