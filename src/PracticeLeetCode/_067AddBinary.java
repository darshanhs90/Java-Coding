package PracticeLeetCode;

public class _067AddBinary {
	public static void main(String[] args) {
		System.out.println(addBinary("111111", "110010"));
	}
	public static String addBinary(String a, String b) {
		if(a==null || b==null)
			return a!=null?a:b;
		StringBuilder sb=new StringBuilder();
		int maxLength=Math.max(a.length(), b.length());
		int carry=0;
		for (int i = 0; i < maxLength; i++) {
			int aVal=0,bVal=0;
			if(i>a.length()-1)
				aVal=0;
			else
				aVal=Character.getNumericValue(a.charAt(a.length()-1-i));
			if(i>b.length()-1)
				bVal=0;
			else
				bVal=Character.getNumericValue(b.charAt(b.length()-1-i));

			int sum=aVal+bVal+carry;
			if(sum==0||sum==1){
				sb.append(sum);
				carry=0;
			}
			else if(sum==2)
			{
				sb.append(0);
				carry=1;
			}
			else{
				sb.append(1);
				carry=1;
			}
		}
		if(carry==1)
			sb.append(1);
		return sb.reverse().toString();


	}
}

