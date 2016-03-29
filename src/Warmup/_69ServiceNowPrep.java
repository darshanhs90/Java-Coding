package Warmup;

public class _69ServiceNowPrep {
	public static void main(String[] args) {
		printFizzBuzz(100);
		System.out.println(palindromeCheck("MalayalaM"));
	}

	private static void printFizzBuzz(int n){
		for(int i=1;i<n;i++)
		{
			if(i%5==0 && i%3==0)
				System.out.println(i+"->Gizz");
			else if(i%5==0)
				System.out.println(i+"->Fizz");
			else if(i%3==0)
				System.out.println(i+"->Buzz");
		}
	}

	private static boolean palindromeCheck(String string) {
		return string.equals(new StringBuilder(string).reverse().toString());
	}

}






