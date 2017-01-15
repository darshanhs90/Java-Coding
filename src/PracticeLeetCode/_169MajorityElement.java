package PracticeLeetCode;

public class _169MajorityElement {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static void main(String[] args) {

	}
    public static int majorityElement(int[] nums) {
        if(nums==null||nums.length==0)
        	return 0;
        int count=1;
        int element=nums[0];
        for (int i = 1; i < nums.length; i++) {
			if(nums[i]==element)
			{
				count++;
			}else{
				if(count==1)
				{
					element=nums[i];
				}
				else
				{
					count--;
				}
			}
		}
        return element;
    }
}
