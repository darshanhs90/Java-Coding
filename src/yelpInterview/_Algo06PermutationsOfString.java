package yelpInterview;

public class _Algo06PermutationsOfString {

	public static void main(String a[]){
		printPermutations("ABC");
	}

	private static void printPermutations(String string) {
		permute(string,0,string.length()-1);
	}

	private static void permute(String string, int l, int r) {
		if(l==r)
		{
			System.out.println(string);
		}
		else{
			for (int i = l; i <=r; i++) {
				string=swap(string,l,i);
				permute(string,l+1,r);
				string=swap(string,l,i);
			}
		}

	}

	private static String swap(String string, int l, int r) {
		if(l==r)
			return string;
		string=string.substring(0,l)+string.charAt(r)+string.substring(l+1,r)+string.charAt(l)+string.substring(r+1);
		return string;
	}


}

