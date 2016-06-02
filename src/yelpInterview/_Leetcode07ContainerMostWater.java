package yelpInterview;

public class _Leetcode07ContainerMostWater {


	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{0,2}));

	}


	public static int maxArea(int[] height) {
		if(height.length==0||height.length<2)
			return 0;
		int left=0;
		int right=height.length-1;
		int max=0;
		while(left<right)
		{
			if(height[left]>height[right])
			{
				max=Math.max(max,(right-left) * height[right]);
				right--;
			}else{
				max=Math.max(max,(right-left) * height[left]);
				left++;
			}

		}
		return max;
	}

}

