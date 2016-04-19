package yelpInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Link:https://www.careercup.com/question?id=6213156200251392
 */
public class _05RestaurantType {


	public static void main(String a[]){
		Scanner scanner=new Scanner(System.in);
		int noOfRestaurant=Integer.parseInt(scanner.nextLine());
		String input="'American':'[Burger, French fries, Potato Chips]'";
		String input1="'Italian':'[Pizza,Bread Sticks, Potato Chips]'";
		HashMap<String, ArrayList<String>> restMap=new HashMap<>();
		for (int i = 0; i < noOfRestaurant; i++) {
			String inputArray[]=scanner.nextLine().split(":");
			String restaurantName=inputArray[0].replace("'", "");
			String foodArray[]=inputArray[1].replace("]", "").replace("[", "").split(",");
			ArrayList<String> aList=new ArrayList<>();
			for (int j = 0; j < foodArray.length; j++) {
				aList=new ArrayList<>();
				aList.add(restaurantName);
				String food=foodArray[j].trim().replace("'", "");
				if(restMap.containsKey(food)){
					aList=restMap.get(food);
					aList.add(restaurantName);
				}
				restMap.put(food, aList);
			}

		}
		System.out.println(restMap);
		System.out.println(restMap.get("Potato Chips"));

	}
}






