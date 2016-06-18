package LeetCodePractice;

import java.util.Arrays;
import java.util.Stack;

public class _071SimplifyPath {


	public static void main(String[] args) {
		System.out.println(simplifyPath("/home/"));
		System.out.println(simplifyPath("/a/./b/../../c/"));
		System.out.println(simplifyPath("/home//foo/"));
		System.out.println(simplifyPath("/../"));


	}


	public static String simplifyPath(String path) {
		if(path.contentEquals("/..."))
			return path;
		String[] splitArray=path.split("/");
		System.out.println(Arrays.toString(splitArray));
		int counter=0;
		Stack<String> stack=new Stack<>();
		for (int i = 0; i < splitArray.length; i++) {
			String str=splitArray[i].trim();
			if(str.length()>0)
			{
				if(str.contentEquals(".."))
				{	
					counter++;
					if(!stack.isEmpty())
						stack.pop();
				}
				else if(!str.contentEquals(".")){
					stack.push(str);
				}
			}
		}
		StringBuilder sb=new StringBuilder("/");
		while(!stack.isEmpty())
		{
			sb.append(stack.pop()+"/");
		}
		String output=sb.toString();
		if(counter==0)
			output=path.replace("//", "/").replace("/./", "/");
		return output.length()==1?"/":output.substring(0, output.length()-1);
	}



}

