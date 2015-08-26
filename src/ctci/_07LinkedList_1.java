package ctci;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;




/*Implementation of CTCI 2.1*/
public class _07LinkedList_1 {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(new InputStreamReader(System.in));
		int noOfElements=Integer.parseInt(scanner.nextLine());
		_02linkedList linkedList=new _02linkedList();
		String stringArray[]=scanner.nextLine().split(" ");
		scanner.close();
		for (int i = 0; i < stringArray.length; i++) {
			linkedList.add(Integer.parseInt(stringArray[i]));
		}
		_02linkedList finalList=removeDups(noOfElements, linkedList);
		for (int i = 0; i < finalList.size(); i++) {
			System.out.print(finalList.get(i)+" ");
		}
	}

	private static _02linkedList removeDups(int noOfElements, _02linkedList linkedList) {
		HashMap<Integer,Integer> hashedLinkedList=new HashMap<Integer, Integer>();
		_02linkedList finalList=new _02linkedList();
		for (int i = 0; i < noOfElements; i++) {
			if(hashedLinkedList.put(linkedList.get(i), linkedList.get(i))==null){
				finalList.add(linkedList.get(i));
			}
		}
		return finalList;
	}
}
