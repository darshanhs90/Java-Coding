package TopCoder;

/*
 * SRM 153 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1772&rd=4570
 */



public class SRM153Inventory {
	public static void main(String[] args) {
		System.out.println(monthlyOrder(new int[]{5}, new int[]{15}));
		System.out.println(monthlyOrder(new int[]{75,120,0,93}, new int[]{24,30,0,30}));
		System.out.println(monthlyOrder(new int[]{8773}, new int[]{16}));
		System.out.println(monthlyOrder(new int[]{1115,7264,3206,6868,7301}, new int[]{1,3,9,4,18}));

	}
	public static int monthlyOrder(int[] sales, int[] daysAvailable){
		int count=0;
		double total=0;
		for (int i = 0; i < daysAvailable.length; i++) {
			if(daysAvailable[i]==0)
				continue;
			total+=sales[i]*30/(float)daysAvailable[i];
			count++;
		}
		return (int)Math.ceil(total/count);
	}
}
