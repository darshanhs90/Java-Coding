package TopCoder;

import java.util.Arrays;

/*
 * SRM 149 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1331&rd=4550
 */



public class SRM164Justifier {


	public static String[] justify(String[] textIn){
		int maxLength=0;
		for(int i=0;i<textIn.length;i++){
			maxLength=Math.max(maxLength,textIn[i].length());
		}
		String outputArray[]=new String[textIn.length];
		for(int i=0;i<textIn.length;i++){
			StringBuilder sb=new StringBuilder("");
			for(int j=0;j<maxLength-textIn[i].length();j++){
				sb.append(" ");
			}
			sb.append(textIn[i]);
			outputArray[i]=sb.toString();
		}
		return outputArray;



	}


}
