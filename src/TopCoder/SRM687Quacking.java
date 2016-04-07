package TopCoder;

import java.util.Arrays;

/*
 * SRM 687 Div2
 * Link:
 */



public class SRM687Quacking {
	public static void main(String[] args) {
		System.out.println(quack("quqacukqauackck"));
		System.out.println(quack("kcauq"));
		System.out.println(quack("quackquackquackquackquackquackquackquackquackquack"));
		System.out.println(quack("qqqqqqqqqquuuuuuuuuuaaaaaaaaaacccccccccckkkkkkkkkk"));
		System.out.println(quack("quqaquuacakcqckkuaquckqauckack"));
		System.out.println(quack("quackqauckquack"));
	}
	public static int quack(String s){
		int count=0;
		boolean arr[]=new boolean[s.length()];
		int numOfQs=0;
		String str=new String(s);
		char cArr[]=s.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			if(cArr[i]=='q')
				numOfQs++;
		}
		char prevChar='z';
		int counter=0;
		for (int i = 0; i < numOfQs; i++) {
			prevChar='z';

			for (int j = 0; j < s.length(); j++) {
				if(!arr[j]){
					if(prevChar=='z' && s.charAt(j)=='q')
					{	
						counter++;
						prevChar='q';
						arr[j]=true;
					}else if(prevChar=='k' && s.charAt(j)=='q')
					{
						counter++;
						prevChar='q';
						arr[j]=true;
					}else if(prevChar=='q' && s.charAt(j)=='u')
					{
						counter++;
						prevChar='u';
						arr[j]=true;
					}else if(prevChar=='u' && s.charAt(j)=='a')
					{
						counter++;
						prevChar='a';
						arr[j]=true;
					}else if(prevChar=='a' && s.charAt(j)=='c')
					{
						counter++;
						prevChar='c';
						arr[j]=true;
					}else if(prevChar=='c' && s.charAt(j)=='k')
					{
						counter++;
						prevChar='k';
						arr[j]=true;
					}
				}
			}
			if(prevChar=='k'){
				count++;
			}
			else if(prevChar!='k')
				return -1;
			if(counter==arr.length)
				break;
		}

		return prevChar=='k'?count:-1;
	}
}
