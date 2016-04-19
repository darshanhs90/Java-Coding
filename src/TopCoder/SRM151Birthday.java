package TopCoder;

/*
 * SRM 151 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1739&rd=4560
 */



public class SRM151Birthday {
	public static void main(String[] args) {
		System.out.println(getNext( "06/17",new String[]{"02/17 Wernie", "10/12 Stefan"}));
	}
	public static String getNext(String date, String[] birthdays){
		int monthVal=Integer.parseInt(date.substring(0,2));
		int dateVal=Integer.parseInt(date.substring(3,5));
		System.out.println(dateVal+"/"+monthVal);
		int outputDateVal=Integer.MIN_VALUE,outputMonthVal=Integer.MIN_VALUE;
		int diffDateVal,diffMonthVal;
		for (int i = 0; i < birthdays.length; i++) {
			int ithMonth=Integer.parseInt(birthdays[i].substring(0,2));
			int ithDate=Integer.parseInt(birthdays[i].substring(3,5));
			int monthDiff=ithMonth-monthVal;
			int dateDiff=ithDate-dateVal;
			if(monthDiff<0)
			{
				if(dateDiff>0){
					
				}else if(dateDiff<0){
					
				}else{

				}
			}
			else if(monthDiff>0)
			{
				if(dateDiff>0){

				}else if(dateDiff<0){

				}else{

				}
			}
			else{
				if(dateDiff>0){

				}else if(dateDiff<0){

				}else{

				}
			}
		}
		return  "";
	}

}
