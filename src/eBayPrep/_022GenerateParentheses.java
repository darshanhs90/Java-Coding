package LeetCodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _022GenerateParentheses {


	public static void main(String[] args) {
		List<String> ls1=generateParenthesis(3);
		System.out.println(Arrays.toString(ls1.toArray()));

	}
	static List<String> ls;

	public static List<String> generateParenthesis(int n) {
		ls=new ArrayList<>();
		parenthesesGenerator("",n,n);
		return ls;
	}


	private static void parenthesesGenerator(String str,int forward, int backward) {
		if(forward==0 && backward==0 )
		{	
			ls.add(str);
			return ;
		}
		if(backward>forward || forward<0 || backward<0)
			return;
		parenthesesGenerator(str+")", forward-1, backward);
		parenthesesGenerator(str+"(", forward, backward-1);
	}
}
