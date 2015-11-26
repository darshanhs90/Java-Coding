package GeeksforGeeksPractice;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Link : http://www.geeksforgeeks.org/find-number-of-employees-under-every-manager/
 */
public class _0071EmployeesCount {

	public static void main(String[] args) {
		ArrayList<String> inputList=new ArrayList<>();
		inputList.add("A->C");
		inputList.add("B->C");
		inputList.add("C->F");
		inputList.add("D->E");
		inputList.add("E->F");
		inputList.add("F->F");
		findEmployees(inputList);
	}

	private static void findEmployees(ArrayList<String> inputList) {
		HashMap<String, ArrayList<String>> managerDirect=new HashMap<>();
		for (int i = 0; i < inputList.size(); i++) {
			String arr[]=inputList.get(i).split("->");
			if(!arr[0].contentEquals(arr[1]))
				if(managerDirect.containsKey(arr[1]))
				{	
					ArrayList<String> str=managerDirect.get(arr[1]);
					str.add(arr[0]);
					managerDirect.put(arr[1],str);
				}
				else{
					ArrayList<String> str=new ArrayList<>();
					str.add(arr[0]);
					managerDirect.put(arr[1],str);
				}
		}
		HashMap<String, Integer> countMap=new HashMap<>();
		for (int i = 0; i < inputList.size(); i++) {
			String element=inputList.get(i).split("->")[0];
			if(!managerDirect.containsKey(element))
			{
				countMap.put(element, 0);
			}
			else{
				ArrayList<String> elementList=managerDirect.get(element);
				int count=elementList.size();
				System.out.println(element+"//"+count);
				for (int j = 0; j < elementList.size(); j++) {
					if(countMap.containsKey(elementList.get(j)))	
						count+=countMap.get(elementList.get(j));
				}
				countMap.put(element, count);
			}
		}
		Object[] arr=countMap.keySet().toArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]+"->"+countMap.get(arr[i]));
		}









	}





}
