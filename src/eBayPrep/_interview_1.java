package eBayPrep;

public class _interview_1{
	// implement merge sort. implement a method that takes in am array of integers and returns a sorted array

	//1,4,3,5,2,7
	/*1,4,3     5,2,7

	1,4  3    5,2   7

	1,4  3    2,5   7
	  1 4 3    2 5 7
	  1,3,4    2,5,7
	   
	    1,2,3,4,5,7


	public static void main(String ards[])
	{
	int inputArray[]=new int[]{1,4,3,5,2,7};
	  inputArray=  mergeSort(inputArray,0,inputArray.length-1);

	}

	public static int[] mergeSort(int[] arr,int leftIndex,int rightIndex)
	{    
	    if(leftIndex>rightIndex)
	        return;
	    int mid=(leftIndex+rightIndex)/2;
	    int[] left=Arrays.copyOfRange(arr,leftIndex,mid);//divide(arr,left,mid);
	    int[] right=Arrays.copyOfRange(arr,mid,rightIndex-mid);//divide(arr,mid,right);
	    if(left.length<=2)
	    {
	        left=sort(left);
	    }
	    else{
	       left= mergeSort(left,leftIndex,mid);
	    }
	    if(right.length<=2)
	    {
	        right=sort(right);
	    }
	    else{
	        right=mergeSort(right,mid,rightIndex);
	    }
	    return merge(left,right);
	}

	public static int[] merge(int[] leftArray,int[] rightArray){
	    int outputArray[]=new int[leftArray.length+rightArray.length];
	    int leftPointer=0,rightPointer=0;
	    for(int i=0;i<outputArray.length;i++){
	        if(leftPointer<leftArray.length && rightPointer<rightArray.length )
	        {
	            if(leftArray[leftPointer]<rightArray[rightPointer])
	            {
	                outputArray[i]=leftArray[leftPointer];
	                leftPointer++;
	            }
	            else{
	                outputArray[i]=rightArray[rightPointer];
	                rightPointer++;
	            }
	        }
	        else if(leftPointer<leftArray.length) {
	                outputArray[i]=leftArray[leftPointer];
	                leftPointer++;
	        }
	        else{
	                outputArray[i]=rightArray[rightPointer];
	                rightPointer++;
	        }
	    }
	    return outputArray;
	}





	public static int[] sort(int[] arr){
	    if(arr.length<=1)
	        return arr;
	    else{
	        int max=Math.max(arr[0],arr[1]);
	        int min=Math.min(arr[0],arr[1]);
	        return new int[]{min,max};
	    }
	}


	(a,10),(b,10),(b,20) ,(a,20),(c,10),(c,20)

	//Map
	    a,10  b,10  b,20   a,20   c,10   c,20


	//combiner
	    a,10  b,(10,20)     a,20   c,(10,20)
	    
	    a,10   b,30          a,20    c,30
	//reduce
	    
	        a,30  b,30  c,30

	"aab" -> "ab"
	"bpfbhmipx" -> "bhmipx"

	//b
	//bp
	//bpf
	//present char=b    ->pfb
	//pfbh
	//pfbhm
	//pfbhmi
	//present char-p   ->fbhmip
	//fbhmipx
	    // bpfbbyyy
	    
	    //bpfbhmipx
	    
	    // bpfbbyyy
	    pfb
	    ->byyyy
	public static String longest(String str)
	{
	if(str==null||str.length()==0)
	    return str;
	String output;

	StringBuilder sb=new StringBuilder();
	for(int i=0;i<str.length();i++){
	    char c=str.charAt(i); // second 'b'
	    int index=sb.toString().indexOf(c);
	     String subString="";
	    if(index!=-1)
	    {
	       subString=sb.toString.substring(index+1,i)+c; 
	        sb=new StringBuilder(subString);
	    }
	    else{
	        sb.append(c);
	         subString=sb.toString();
	    }
	    if(subString.length()>output.length()) //output = 'bpf'
	            output=subString;
	}
	    return output;
	}*/



}

