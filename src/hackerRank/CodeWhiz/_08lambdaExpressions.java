package hackerRank.CodeWhiz;

/*
 * Maximum and Minimum
 * Link:https://www.hackerrank.com/contests/codewhiz-java-march-2016/challenges/maximum-and-minimum
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
interface performOperation{
	int check(int a);
}
class Math1{
	public static int checker(performOperation p ,int num){
		return p.check(num);
	}
	public performOperation checkEvenOdd() {
		return (a) -> a%2 ;
	}
	public performOperation checkPrime() {
		
		return (a)->{
			for(int i=2;i<a/2;i++)
			{
				if(a%i==0)
					return 1;
			}
			return 0;
		};
	}
	public performOperation checkPalindrome() {
		return (a)->{
			String str=a+"";
			StringBuilder stringBuilder=new StringBuilder(str);
			stringBuilder.reverse();
			if(str.contentEquals(stringBuilder.toString()))
				return 0;
			return 1;		
		};
	}
}
	public class _08lambdaExpressions {

		public static void main(String[] args)throws IOException {
			Math1 ob = new Math1();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T=Integer.parseInt(br.readLine());
			performOperation op;
			int ret =0;
			String ans=null;
			while(T-->0){
				String s=br.readLine().trim();
				StringTokenizer st=new StringTokenizer(s);
				int ch=Integer.parseInt(st.nextToken());
				int num=Integer.parseInt(st.nextToken());
				if(ch==1){
					op = ob.checkEvenOdd();  
					ret = ob.checker(op,num);
					ans = (ret == 0)?"EVEN":"ODD";
				}
				else if(ch==2){
					op = ob.checkPrime();
					ret = ob.checker(op,num);
					ans = (ret == 0)?"PRIME":"COMPOSITE";
				}
				else if(ch==3){
					op = ob.checkPalindrome();
					ret = ob.checker(op,num);
					ans = (ret == 0)?"PALINDROME":"NOT PALINDROME";

				}
				System.out.println(ans);
			}
		}

	}
