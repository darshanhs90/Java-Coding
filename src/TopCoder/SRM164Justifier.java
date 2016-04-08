package TopCoder;

import java.util.Arrays;

/*
 * SRM 164 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1757&rd=4625
 */



public class SRM164Justifier {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(justify(new String[]{"BOB","TOMMY","JIM"})));
		System.out.println(Arrays.toString(justify(new String[]{"JOHN","JAKE","ALAN","BLUE"})));
		System.out.println(Arrays.toString(justify(new String[]{"LONGEST","A","LONGER","SHORT"})));
	}

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
