package yelpInterview;

public class _Matrix08RowWithMaxOnes {
	public static void main(String a[]){
		int mat[][]={ {0, 0, 0, 1},
				{0, 1, 1, 1},
				{1, 1, 1, 1},
				{0, 0, 0, 0}
		};
		System.out.println(findRowMaxOnes(mat));
	}

	private static int findRowMaxOnes(int[][] mat) {
		int index=-1,onesCount=0;
		for (int i = 0; i < mat.length; i++) {
			int startIndex=getIndex(mat[i],0,mat[i].length-1,1);
			if(startIndex!=-1 && mat[0].length-1-startIndex>onesCount )
			{
				onesCount=mat[0].length-1-startIndex;
				index=i;
			}	
		}
		return index;
	}

	private static int getIndex(int[] mat,int low,int high,int value) {
		if(low<=high)
		{
			int mid=(low+high)/2;
			if((mid==0||mat[mid]>mat[mid-1]) && mat[mid]==value)
			{
				return mid;
			}
			if(mat[mid]<value)
				return getIndex(mat, mid+1, high, value);
			else
				return getIndex(mat, low, mid-1, value);
		}
		return -1;
	}





}