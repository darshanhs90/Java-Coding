package careerCup;

/*
 * Link: http://www.careercup.com/question?id=62018
 * A person can take one or two steps at a time to reach a particular floor( say in a building).
 * How many different ways can a person reach the nth floor?
 */
public class _08googleCareerCup {

	public static void main(String[] args) {
		System.out.println(findWays(6));
	}

	private static int findWays(int floor){
		int fibo[]=new int[floor+1];
		if(floor==1)
			return 1;
		fibo[0]=1;
		fibo[1]=1;
		for (int i = 2; i <=floor; i++) {
			fibo[i]=fibo[i-1]+fibo[i-2];
		}
		return fibo[floor];
	}
}
