package TopCoder;

/*
 * SRM 152 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1765&rd=4565
 */



public class SRM152FixedPointTheorem {
	public static void main(String[] args) {
		System.out.println(cycleRange(0.1));
		System.out.println(cycleRange(3.05));
		System.out.println(cycleRange(3.4499));
		System.out.println(cycleRange(3.55));
		System.out.println(cycleRange(3.565));
		System.out.println(cycleRange(3.5689));
		System.out.println(cycleRange(3.00005));
	}
	static double cycleRange(double R){
		double max=Integer.MIN_VALUE;
		double min=Integer.MAX_VALUE;
		double x=0.25;
		for (int i = 1; i <=201000; i++) {
			if(i<200001)
				x=R*x*(1-x);
			else{
				x=R*x*(1-x);
				max=Math.max(x, max);
				min=Math.min(x, min);
			}
		}
		return max-min;
	}
}
