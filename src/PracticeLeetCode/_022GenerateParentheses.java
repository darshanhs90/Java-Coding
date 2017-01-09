package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _022GenerateParentheses {
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> list=new ArrayList<>();
		if(n==0)
			return list;
		generate("",n,n,list);
		return list;
	}

	private static void generate(String str,int forward, int backward, List<String> list) {
		if(forward<0||backward<0||forward>backward)
			return;
		if(forward==0&& backward==0)
		{
			list.add(str);
			return;
		}
		generate(str+"(",forward-1,backward,list);
		generate(str+")",forward,backward-1,list);
	}
}

