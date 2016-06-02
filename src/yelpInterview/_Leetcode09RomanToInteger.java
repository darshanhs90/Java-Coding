package yelpInterview;

public class _Leetcode09RomanToInteger {


	public static void main(String[] args) {
		System.out.println(romanToInt("MMMCMLXXVIII"));

	}


	public static int romanToInt(String s) {
		String dict[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int val[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};  
		int value=0;
		int stringIndex=0,dictIndex=0;
		while(dictIndex<dict.length){
			if(stringIndex<s.length()){
				if((stringIndex+1)<s.length() && s.substring(stringIndex,stringIndex+2).contentEquals(dict[dictIndex]))
				{
					value+=val[dictIndex];
					stringIndex+=2;
				}else if((stringIndex)<s.length() && s.substring(stringIndex,stringIndex+1).contentEquals(dict[dictIndex])){

					value+=val[dictIndex];
					stringIndex+=1;

				}
				else{
					dictIndex++;
				}
			}
			else{
				break;
			}
		}
		return value;
	}

}

