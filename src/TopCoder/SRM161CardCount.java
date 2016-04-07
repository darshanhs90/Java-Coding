package TopCoder;

import java.util.Arrays;

/*
 * SRM 161 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1800&rd=4610
 */



public class SRM161CardCount {
	public static void main(String[] args)  {
		System.out.println(Arrays.toString(dealHands(6,"012345012345012345")));
		System.out.println(Arrays.toString(dealHands(4,"111122223333")));
		System.out.println(Arrays.toString(dealHands(1,"012345012345012345")));
		System.out.println(Arrays.toString(dealHands(6,"01234")));
		System.out.println(Arrays.toString(dealHands(2,"")));
		System.out.println(Arrays.toString(dealHands(19,"405432699259465009801237421388432461095898946221")));
		System.out.println(Arrays.toString(dealHands(21, "3439434422834490897438978957869323202")));
	}
	public static String[] dealHands(int numPlayers, String deck){
		String[] outputArray=new String[numPlayers];
		Arrays.fill(outputArray, "");
		if(deck.length()<numPlayers)
			return outputArray;
		int counter=0;
		int x=deck.length()/numPlayers;
		for (int i = 0; i < numPlayers*x; i++) {
			outputArray[counter]=outputArray[counter]+deck.charAt(i);
			counter++;
			if(counter>=numPlayers)
				counter=0;
		}
		return outputArray;
	}
}
