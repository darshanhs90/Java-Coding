package TopCoder;

import java.util.Arrays;

/*
 * SRM 151 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1700&rd=4560
 */



public class SRM152LeaguePicks {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(returnPicks(3,6,15)));
		System.out.println(Arrays.toString(returnPicks(1,1,10)));
		System.out.println(Arrays.toString(returnPicks(1,2,39)));
		System.out.println(Arrays.toString(returnPicks(5,11,100)));
	}
	static int[] returnPicks(int position, int friends, int picks){
		int noOfFriends=friends;
		StringBuilder sb=new StringBuilder();
		boolean increasing=true;
		int friendsCount=1;
		for (int i = 1; i <=picks; i++) {
			if(friendsCount==position)
				sb.append(i+"/");

			if(increasing){
				friendsCount++;
				if(friendsCount>friends)
				{
					friendsCount=friends;
					increasing=false;
				}
			}else{
				friendsCount--;
				if(friendsCount<=0)
				{
					friendsCount=1;
					increasing=true;
				}
			}

		}
		String outputArray[]=(sb.toString().split("/"));
		int outputArr[]=new int[outputArray.length];

		for (int i = 0; i < outputArray.length; i++) {
			outputArr[i]=Integer.parseInt(outputArray[i]);
		}
		return outputArr;
	}
}
