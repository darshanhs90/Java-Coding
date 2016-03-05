package TopCoder.Div1;
import java.util.Arrays;

/*
 * SRM 144 Div 1
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1704&rd=4515
 */
public class BinaryCode {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(decode("123210120")));
	}
	public static String[] decode(String message){
		if(message.length()==1)
		{
			if(Integer.parseInt(message)>1 ||Integer.parseInt(message)<0)
				return new String[]{"NONE","NONE"};
			else
				return new String[]{message,message};
		}
		int[] p=new int[message.length()];
		int[] p1=new int[message.length()];
		p[0]=0;
		p1[0]=1;
		String outputString1 = null,outputString2=null;
		for (int i = 1; i < message.length(); i++) {
			if(i==1)
			{
				p[1]= Integer.parseInt(message.charAt(i-1)+"")-p[0];
				p1[1]= Integer.parseInt(message.charAt(i-1)+"")-p1[0];
			}
			else{
				p[i]=Integer.parseInt(message.charAt(i-1)+"")-(p[i-1])-p[i-2];
				p1[i]=Integer.parseInt(message.charAt(i-1)+"")-(p1[i-1])-p1[i-2];
			}
			if(p[i]>1 || p[i]<0)
			{
				outputString1="NONE";
			}
			if(p1[i]>1 || p1[i]<0)
			{
				outputString2="NONE";
			}
			if(outputString1!=null && outputString2!=null && outputString1.contentEquals("NONE") && outputString2.contentEquals("NONE"))
				break;
		}
		outputString1=outputString1!=null && outputString1.contentEquals("NONE")?"NONE":Arrays.toString(p).replaceAll(",","").replaceAll(" ", "").replace("[", "").replace("]", "");
		outputString2=outputString2!=null && outputString2.contentEquals("NONE")?"NONE":Arrays.toString(p1).replaceAll(",","").replaceAll(" ", "").replace("[", "").replace("]", "");
		return new String[]{outputString1,outputString2};
	}	
}
