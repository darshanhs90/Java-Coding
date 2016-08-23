package LeetCodePerformancePractice;

public class _021MergeTwoSortedLists {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode output=new ListNode(-1);
		
	}
}

//This is the text editor interface. 
//Anything you type or change here will be seen by the other person in real time.

abcd -> dcba
//1st iteration
startChar=a
endChar=d
dbca

//2nd iteration
startchar=b
endchar=c
dcba



public static String reverseString(String input)
{
 if(input==null||input.length()<=1)
     return input;
 char inputArr[]=input.toCharArray();
 for(int i=0;i<inputArr.length()/2;i++)
 {
     char startChar=inputArr[i];
     char endChar=inputArr[inputArr.length()-1-i];
     inputArr[i]=endChar;
     inputArr[inputArr.length()-1-i]=startChar;
 }
 return new String(inputArr);
}

public static reverseNew(String input)
{
 if(input==null||input.length()<=1)
     return input;
 StringBuilder sb=new StringBuilder();
 for(int i=0;i<input.length;i++)
 {
     char c=input.charAt(i);
     if(c=='&')
     {
         //find ;
         sb.append(';');
         int startIndex=i;//&amp;23
         int index=i;//&amp;23
         
         while(input.charAt(index)!=';')
         {
             index++;
         }
         String subReverString=reverseString(input.subString(startIndex+1,index));
         i=index;
         sb.append(subReverString);
         sb.append('&');
     }
     else{
         sb.append(input.charAt(i));
     }
 }
 return reverseString(sb.toString());
 
 
}

&amp;23

amp -> pma


;pma&23

32;amp&




//& -> &amp;
//yen symbol -> &yen;
//&...;

//&amp;23 ->
32;pma&

32&amp;
//&23 -> 32&


abc&23;// -> &23;cba
abc^23; -> ;32^cba


//modified

public static String reverseString(String input)
{
 if(input==null||input.length()<=1)
     return input;
 char inputArr[]=input.toCharArray();
 for(int i=0;i<inputArr.length()/2;i++)
 {
     char startChar=inputArr[i];
     char endChar=inputArr[inputArr.length()-1-i];
     inputArr[i]=endChar;
     inputArr[inputArr.length()-1-i]=startChar;
 }
 return new String(inputArr);
}

public static reverseNew(String input)
{
 if(input==null||input.length()<=1)
     return input;
 StringBuilder sb=new StringBuilder();
 for(int i=0;i<input.length;i++)
 {
     char c=input.charAt(i);
     if(c=='&')
     {
         //find ;
         sb.append(';');
         int startIndex=i;//&amp;23
         int index=i;//&amp;23
         
         while(input.charAt(index)!=';')
         {
             index++;
         }
         //String subReverString=reverseString(input.subString(startIndex+1,index));
         String inputNew=input.subString(startIndex+1,index);
         char inputArr[]=inputNew.toCharArray();
          for(int i=0;i<inputArr.length()/2;i++)
         {
             char startChar=inputArr[i];
             char endChar=inputArr[inputArr.length()-1-i];
             inputArr[i]=endChar;
             inputArr[inputArr.length()-1-i]=startChar;
         }
         sb.append(inputArr);
         
         
         i=index;
         //sb.append(subReverString);
         sb.append('&');
     }
     else{
         sb.append(input.charAt(i));
     }
 }
 return reverseString(sb.toString());
 
 
}




//abc a b c cba

//abc -> ['a', 'b', 'c'] -> ['c', 'b', 'a'] -> cba







