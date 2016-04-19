package Warmup;

import java.util.Arrays;
import java.util.Stack;

/*
 * Link:https://www.careercup.com/question?id=5130528848084992
 */
public class _80DirectoryChange {


	public static void main(String a[]){

		//getDirectory("/logs", "test/nodes/../modules/logs");
		//getDirectory("/logs", "test/nodes/../modules/logs/..");
		findDirectory("logs", "test/nodes/../modules/logs");
		findDirectory("logs", "test/nodes/../modules/logs/..");
	}

	public static String findDirectory(String source,String command){
		String sourceArray[]=source.split("/");
		Stack<String> directoryStructure=new Stack<>();
		for (int i = 0; i < sourceArray.length; i++) {
			directoryStructure.push(sourceArray[i]);
		}
		String splitArray[]=command.split("/");
		for (int i = 0; i < splitArray.length; i++) {
			if(splitArray[i].contentEquals("..")){
				if(!directoryStructure.isEmpty())
					directoryStructure.pop();
			}else{
				directoryStructure.push(splitArray[i]);
			}
		}
		String sb=new String();
		while(!directoryStructure.isEmpty())
		{

			sb=(directoryStructure.pop()+"/")+sb;
		}
		System.out.println(sb.toString());
		return sb.toString();
	}



	/*
	public static void getDirectory(String src, String destination){

		Stack<String> directoryStack = new Stack<String>();

		String[] listDestination = destination.split("/");
		String[] listHost = src.split("/");

		if(!destination.startsWith("/")){
			for(String str : listHost){
				if(!(str.matches(".."))){
					directoryStack.push(str);
				}
				else if((str.matches(".."))){
					directoryStack.pop();
				}
			}
		}

		for(String str : listDestination){
			if(!(str.matches(".."))){
				directoryStack.push(str);
			}
			else if((str.matches(".."))){
				directoryStack.pop();
			}
		}

		System.out.println(directoryStack);
	}*/
}






