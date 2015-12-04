package Warmup;

/*
 * 
 */	
public class _55squareSkype2 {


	public static void main(String args[]){

		System.out.println(checkNumber(49927398716l));
	}

	private static boolean checkNumber(Long i) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder(i.toString());
		sb.reverse();
		String str=sb.toString();
		int oddSum=0,evenSum=0;
		for (int j = 0; j < str.length(); j++) {
			if(j%2==0)
			{
				evenSum+=Integer.parseInt(str.charAt(j)+"");
			}
			else{
				int value=2*Integer.parseInt(str.charAt(j)+"");
				if(value>9)
				{
					String strn=String.valueOf(value);
					value=0;
					for (int k = 0; k < strn.length(); k++) {
						value+=Integer.parseInt(strn.charAt(k)+"");
					}
				}
				oddSum+=value;
			}
		}
		if((oddSum+evenSum)%10==0)
			return true;
		return false;
	}

}