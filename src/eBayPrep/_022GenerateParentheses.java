package eBayPrep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _022GenerateParentheses {


	public static void main(String[] args) {
		List<String> ls1=generateParenthesis(3);

	}
	static HashSet<String> set=new HashSet<>();
	private static List<String> generateParenthesis(int N) {
		printParentheses("",N,N);
		System.out.println(Arrays.toString(set.toArray()));
		return null;
	}

	private static void printParentheses(String string, int forward,int backward) {
		if(backward>forward || forward<0 ||backward<0)
		{
			return;
		}
		else if(forward==0 && backward==0)
			set.add(string);

		for (int i = 0; i < forward; i++) {
			printParentheses(string+"(", forward,backward-1);
			printParentheses(string+")", forward-1,backward);
		}
	}
}
