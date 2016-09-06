package LeetCodePerformancePractice;

public class _011ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{1,1}));
	}

	private static int maxArea(int[] inputArray) {
		if(inputArray==null||inputArray.length<=0)
			return 0;
		int left=0,right=inputArray.length-1;
		int maxArea=0;
		while(left<right)
		{
			int height=Math.min(inputArray[left], inputArray[right]);
			int area=(right-left) * height;
			maxArea=Math.max(area, maxArea);
			if(inputArray[left]>inputArray[right])
			{
				right--;
			}
			else
				left++;
		}
		return maxArea;
	}
   
    
}
