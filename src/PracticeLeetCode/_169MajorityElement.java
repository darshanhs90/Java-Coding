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
	public int majorityElement(int[] nums) {
		int count=0,element=0;
		for (int i = 0; i < nums.length; i++) {
			if(count==0)
			{
				count++;
				element=nums[i];
			}
			else if(nums[i]==element)
				count++;
			else
				count--;
		}
		return element;
	}
}
