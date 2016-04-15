package TopCoder;

/*
 * SRM 173 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1975&rd=4670
 */



public class SRM173WordForm {
	public static void main(String[] args) {
		System.out.println(getSequence("WHEREABOUTS"));
		System.out.println(getSequence("yoghurt"));
		System.out.println(getSequence("YipPy"));
		System.out.println(getSequence("AyYyEYye"));
		System.out.println(getSequence("yC"));
	}
	public static String getSequence(String word){
		word=word.toLowerCase();
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			char c=word.charAt(i);
			switch(c){
			case 'a':sb.append("V");break;
			case 'e':sb.append("V");break;
			case 'i':sb.append("V");break;
			case 'o':sb.append("V");break;
			case 'u':sb.append("V");break;
			case 'y':
				if(i!=0 && sb.charAt(sb.toString().length()-1)!='V'){
					sb.append("V");
				}
				else{
					sb.append("C");
				}
				break;
			default:sb.append("C");break;
			}
		}
		String str=sb.toString();
		str=str.replaceAll("[V]+", "V");
		str=str.replaceAll("[C]+", "C");
		return str;
	}
}
