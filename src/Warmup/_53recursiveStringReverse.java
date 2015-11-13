package Warmup;

/*
 */	
public class _53recursiveStringReverse {


	public static void main(String[] args) {
		System.out.println(reverseString("Hello"));		
	}

	public static String reverseString(String inputstring)
	{
		if(inputstring.length()==1)
			return inputstring;
		else{
			return inputstring.charAt(inputstring.length()-1)+reverseString(inputstring.substring(0,inputstring.length()-1));
		}
		
	}

}
