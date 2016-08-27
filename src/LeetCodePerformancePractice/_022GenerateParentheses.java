package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.List;

public class _022GenerateParentheses {
	public static void main(String[] args) {
		System.out.println(generateParenthesis(5));
	}
	static List<String> outputList;
	public static List<String> generateParenthesis(int n) {
		outputList=new ArrayList<>();
		generateParentheses(0,0,n,"");
		return outputList;
	}
	private static void generateParentheses(int forwardBraceCount, int backwardBraceCount,int count, String string) {
		if(backwardBraceCount>forwardBraceCount||forwardBraceCount>count||backwardBraceCount>count)
			return;
		if(forwardBraceCount==count && backwardBraceCount==count){
			outputList.add(string);
		}
		generateParentheses(forwardBraceCount, backwardBraceCount+1,count, string+")");
		generateParentheses(forwardBraceCount+1, backwardBraceCount,count, string+"(");
	}
}

