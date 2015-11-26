package GeeksforGeeksPractice;

import java.util.HashSet;
import java.util.Set;

/*
 * Link : http://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
 */
public class _0067UnionIntersectionLists {

	public static void main(String[] args) {
		ListNode ln1=new ListNode(10);
		ln1.next=new ListNode(15);
		ln1.next.next=new ListNode(4);
		ln1.next.next.next=new ListNode(20);
		
		ListNode ln2=new ListNode(8);
		ln2.next=new ListNode(4);
		ln2.next.next=new ListNode(2);
		ln2.next.next.next=new ListNode(10);
		
		union(ln1,ln2);
		intersection(ln1,ln2);
	}


	private static void intersection(ListNode ln1, ListNode ln2) {
		Set<Integer> elementMap=new HashSet<>();
		while(ln1!=null){
			elementMap.add(ln1.value);
			if(ln1.next==null)
			{
				break;
			}
			ln1=ln1.next;
		}
		ListNode lnI;
		while(ln1!=null)
		{
			if(elementMap.contains(ln2.value))
			{
				lnI=new ListNode(ln2.value);
				lnI=lnI.next;
			}
			ln2=ln2.next;
		}	
		
	}


	private static void union(ListNode ln1, ListNode ln2) {
		Set<Integer> elementMap=new HashSet<>();
		while(ln1!=null){
			elementMap.add(ln1.value);
			if(ln1.next==null)
			{
				break;
			}
			ln1=ln1.next;
		}
		while(ln1!=null)
		{
			if(!elementMap.contains(ln2.value))
			{
				ln1.next=new ListNode(ln2.value);
				ln1=ln1.next;
			}
			ln2=ln2.next;
		}		
	}


	static class ListNode{
		ListNode next;
		int value;
		public ListNode(int value) {
			this.value=value;
		}
	}

}
