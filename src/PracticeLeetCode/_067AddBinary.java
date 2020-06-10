package PracticeLeetCode;

public class _067AddBinary {
	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
		System.out.println(addBinary("1010", "1011"));
		System.out.println(addBinary("100", "110010"));
	}
	
    public static String addBinary(String a, String b) {        
        if(a.length() != b.length())
        {
        	StringBuilder sb = new StringBuilder();
        	if(a.length() > b.length())
        	{
        		for (int i = 0; i < a.length() - b.length(); i++) 
        		{
					sb.append("0");
				}
        		b = sb.toString() + b;
        	}
        	else {
        		for (int i = 0; i < b.length() - a.length(); i++) 
        		{
					sb.append("0");
				}
        		a = sb.toString() + a;
        	}
        	
        }
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
			int aChar = Integer.parseInt(a.charAt(i) + "");
			int bChar = Integer.parseInt(b.charAt(i) + "");
			int output = aChar + bChar + carry;
			carry = 0;
			if(output > 1)
			{
				carry = 1;
				sb.append(output == 2 ? 0 : 1);
			}
			else {
				sb.append(output);
			}
		}
       
        if(carry == 1)
        {
        	sb.append(1);
        }
        return sb.reverse().toString();        
    }
	
}

