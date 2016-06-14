package LeetCodePractice;

public class _060PermutationSequence {


	public static void main(String[] args) {
		System.out.println(getPermutation(3, 3));
	}

	public static String getPermutation(int n, int k) {
		String str="";
		for (int i = 1; i <=n; i++) {
			str+=i+"";
		}
		if(k==1)
			return str;
		permutationGenerator("",str,k);
		return outputString;
	}

	static int counter=1;
	static String outputString="";

	private static void permutationGenerator(String prefix, String output, int k) {
		if(output.length()==0 && counter<=k)
		{
			if(counter==k)
				outputString=prefix;
			System.out.println(prefix);
			counter++;
			return;
		}
		for (int i = 0; i < output.length(); i++) {
			permutationGenerator(prefix+output.charAt(i), output.substring(0,i)+output.substring(i+1), k);
		}
	}
}

