package TopCoder;

import java.util.Arrays;

/*
 * SRM 169 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1876&rd=4650
 */



public class SRM169Twain {
	public static void main(String[] args) {
		System.out.println(getNewSpelling(1,"i fixed the chrome xerox by the cyclical church"));
		System.out.println(getNewSpelling(2,"i fixed the chrome xerox by the cyclical church"));
		System.out.println(getNewSpelling(0,"this is unchanged"));
		System.out.println(getNewSpelling(7,"sch kn x xschrx cknnchc cyck xxceci"));
		System.out.println(getNewSpelling(7,"  concoction   convalescence   cyclical   cello   " ));
		System.out.println(getNewSpelling(7,""));
		System.out.println(getNewSpelling(7,"cck xzz aaaaa" ));
	}
	public static String getNewSpelling(int year, String phrase){
		for (int i = 1; i <=year; i++) {
			String arr[]=phrase.split(" ");
			switch(i){
			case 1:
				StringBuilder sb=new StringBuilder();
				for (int j = 0; j < arr.length; j++) {
					if(j!=0)
						sb.append(" ");
					String str=arr[j];
					if(str.startsWith("x")){
						str="z"+str.substring(1);
					}
					str=str.replaceAll("x", "ks");
					sb.append(str);
				}
				phrase=sb.toString();
				break;
			case 2:
				phrase=phrase.replaceAll("y","i");
				break;
			case 3:phrase=phrase.replaceAll("ce","se");
			phrase=phrase.replaceAll("ci","si");
			break;
			case 4:phrase=phrase.replaceAll("[c]+k","ck");
			break;
			case 5:sb=new StringBuilder();
			for (int j = 0; j < arr.length; j++) {
				if(j!=0)
					sb.append(" ");
				String str=arr[j];
				if(str.startsWith("sch")){
					str="sk"+str.substring(1);
				}
				str=str.replaceAll("chr", "chk");
				str=str.replaceAll("ch", "1");
				str=str.replaceAll("c", "k");
				str=str.replaceAll("1", "ch");
				sb.append(str);
			}
			phrase=sb.toString();
			break;
			case 6:
				sb=new StringBuilder();
				for (int j = 0; j < arr.length; j++) {
					if(j!=0)
						sb.append(" ");
					String str=arr[j];
					if(str.startsWith("kn")){
						str="n"+str.substring(1);
					}
					sb.append(str);
				}
				phrase=sb.toString();
				break;
			case 7:
				sb=new StringBuilder();
				for (int j = 0; j < arr.length; j++) {
					if(j!=0)
						sb.append(" ");
					String str=arr[j];
					sb.append(singleOccurence(str));
				}
				phrase=sb.toString();
				break;
			default:break;
			}
		}
		return phrase;
	}
	private static Object singleOccurence(String input) {
		if(input.length()==0)
			return input;
		StringBuilder sb=new StringBuilder();
		char prevChar=input.charAt(0);
		sb.append(prevChar);
		for (int i = 0; i < input.length(); i++) {
			char c=input.charAt(i);
			if(c!='a' && c!='e' && c!='i' && c!='o' && c!='u')
			{
				if(sb.toString().charAt(sb.toString().length()-1)!=c){
					sb.append(c);
				}
			}else
			{
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
