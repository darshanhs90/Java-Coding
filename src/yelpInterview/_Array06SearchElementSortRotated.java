package yelpInterview;

import java.util.Arrays;

public class _Array06SearchElementSortRotated {
	public static void main(String a[]){
		int mPlusN[] = {2, 8, -1, -1, -1, 13, 15, 20,-1};
		int N[] = {5, 7, 9, 25};
		System.out.println(Arrays.toString(mergeTwoSortedArrays(mPlusN,N)));

	}

	private static  int[] mergeTwoSortedArrays(int[] mPlusN, int[] N) {
		int swapIndex=mPlusN.length-1;
		for (int i = mPlusN.length-1; i >=0; i--) {
			if(mPlusN[i]!=-1)
			{
				mPlusN=swap(mPlusN,i,swapIndex);
				swapIndex--;
			}
		}
		int mPlusNIndex=swapIndex+1;
		int nIndex=0;
		for (int i = 0; i < mPlusN.length; i++) {
			if(mPlusNIndex>mPlusN.length-1){
				mPlusN[i]=N[nIndex];
				nIndex++;
				continue;
			}
			if(nIndex>N.length-1){
				mPlusN[i]=mPlusN[mPlusNIndex];
				mPlusNIndex++;
				continue;
			}
			if(mPlusN[mPlusNIndex]>N[nIndex])
			{
				mPlusN[i]=N[nIndex];
				nIndex++;
			}
			else
			{
				mPlusN[i]=mPlusN[mPlusNIndex];
				mPlusNIndex++;
			}
		}
		return mPlusN;
	}

	private static int[] swap(int[] mPlusN, int i, int swapIndex) {
		mPlusN[i]=mPlusN[i]^mPlusN[swapIndex];
		mPlusN[swapIndex]=mPlusN[i]^mPlusN[swapIndex];
		mPlusN[i]=mPlusN[i]^mPlusN[swapIndex];
		return mPlusN;
	}
}