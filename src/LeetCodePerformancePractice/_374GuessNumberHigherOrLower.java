package LeetCodePerformancePractice;

public class _374GuessNumberHigherOrLower {
	public int guessNumber(int n) {
		int low=1,high=n;
		return getNumber(low,high);
	}
	private int getNumber(int left, int right) {
		while(left<=right)
		{
			int mid=left+(right-left)/2;
			int guessVal=guess(mid);
			if(guessVal==0)
				return mid;
			else if(guessVal==-1)
				right=mid-1;
			else
				left=mid+1;
		}
		return -1;
	}
	int guess(int num){
		return 0;
	}
}
