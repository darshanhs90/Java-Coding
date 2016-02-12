package hackerRank.Java.OOP;

/*
 * Link:https://www.hackerrank.com/challenges/java-interface
 */

public class _04JavaInterface {
	interface AdvancedArithmetic{
		
	}
	class MyCalculator implements AdvancedArithmetic{
	    public int divisorSum(int n){
	        int sum=0;
	        for(int i=1;i<=n;i++)
	        {
	            sum+=(n%i==0)?i:0;
	        }
	        return sum;
	    }
	}

}
