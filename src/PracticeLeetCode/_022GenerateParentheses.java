package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _022GenerateParentheses {
	public static void main(String[] args) {
		System.out.println(generateParenthesis(2));
	}
	static List<String> outputList;
	public static List<String> generateParenthesis(int n) {
		outputList=new ArrayList<>();
		dfs("",n,n);
		return outputList;
	}
	private static void dfs(String prefix, int forward, int backward) {
		if(forward<backward||forward<0||backward<0)
			return;
		if(forward==0 && backward==0)
			outputList.add(prefix);
		dfs(prefix+")", forward-1, backward);
		dfs(prefix+"(", forward, backward-1);
	}
}

