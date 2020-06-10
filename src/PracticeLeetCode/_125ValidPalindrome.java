package PracticeLeetCode;

public class _125ValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}

	public static boolean isPalindrome(String s) 
	{
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        boolean isValidPalindrome = true;
        while(leftIndex <= rightIndex && isValidPalindrome)
        {
        	int leftChar = s.charAt(leftIndex);
        	int rightChar = s.charAt(rightIndex);
        	boolean isLeftValid = isValidChar(leftChar);
        	boolean isRightValid = isValidChar(rightChar);
        	if(isLeftValid && isRightValid)
        	{
        		isValidPalindrome = isValidPalindrome && isValid(s.charAt(leftIndex), s.charAt(rightIndex));
        		leftIndex ++ ;
        		rightIndex -- ;
        	}
        	else if(!isLeftValid)
        	{
        		leftIndex++;
        	}
        	else {
        		rightIndex--;
        	}

        }
        return isValidPalindrome;
    }

	public static boolean isValid(char charVal1,char charVal2)
	{
		return (charVal1+"").compareToIgnoreCase(charVal2+"") == 0;
	}
	
	public static boolean isValidChar(int charVal)
	{
		return (charVal >= 97 && charVal <= 122)
				|| (charVal >= 65 && charVal <= 90)
				|| (charVal >= 48 && charVal <= 57);
	}
	//97-122
	//65-90
	//48-57
}
