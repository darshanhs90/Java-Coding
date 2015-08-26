package ctci;

import java.io.InputStreamReader;
import java.util.Scanner;

import ctci._02linkedList.Node;




/*Implementation of CTCI 2.5*/
public class _07LinkedList_4 {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(new InputStreamReader(System.in));
		System.out.println("Enter First Number");
		String firstNumberArray[]=scanner.nextLine().split("");
		_02linkedList firstNumberList=new _02linkedList();
		for (int i = firstNumberArray.length-1; i >0 ; i--) {

			firstNumberList.add(Integer.parseInt(firstNumberArray[i]));
		}
		System.out.println("Enter Second Number");
		String secondNumberArray[]=scanner.nextLine().split("");
		scanner.close();
		_02linkedList secondNumberList=new _02linkedList();
		for (int i = secondNumberArray.length-1; i >0 ; i--) {
			secondNumberList.add(Integer.parseInt(secondNumberArray[i]));
		}
		_02linkedList addedList=addNumbers(firstNumberList,secondNumberList);
		Node addedListNode=addedList.getHeadNode();
		StringBuffer outputStringBuffer=new StringBuffer();
		while(addedListNode!=null){
			outputStringBuffer.append(addedListNode.data);
			addedListNode=addedListNode.next;
		}
		System.out.println(outputStringBuffer.reverse().toString());
	}

	private static _02linkedList addNumbers(_02linkedList firstNumberList,
			_02linkedList secondNumberList) {
		int carry=0;
		Node firstNumberNode=firstNumberList.getHeadNode();
		Node secondNumberNode=secondNumberList.getHeadNode();
		_02linkedList finalList=new _02linkedList();
		while(firstNumberNode!=null && secondNumberNode!=null)
		{
			String outputStringArray[]=String.valueOf((firstNumberNode.data+secondNumberNode.data+carry)).split("");
			if(outputStringArray.length>2){
				carry=Integer.parseInt(outputStringArray[1]);
				finalList.add(Integer.parseInt(outputStringArray[2]));
			}
			else{
				carry=0;
				finalList.add(Integer.parseInt(outputStringArray[1]));
			}
			firstNumberNode=firstNumberNode.next;
			secondNumberNode=secondNumberNode.next;
		}
		Node mainNode;
		if(firstNumberNode==null)
		{
			mainNode=firstNumberNode;
		}
		else{
			mainNode=secondNumberNode;
		}
		while(mainNode!=null){
			String outputStringArray[]=String.valueOf((mainNode.data+carry)).split("");
			if(outputStringArray.length>1){
				carry=Integer.parseInt(outputStringArray[0]);
				finalList.add(Integer.parseInt(outputStringArray[1]));
			}
			else{
				carry=0;
				finalList.add(Integer.parseInt(outputStringArray[0]));
			}
			mainNode=mainNode.next;
		}
		return finalList;
	}


}
