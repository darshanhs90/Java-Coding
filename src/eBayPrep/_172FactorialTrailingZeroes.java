package eBayPrep;

public class _172FactorialTrailingZeroes {

	public static void main(String[] args) {
		System.out.println(trailingZeroes(4));
		System.out.println(trailingZeroes(10));
	}

    public static int trailingZeroes(int n) {
    	int value=0,num=5,result=0;;
        while(result>1)
        {
        	result=n/num;
        	value+=result;
        	num=num*5;
        }
        return value;
    }
}

