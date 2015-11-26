package GeeksforGeeksPractice;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Link : http://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
 */
public class _0070ItineraryFinder {

	public static void main(String[] args) {
		ArrayList<String> inputList=new ArrayList<>();
		inputList.add("Chennai->Banglore");
		inputList.add("Bombay->Delhi");
		inputList.add("Goa->Chennai");
		inputList.add("Delhi->Goa");
		findItinerary(inputList);
	}

	private static void findItinerary(ArrayList<String> inputList) {
		HashMap<String, String> inputMap=new HashMap<>();
		HashMap<String, String> reverseInputMap=new HashMap<>();
		
		for (int i = 0; i < inputList.size(); i++) {
			String str[]=inputList.get(i).split("->");
			inputMap.put(str[0], str[1]);
			reverseInputMap.put(str[1], str[0]);
		}
		
		Object[] keyArray=inputMap.keySet().toArray();
		String startingPoint = null;
		for (int i = 0; i < keyArray.length; i++) {
			if(!reverseInputMap.containsKey(keyArray[i]))
			{
				startingPoint=(String) keyArray[i];
			}
		}
		StringBuilder sb=new StringBuilder();
		int count=0;
		while(count<inputList.size())
		{
			sb.append(startingPoint+"->");
			startingPoint=inputMap.get(startingPoint);
			count++;
		}
		sb.append(startingPoint);
		System.out.println(sb.toString());
	}



}
