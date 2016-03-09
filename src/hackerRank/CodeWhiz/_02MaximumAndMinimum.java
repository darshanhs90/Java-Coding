package hackerRank.CodeWhiz;
import java.util.Scanner;

/*
 * Maximum and Minimum
 * Link:https://www.hackerrank.com/contests/codewhiz-java-march-2016/challenges/maximum-and-minimum
 */
public class _02MaximumAndMinimum {
	public static void print(int A[],int i){
		try{
			System.out.println(A[i]);
		}  catch(Exception e){
			throw e;
		}
		finally{
			int maxValue=Integer.MIN_VALUE;
			int minValue=Integer.MAX_VALUE;
			for(int j=0;j<A.length;j++){
				maxValue=Math.max(maxValue,A[j]);
				minValue=Math.min(minValue,A[j]);
			}
			System.out.println(maxValue+" "+minValue);
		}
	}
	public static void main(String[] args) {
		int N;
		Scanner st=new Scanner(System.in);
		N=st.nextInt();
		int A[]=new int[N];
		for(int i=0;i<N;i++)
		{
			A[i]=st.nextInt();
		}
		int i=st.nextInt();
		try
		{
			print(A,i);

		}
		catch(Exception e){
			System.out.println(e.getClass().getName());
		}

	}// end of main
}// end of Solution

