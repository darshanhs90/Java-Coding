package TopCoder;

/*
 * SRM 157 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1790&rd=4590
 */



public class SRM157GuessTheNumber {
	public static void main(String[] args) {
		System.out.println(noGuesses(9, 6));
		System.out.println(noGuesses(1000, 750));
		System.out.println(noGuesses(643, 327));
		System.out.println(noGuesses(157, 157));
		System.out.println(noGuesses(128, 64));
	}
	public static int noGuesses(int upper, int answer){
		int count=1;
		int lower=1;
		int mid=(int) Math.floor((lower+upper)/2);
		while(mid!=answer){
			if(mid>answer)
			{
				upper=mid-1;
			}else if(mid<answer){
				lower=mid+1;
			}
			mid=(int) Math.floor((lower+upper)/2);
			count++;
		}
		return count;
	}
}
