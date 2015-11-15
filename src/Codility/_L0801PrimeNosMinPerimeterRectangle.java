package Codility;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/min_perimeter_rectangle
 */

public class _L0801PrimeNosMinPerimeterRectangle {
	public static void main(String[] args) {
		System.out.println(solution(30));
	}
	public static int solution(int N){//also it is 4*Math.ceil(Math.sqrt(N))
		int minPerimeter=Integer.MAX_VALUE;
		for (int i = 1; i*i<=N; i++) {
			if(N%i==0)
			{
				minPerimeter=Math.min(minPerimeter, 2*((N/i)+i));
			}
		}
		return minPerimeter;
	}
}