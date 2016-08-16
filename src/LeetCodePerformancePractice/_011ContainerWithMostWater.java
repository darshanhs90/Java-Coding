package LeetCodePerformancePractice;

public class _011ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{}));
	}
    public static int maxArea(int[] height) {
        if(height==null || height.length==0)
        	return 0;
    	int left=0,right=height.length-1;
    	int max=0;
    	while(left<right)
    	{
    		int area=Math.min(height[left], height[right])*(right-left);
    		max=Math.max(max, area);
    		if(height[left]<height[right])
    			left++;
    		else
    			right--;
    	}
    	return max;
    }
}
