package PracticeLeetCode;

import java.util.Arrays;
import java.util.Stack;

public class _071SimplifyPath {
	public static void main(String[] args) {
		System.out.println(simplifyPath("/home/"));
		System.out.println(simplifyPath("/a/./b/../../c/"));
		System.out.println(simplifyPath("/"));
		System.out.println(simplifyPath("///"));

	}
	public static String simplifyPath(String path) {
		if(path==null||path.length()==0)
			return path;
		String strArray[]=path.split("/");
		Stack<String> stack=new Stack<>();
		for (int i = 0; i < strArray.length; i++) {
			String str=strArray[i].trim();
			if(!str.contentEquals("/") && !str.contentEquals("")&& !str.contentEquals("."))
			{
				if(str.contentEquals(".."))
				{
					if(!stack.isEmpty())
						stack.pop();
				}
				else{
					stack.push(str);
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		String str="/";
		while(!stack.isEmpty())
		{
			str="/"+stack.pop()+str;
		}
		return str.length()==1?"/":str.substring(0, str.length()-1);
	}
}
