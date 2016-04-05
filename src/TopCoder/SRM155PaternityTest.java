package TopCoder;

import java.util.Arrays;

/*
 * SRM 155 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1348&rd=4580
 */



public class SRM155PaternityTest {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(possibleFathers("ABCD","AXCY", new String[]{ "SBTD", "QRCD" })));
		System.out.println(Arrays.toString(possibleFathers("ABCD","ABCX", new String[]{ "ABCY", "ASTD", "QBCD" })));
		System.out.println(Arrays.toString(possibleFathers("ABABAB","ABABAB" , new String[]{ "ABABAB", "ABABCC", "ABCCDD", "CCDDEE" })));
		System.out.println(Arrays.toString(possibleFathers("YZGLSYQT","YUQRWYQT", new String[]{"YZQLDPWT", "BZELSWQM", "OZGPSFKT", "GZTKFYQT", "WQJLSMQT"})));
		System.out.println(Arrays.toString(possibleFathers("WXETPYCHUWSQEMKKYNVP","AXQTUQVAUOSQEEKCYNVP" , new String[]{ "WNELPYCHXWXPCMNKDDXD",
				"WFEEPYCHFWDNPMKKALIW",
				"WSEFPYCHEWEFGMPKIQCK",
				"WAEXPYCHAWEQXMSKYARN",
		"WKEXPYCHYWLLFMGKKFBB" })));
	}
	public static int[] possibleFathers(String child, String mother, String[] men){
		boolean[] arr=new boolean[child.length()];

		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < men.length; i++) {
			boolean exit=false;
			int count=0;
			boolean flagArray[]=new boolean[child.length()];
			for (int j = 0; j < arr.length; j++) {
				if(men[i].charAt(j)==child.charAt(j))
				{
					count++;
					flagArray[j]=true;
				}
			}
			for (int j = 0; j < flagArray.length; j++) {
				if(!flagArray[j])
				{
					if(mother.charAt(j)!=child.charAt(j))
					{
						exit=true;
						break;
					}
				}
			}
			if(!exit && count>=men[i].length()/2)
				sb.append(i+"/");
		}
		if(sb.toString().contentEquals(""))
			return new int[]{};
		String str[]=sb.toString().trim().split("/");
		int[] outputArr=new int[str.length];
		for (int i = 0; i < outputArr.length; i++) {
			outputArr[i]=Integer.parseInt(str[i]);
		}
		return outputArr;
	}
}
