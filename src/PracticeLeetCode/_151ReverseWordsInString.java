package PracticeLeetCode;

public class _151ReverseWordsInString {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue"));
		System.out.println("a->"+reverseWords("   a   b ")+"<-a");
	}
	public static String reverseWords(String s) {
		if(s==null||s.length()==0)
			return s;
		s=s.trim().replaceAll("[ ]+", " ");
		System.out.println(s);
		String[] arr=s.split(" ");
		StringBuilder sb=new StringBuilder();
		for (int i = arr.length-1; i >=0; i--) {
			if(i!=0)
				sb.append(arr[i]+" ");
			else
				sb.append(arr[i]);
		}
		return sb.toString();
	}
}
