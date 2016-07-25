package eBayPrep;

public class _067AddBinary {


	public static void main(String[] args) {
		System.out.println(addBinary("100", "110010"));
	}


	public static String addBinary(String a, String b) {
		int carry=0;
		int length=Math.min(a.length(), b.length());
		StringBuilder sb=new StringBuilder();
		for (int i = 0;i<length;i++) {
			int valueA=Integer.parseInt(a.charAt(a.length()-1-i)+"");
			int valueB=Integer.parseInt(b.charAt(b.length()-1-i)+"");			
			int op=valueA+valueB+carry;
			if(op==0||op==1){
				sb.append(op);
				carry=0;
			}
			else if(op==2){
				sb.append("0");
				carry=1;
			}
			else{
				sb.append("1");
				carry=1;
			}
		}
		if(a.length()==length)
		{
			//iterate through b
			for (int i = length; i <b.length(); i++) {
				int valueB=Integer.parseInt(b.charAt(b.length()-1-i)+"");			
				int op=valueB+carry;
				if(op==0||op==1){
					sb.append(op);
					carry=0;
				}
				else if(op==2){
					sb.append("0");
					carry=1;
				}
				else{
					sb.append("1");
					carry=1;
				}
			}
		}
		else if(b.length()==length){
			//iterate through a		
			for (int i =length;i<a.length(); i++) {
				int valueA=Integer.parseInt(a.charAt(a.length()-1-i)+"");			
				int op=valueA+carry;
				if(op==0||op==1){
					sb.append(op);
					carry=0;
				}
				else if(op==2){
					sb.append("0");
					carry=1;
				}
				else{
					sb.append("1");
					carry=1;
				}
			}
		}
		if(carry==1)
			sb.append(carry);
		return sb.reverse().toString();
	}

}

