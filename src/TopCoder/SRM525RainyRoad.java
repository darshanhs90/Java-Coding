package TopCoder;

/*
 * SRM 525 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=11635
 */

public class SRM525RainyRoad {
	
	
	
	public static void main(String[] args) {
		System.out.println(isReachable2(new String[]{".W.."
			,"...."}));
		System.out.println(isReachable2(new String[]{".W.."
				,"..W."}));
		System.out.println(isReachable2(new String[]{".W..W.."
				,"...WWW."}));
		System.out.println(isReachable2(new String[]    	
				{"..",
				"WW"}));
		System.out.println(isReachable2(new String[]    	
				{".WWWW."
				,"WWWWWW"}));
		
		System.out.println(isReachable2(new String[]    	
				{".W.W.W." 
				,"W.W.W.W"}));
		
		System.out.println(isReachable2(new String[]    	
				{".............................................W."
				,".............................................W."}));
		
		
		
	}
	public static String isReachable(String[] road){
		int index=0;
		for (int i = 0; i < road[0].length(); i++) {
			if(road[0].charAt(i)=='W' && road[1].charAt(i)=='W')
				return "NO";

			if(road[0].charAt(i)=='.' && road[1].charAt(i)=='.')
			{
				index=2;
			}
			else if(index==2){
				if(road[0].charAt(i)=='.' || road[1].charAt(i)=='.')
				{
					index=road[0].charAt(i)=='.'?0:1;
				}
			}
			else{
				if(index==0 && road[0].charAt(i)=='W')
					return "NO";
				else if(index==1 && road[1].charAt(i)=='W')
					return "NO";
			}
		}

		return index==0||index==2?"YES":"NO";
	}
	public static String isReachable2(String[] road){
		for (int i = 0; i < road[0].length(); i++) {
			if(road[0].charAt(i)=='W' && road[1].charAt(i)=='W'){
				return "NO";
			}
		}
		return road[0].charAt(road[0].length()-1)=='.'?"YES":"NO";
	}
}
