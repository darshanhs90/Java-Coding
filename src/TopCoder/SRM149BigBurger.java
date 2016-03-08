package TopCoder;

/*
 * SRM 149 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1648&rd=4550
 */



public class SRM149BigBurger {
	public static void main(String[] args) {
		System.out.println(maxWait(new int[]{3,3,9},new int[]{2,15,14}));
		System.out.println(maxWait(new int[]{182},new int[]{11}));
		System.out.println(maxWait(new int[]{2,10,11},new int[]{3,4,3}));
		System.out.println(maxWait(new int[]{2,10,12},new int[]{15,1,15}));		
	}

	public static int maxWait(int[] arrival, int[] service){
		if(service.length==1)
			return 0;
		int maxWaitTime=0;
		int completionTime=arrival[0]+service[0];
		for (int i = 1; i < arrival.length; i++) {
			if(arrival[i]<completionTime)
			{
				maxWaitTime=Math.max(maxWaitTime, completionTime-arrival[i]);
				completionTime+=service[i];
			}
			else{
				completionTime=service[i]+arrival[i];
			}
		}
		return maxWaitTime;
	}
}
