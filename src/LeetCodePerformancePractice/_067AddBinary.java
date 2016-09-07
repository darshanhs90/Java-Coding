package LeetCodePerformancePractice;

public class _067AddBinary {
	public static void main(String[] args) {
		System.out.println(addBinary("100", "110010"));
	}
	public static String addBinary(String a, String b) {
		int carry=0;
		int length=Math.min(a.length(), b.length());
		StringBuilder sb=new StringBuilder();
		for (int i = 0;i<length;i++) {
			int aVal=Integer.parseInt(a.charAt(a.length()-1-i)+"");
			int bVal=Integer.parseInt(b.charAt(b.length()-1-i)+"");
			int sum=aVal+bVal+carry;
			if(sum<=1){
				carry=0;
			}
			else if(sum==2)
			{
				sum=0;
				carry=1;
			}
			else{
				sum=1;
				carry=1;
			}
			sb.append(sum);
		}
		if(a.length()!=b.length() && a.length()>length)
		{
			for (int i = length;i<a.length();i++) {
				int aVal=Integer.parseInt(a.charAt(a.length()-1-i)+"");
				int sum=aVal+carry;
				if(sum<=1){
					carry=0;
				}
				else if(sum==2)
				{
					sum=0;
					carry=1;
				}
				else{
					sum=1;
					carry=1;
				}
				sb.append(sum);
			}
		}else if(a.length()!=b.length() && b.length()>length)
		{
			for (int i = length;i<b.length();i++) {
				int bVal=Integer.parseInt(b.charAt(b.length()-1-i)+"");
				int sum=bVal+carry;
				if(sum<=1){
					carry=0;
				}
				else if(sum==2)
				{
					sum=0;
					carry=1;
				}
				else{
					sum=1;
					carry=1;
				}
				sb.append(sum);
			}
		}
		if(carry==1)
			sb.append("1");
		return sb.reverse().toString();
	}

}

