package TopCoder;

/*
 * SRM 154 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1768&rd=4575
 */



public class SRM154SuperRot {
	public static void main(String[] args) {
		System.out.println(decoder("Uryyb 28"));
		System.out.println(decoder("GbcPbqre"));
		System.out.println(decoder(""));
		System.out.println(decoder("5678901234"));
		System.out.println(decoder("NnOoPpQqRr AaBbCcDdEe"));
		System.out.println(decoder("Gvzr vf 54 71 CZ ba Whyl 4gu bs gur lrne 7558 NQ"));
		System.out.println(decoder("Gur dhvpx oebja sbk whzcf bire n ynml qbt"));
	}
	public static String decoder(String message){
		StringBuilder sb=new StringBuilder("");

		for (int j = 0; j < message.length(); j++) {
			char c=message.charAt(j);
			if(Character.isDigit(c)){
				sb.append((Integer.parseInt(c+"")+5)%10);
			}
			else if(Character.isLetter(c)){
				boolean isUpper=Character.isUpperCase(c);
				if(!isUpper){
					c=Character.toUpperCase(c);
					int x=(int)((c+13));
					if(x>90)
						x=(x%90)+64;
					c=(char)(x);
					c=Character.toLowerCase(c);
				}
				else{
					int x=(int)((c+13));
					if(x>90)
						x=(x%90)+64;
					c=(char)(x);
				}
				sb.append(c);
			}
			else{
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
