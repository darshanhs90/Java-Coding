package TopCoder;

/*
 * SRM 147 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1667&rd=4540
 */



public class SRM147CCipher {
	public static void main(String[] args) {
		System.out.println(decode("VQREQFGT",2));
		System.out.println(decode("ABCDEFGHIJKLMNOPQRSTUVWXYZ",10));
		System.out.println(decode("TOPCODER",0));
		System.out.println(decode("ZWBGLZ",25));
		System.out.println(decode("DBNPCBQ",1));
		System.out.println(decode("LIPPSASVPH",4));
	}
	public static String decode(String cipherText, int shift){
		StringBuilder sb=new StringBuilder("");
		for (int i = 0; i < cipherText.length(); i++) {
			char c=cipherText.charAt(i);
			if(c-shift<65)
			{
				c=((char)((c-shift)+91-65));
			}
			else{
				c=(char)(c-shift);
			}
			sb.append(c);
		}
		return sb.toString();
	}
}
