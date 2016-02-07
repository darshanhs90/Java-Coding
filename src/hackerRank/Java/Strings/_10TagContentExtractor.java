package hackerRank.Java.Strings;

import java.util.Scanner;
import java.util.Stack;

/*
 * Link:https://www.hackerrank.com/challenges/tag-content-extractor
 */

public class _10TagContentExtractor {

	public static void main(String []args)
	{
		Scanner scanner = new Scanner(System.in);
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			Stack<String> tagStack=new Stack();
			int index=0;boolean printed=false;
			String inputString=scanner.nextLine();
			for (int j = 0; j < inputString.length(); j++) {
				if(inputString.charAt(j)=='<')
				{
					int indexNew=inputString.indexOf('>', j);
					if(indexNew!=-1){
						String tag=inputString.substring(j,indexNew);
						if(tag.indexOf('/')==-1)
						{
							tag=tag.replace('<', ' ').trim();
							if(!tag.contentEquals("")){
								tagStack.push(tag);
								index=j;
							}
						}
						else{
							if(!tagStack.isEmpty()){
								String tagPop=tagStack.pop();
								tag=tag.replaceAll("</", "");
								if(tagPop.contentEquals(tag)){
									String str=(inputString.substring(index,j));
									if(str.indexOf("</")==-1)
									{	

										str=str.replaceFirst(tag,"").replaceFirst("<", "").replaceFirst(">", "");
										if(!str.contentEquals("")){
											System.out.println(str);
											printed=true;
										}
									}
								}
							}
						}
					}
				}
			}
			if(!printed)
				System.out.println("None");
		}
	}
}
