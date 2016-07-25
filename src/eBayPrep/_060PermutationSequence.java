package eBayPrep;

public class _060PermutationSequence {


	public static void main(String[] args) {
		System.out.println(getPermutation(3, 3));
	}
	
	static int counter=0;
	static String outputString="";
	public static String getPermutation(int n, int k) {
		StringBuilder sb=new StringBuilder();
		for (int i = 1; i <=n; i++) {
			sb.append(i);
		}
		outputString="";
		counter=1;
		printPermutation("",sb.toString(),k);
		return outputString;
	}

	private static void printPermutation(String prefix,String str,int k) {
		if(str.length()==0){
			if(counter==k)
				outputString=prefix;
			counter++;
		}
		for (int i = 0; i < str.length(); i++) {
			printPermutation(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1),k);
		}
	}


}

