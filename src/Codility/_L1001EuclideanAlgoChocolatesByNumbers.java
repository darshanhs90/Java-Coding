package Codility;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/chocolates_by_numbers
 */

public class _L1001EuclideanAlgoChocolatesByNumbers {
	public static void main(String[] args) {
		System.out.println(solution(10, 4));
	}
	public static int solution(int N, int M){
		int count=0;
		boolean foundWrapper=false;
		boolean chocolateArray[]=new boolean[N];
		int element=0;
		while(!foundWrapper)
		{
			if(chocolateArray[element]==true)
			{
				return count;
			}
			else{
				chocolateArray[element]=true;
				element+=M;
				element=element%N;
				count++;
			}
		}
		return 0;
	}


}