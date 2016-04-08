package TopCoder;

/*
 * SRM 163 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1799&rd=4620
 */



public class SRM163InchWorm {
	public static void main(String[] args)  {
		System.out.println(lunchtime(11,2,4));
		System.out.println(lunchtime(12,6,4));
		System.out.println(lunchtime(20,3,7));
		System.out.println(lunchtime(21,7,3));
		System.out.println(lunchtime(15,16,5));
		System.out.println(lunchtime(1000,3,7));
		System.out.println(lunchtime(1000,7,3));
	}
	public static int lunchtime(int branch, int rest, int leaf){
		int count=0;
		int counter=0;
		while(counter<=branch){
			if(counter==0){
				count++;
				counter+=leaf;
				continue;
			}

			if(counter<rest)
			{
				counter+=leaf;
			}else if(counter>=rest){
				if(counter%rest==0)
					count++;
				counter+=leaf;
			}
		}
		return count;
	}
}
