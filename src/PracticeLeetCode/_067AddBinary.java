package PracticeLeetCode;

public class _067AddBinary {
	public static void main(String[] args) {
		System.out.println(addBinary("111111", "110010"));
	}
	public static String addBinary(String a, String b) {
		int carry=0;
		int lengthA=a.length();
		int lengthB=b.length();
		int minLength=Math.min(lengthA, lengthB);
		StringBuilder output=new StringBuilder();
		for (int i = 0; i < minLength; i++) {
			int c1=Character.getNumericValue(a.charAt(lengthA-i-1));
			int c2=Character.getNumericValue(b.charAt(lengthB-i-1));
			int sum=c1+c2+carry;
			if(sum==0||sum==1)
			{
				carry=0;
				output.append(sum);
			}else if(sum==2)
			{
				carry=1;
				output.append("0");
			}
			else
			{
				carry=1;
				output.append("1");
			}
		}
		for (int i = minLength; i < lengthA; i++) {
			int c1=Character.getNumericValue(a.charAt(lengthA-i-1));
			int sum=c1+carry;
			if(sum==0||sum==1)
			{
				carry=0;
				output.append(sum);
			}else if(sum==2)
			{
				carry=1;
				output.append("0");
			}
			else
			{
				carry=1;
				output.append("1");
			}
		}
		for (int i = minLength; i < lengthB; i++) {
			int c2=Character.getNumericValue(b.charAt(lengthB-i-1));
			int sum=c2+carry;
			if(sum==0||sum==1)
			{
				carry=0;
				output.append(sum);
			}else if(sum==2)
			{
				carry=1;
				output.append("0");
			}
			else
			{
				carry=1;
				output.append("1");
			}
		}
		if(carry==1)
			output.append("1");
		return output.reverse().toString();
	}
}

