package TopCoder;

/*
 * SRM 170 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1930&rd=4655
 */



public class SRM170LevelUp {
	public static void main(String[] args) {
		System.out.println(toNextLevel(new int[]{150,450,900,1800},133 ));
		System.out.println(toNextLevel(new int[]{150,450,900,1800},312));
		System.out.println(toNextLevel(new int[]{150,450,900,1800},612 ));
		System.out.println(toNextLevel(new int[]{150,450,900,1800},450));
	}
	public static int toNextLevel(int[] expNeeded, int received){
		int additionalExp=-1;
		for (int i = 0; i < expNeeded.length; i++) {
			if(additionalExp==-1)
			{
				additionalExp=expNeeded[0];
			}
			else{
				additionalExp=expNeeded[i]-expNeeded[i-1];
			}
			int diff=received-additionalExp;
			if(diff<0)
				return -received+additionalExp;
			received=received-additionalExp;
		}
		return received;
	}
}
