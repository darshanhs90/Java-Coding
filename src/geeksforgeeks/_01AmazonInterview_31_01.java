package geeksforgeeks;




/*
 * http://www.geeksforgeeks.org/amazon-interview-set-31/
 * a[] = {a,b,c,d,e} b[]={f,g,h} result should be = af+bg+ch+df+eg
 */;
 public class _01AmazonInterview_31_01 {
	 public static void main(String[] args) {
		 String a[]={"a","b","c","d","e"};
		 String b[]={"f","g","h"};
		 System.out.println(getSum(a,b)); 
	 }

	 private static String getSum(String[] a, String[] b) {
		 if(a.length>b.length)
			 return getSummation(a,b);
		 else
			 return getSummation(b,a);
	 }

	 private static String getSummation(String[] a, String[] b) {
		 StringBuffer sb=new StringBuffer();
		 for (int i = 0; i < a.length; i++) {
			 sb.append(a[i]+b[i%b.length]+"+");
		 }
		 return sb.toString().substring(0,sb.toString().length()-1);
	 }
 }