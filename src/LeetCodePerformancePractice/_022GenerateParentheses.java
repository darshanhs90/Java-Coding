package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.List;

public class _022GenerateParentheses {
	public static void main(String[] args) {
		System.out.println(generateParenthesis(2));
	}
	static List<String> outputList;
	public static List<String> generateParenthesis(int n) {
		outputList=new ArrayList<>();
		if(n==0)
			return outputList;
		generateParenthes("",n,n,n);
		return outputList;
	}
	private static void generateParenthes(String prefix, int forward, int backward,int n) {
		if(forward>n ||backward>n || forward<0||backward<0)
			return;
		if(forward==0 && backward==0)
		{
			outputList.add(prefix);
			return;
		}
		if(backward<forward)
			return;
		generateParenthes(prefix+"(", forward-1, backward, n);
		generateParenthes(prefix+")", forward, backward-1, n);

	}
}

