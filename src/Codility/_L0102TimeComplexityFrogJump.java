package Codility;


/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/frog_jmp
 */

public class _L0102TimeComplexityFrogJump {

	public static void main(String[] args) {
		System.out.println(solution(10, 85, 30));
	}

	public static int solution(int X, int Y, int D)
	{
		 if(Y-X%D==0)
			 return (Y-X)/D;
		 else
			 return (Y-X+D)/D;
	}

}