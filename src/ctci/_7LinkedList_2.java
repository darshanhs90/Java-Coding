package ctci;

import java.io.InputStreamReader;
import java.util.Scanner;

import ctci._2linkedList.Node;




/*Implementation of CTCI 2.2*/
public class _7LinkedList_2 {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(new InputStreamReader(System.in));
		System.out.println("Enter K value");
		int k=Integer.parseInt(scanner.nextLine());
		System.out.println("Enter linked list size");
		int noOfElements=Integer.parseInt(scanner.nextLine());
		System.out.println("Enter single spaced elements");
		_2linkedList linkedList=new _2linkedList();
		String stringArray[]=scanner.nextLine().split(" ");
		for (int i = 0; i < noOfElements; i++) {
			linkedList.add(Integer.parseInt(stringArray[i]));
		}
		scanner.close();
		int kthLastElement=getKthLastElement(linkedList,k);
		System.out.println("Kth to last element is : "+kthLastElement);
	}

	private static int getKthLastElement(_2linkedList linkedList, int k) {
		if(k>linkedList.size())
			return Integer.MIN_VALUE;
		Node pointerOneNode=linkedList.getHeadNode();
		Node pointerTwoNode=linkedList.getHeadNode();
		for (int i = 0; i < k; i++) {
			pointerOneNode=pointerOneNode.next;
		}
		while (pointerOneNode.next!=null) {
			pointerOneNode=pointerOneNode.next;
			pointerTwoNode=pointerTwoNode.next;
		}
		return pointerTwoNode.data;
	}
}
