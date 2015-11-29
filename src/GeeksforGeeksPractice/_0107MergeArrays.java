package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/
 */
public class _0107MergeArrays {
	public static void main(String[] args) {
		int mPlusN[] = {2, 8, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 13, Integer.MAX_VALUE, 15, 20};
		int N[] = {5, 7, 9, 25};
		mergeArrays(mPlusN,N);
		System.out.println(Arrays.toString(mPlusN));
	}

	private static void mergeArrays(int[] mPlusN, int[] n) {
		int mn=mPlusN.length;
		Arrays.sort(mPlusN);
		int mIndex=0;
		for (int i = 0; i < mn; i++) {
			if(mPlusN[i]==Integer.MAX_VALUE){
				mIndex=i-1;
				break;
			}
		}
		int nIndex=n.length-1;
		for (int i = mPlusN.length-1; i>=0; i--) {
			if(mIndex>-1 && nIndex>-1)
				if(mPlusN[mIndex]>n[nIndex])
				{
					mPlusN[i]=mPlusN[mIndex];
					mIndex--;
				}
				else{
					mPlusN[i]=n[nIndex];
					nIndex--;
				}
			else
				if(mIndex==-1){
					mPlusN[i]=n[nIndex];
					nIndex--;
				}
				else
				{
					mPlusN[i]=mPlusN[mIndex];
					mIndex--;
				}
		}





	}


}
