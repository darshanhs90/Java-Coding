package PracticeLeetCode;

public class _011ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{1,1}));
	}
	public static int maxArea(int[] height) {
		int maxArea=Integer.MIN_VALUE;
		int left=0,right=height.length-1;
		while(left<=right){
			if(height[left]>height[right])
			{
				maxArea=Math.max(maxArea,(right-left)*Math.min(height[left], height[right]));
				right--;
			}
			else{
				maxArea=Math.max(maxArea,(right-left)*Math.min(height[left], height[right]));
				left++;
			}
		}
		return maxArea;
	}


}
