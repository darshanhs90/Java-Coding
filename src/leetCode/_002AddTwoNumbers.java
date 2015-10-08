package leetCode;

/*
 * Link : https://leetcode.com/problems/add-two-numbers/
 */

public class _002AddTwoNumbers {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		StringBuilder numberString1=new StringBuilder();
		StringBuilder numberString2=new StringBuilder();
		while(l1!=null){
			numberString1.append(l1.val+"");
			l1=l1.next;
		}
		while(l2!=null){
			numberString2.append(l2.val+"");
			l2=l2.next;
		}
		int outputValue=Integer.parseInt(numberString1.toString())+Integer.parseInt(numberString2.toString());
		String outputString=String.valueOf(outputValue);

		ListNode ln1 = null,ln2 = null,ln3 = null;
		for (int i = outputString.length()-1; i >=0; i--) {
			if(ln1==null){
				ln1=new ListNode(Integer.parseInt(outputString.charAt(i)+""));
			}
			else if(ln2==null){
				ln2=new ListNode(Integer.parseInt(outputString.charAt(i)+""));
			}
			else if(ln3==null){
				ln3=new ListNode(Integer.parseInt(outputString.charAt(i)+""));
			}
		}
		if(ln2!=null)
			ln2.next=ln3;
		if(ln1!=null)
			ln1.next=ln2;
		return ln1;
	}
	public static void main(String[] args) {
		ListNode l1= new ListNode(0);
		/*l1.next=new ListNode(4);
		l1.next.next=new ListNode(3);*/
		ListNode l2=new ListNode(0);
		/*l2.next=new ListNode(6);
		l2.next.next=new ListNode(4);	*/
		ListNode l3=addTwoNumbers(l1, l2);

		while(l3!=null){
			System.out.println(l3.val);
			l3=l3.next;
		}
		/*while(l2!=null){
			System.out.println(l2.val);
			l2=l2.next;
		}*/

	}
}