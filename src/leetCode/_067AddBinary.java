package leetCode;

/*
 * Link : https://leetcode.com/problems/add-binary/
 */

public class _067AddBinary {
	public static String addBinary(String a, String b) {
		int aIndex=a.length()-1;
		int bIndex=b.length()-1;
		StringBuffer sb=new StringBuffer();
		int carry=0;
		while(aIndex>=0 && bIndex>=0){
			int x=Integer.parseInt(a.charAt(aIndex)+"")+Integer.parseInt(b.charAt(bIndex)+"")+carry;
			if(x==2){
				sb.append("0");
				carry=1;
			}
			else if(x==3)
			{
				sb.append("1");
				carry=1;
			}
			else{
				sb.append(x);
				carry=0;
			}
			aIndex--;
			bIndex--;
		}
		if(aIndex>bIndex)
		{
			while(aIndex>=0)
			{
				int x=Integer.parseInt(a.charAt(aIndex)+"")+carry;
				if(x==2){
					sb.append("0");
					carry=1;
				}
				else{
					sb.append(x);
					carry=0;
				}
				aIndex--;
			}
		}
		else if(bIndex>aIndex){
			while(bIndex>=0)
			{
				int x=Integer.parseInt(b.charAt(bIndex)+"")+carry;
				if(x==2){
					sb.append("0");
					carry=1;
				}
				else{
					sb.append(x);
					carry=0;
				}
				bIndex--;
			}
		}
		if(carry==1)
			sb.append("1");
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
	}
}