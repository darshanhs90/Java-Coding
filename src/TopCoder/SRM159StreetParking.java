package TopCoder;

/*
 * SRM 159 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1753&rd=4600
 */



public class SRM159StreetParking {
	public static void main(String[] args)  {
		System.out.println(freeParks("---B--S-D--S--"));
		System.out.println(freeParks("DDBDDBDDBDD"));
		System.out.println(freeParks("--S--S--S--S--"));
		System.out.println(freeParks("SSD-B---BD-DDSB-----S-S--------S-B----BSB-S--B-S-D"));
	}
	public static int freeParks(String street){
		int count=0;
		for (int i = 0; i < street.length(); i++) {
			if(street.charAt(i)=='-')
			{	
				if(((i+1)<street.length() && street.charAt(i+1)=='B') || ((i+2)<street.length() && street.charAt(i+2)=='B')
						||((i-1)>-1 && street.charAt(i-1)=='S' )|| ((i+1)<street.length() && street.charAt(i+1)=='S')){
					continue;
				}
				count++;
			}
		}
		return count;
	}
}
