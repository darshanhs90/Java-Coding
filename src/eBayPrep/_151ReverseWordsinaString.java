package eBayPrep;

public class _151ReverseWordsinaString {
	public static void main(String[] args) {
		System.out.println(reverseWords("the sky     is blue"));
		System.out.println(reverseWords(" 1"));
	}
	public static String reverseWords1(String str) {
		if(str==null||str.length()==0)return str;
		str=str.replaceAll("[ ]+", " ");
		char c[]=str.toCharArray();
		int left=0,right=str.length()-1;
		while(left<right)
		{
			char temp=c[left];
			c[left]=c[right];
			c[right]=temp;
			left++;right--;
		}
		left=right=0;
		for (int i = 0; i < c.length; i++) {
			if(c[i]==' ')
			{
				right=i-1;
				while(left<right)
				{
					char temp=c[left];
					c[left]=c[right];
					c[right]=temp;
					left++;right--;
				}
				left=-1;		
			}
			else if(left==-1)
			{
				left=i;
			}
		}
		if(c[c.length-1]!=' ')
		{
			right=c.length-1;
			while(left<right)
			{
				char temp=c[left];
				c[left]=c[right];
				c[right]=temp;
				left++;right--;
			}
		}
		return new String(c);
	}

	public static String reverseWords(String str) {
		str=str.replaceAll("[ ]+", " ");
		String arr[]=str.split(" ");
		StringBuilder sb=new StringBuilder();
		for (int i = arr.length-1; i >=0; i--) {
			sb.append(arr[i].trim());
			if(i!=0)
				sb.append(" ");
		}
		return sb.toString().trim();
	}
}

