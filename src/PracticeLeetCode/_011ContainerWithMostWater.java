package PracticeLeetCode;

public class _011ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{1,1}));
	}
	public static int maxArea(int[] height) {
		if(height==null||height.length==0)
			return 0;
		int maxArea=0;
		int left=0,right=height.length-1;
		while(left<right){
		    maxArea=Math.max(maxArea,(right-left)* Math.min(height[right],height[left]));
			if(height[left]<height[right])
			{
				left++;
			}else{
				right--;
			}
		}
		return maxArea;
	}


}
