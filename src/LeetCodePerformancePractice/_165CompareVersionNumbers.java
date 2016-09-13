package LeetCodePerformancePractice;

public class _165CompareVersionNumbers {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static void main(String[] args) {
		System.out.println(compareVersion("1", "0"));

	}
	public static int compareVersion(String version1, String version2) {
		String v1[]=version1.split("\\.");
		String v2[]=version2.split("\\.");
		int length=Math.max(v1.length, v2.length);
		for (int i = 0; i < length; i++) {
			if(i<v1.length && i<v2.length){
				if(Integer.parseInt(v1[i])>Integer.parseInt(v2[i]))
					return 1;
				else if(Integer.parseInt(v1[i])<Integer.parseInt(v2[i]))
					return -1;
			}
			else if(i<v1.length){
				if(Integer.parseInt(v1[i])>0)
					return 1;
			}
			else{
				if(Integer.parseInt(v2[i])>0)
					return -1;
			}
		}
		return 0;
	}
}
