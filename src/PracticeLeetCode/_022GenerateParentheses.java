package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _022GenerateParentheses {
	public static void main(String[] args) {
		System.out.println(generateParenthesis(2));
	}
	public static List<String> generateParenthesis(int n) {
		List<String> outputList=new ArrayList<>();
		generateParenthesis("",n,n,outputList);
		return outputList;
	}
	private static void generateParenthesis(String prefix, int forward, int backward, List<String> outputList) {
		if(forward>backward || forward<0||backward<0)
			return;
		if(forward==0 && backward==0)
		{
			outputList.add(prefix);
			return;
		}
		generateParenthesis(prefix+")", forward, backward-1, outputList);
		generateParenthesis(prefix+"(", forward-1, backward, outputList);
	}
}

