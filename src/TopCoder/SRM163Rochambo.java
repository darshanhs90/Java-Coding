package TopCoder;

/*
 * SRM 163 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1810&rd=4620
 */



public class SRM163Rochambo {

	public static void main(String[] args) {
		System.out.println(wins("PS"));
		System.out.println(wins("PSRRPS"));
		System.out.println(wins("PSRPSRPRSR"));
		System.out.println(wins("SRPSRPSPRSPRPSRPSRP"));
		System.out.println(wins("RPPPRRPSSSRRRSRSPPSSPRRPSRRRRSPPPPSSPSSSSSRSSSRPRR"));
	}
	public static int wins(String opponent){
		int noOfWins=0;
		StringBuilder myBets=new StringBuilder("RR");
		for (int i = 0; i < opponent.length(); i++) {
			if(i<=1)
			{
				noOfWins+=checkWin(myBets.charAt(i),opponent.charAt(i));
			}
			else{
				noOfWins+=checkWin(findWinner(predict(opponent.substring(i-2,i))),opponent.charAt(i));
			}
		}
		return noOfWins;

	}
	private static char findWinner(char predict) {
		if(predict=='R')
			return 'P';
		else if(predict=='P')
			return 'S';
		else 
			return 'R';	
	}
	private static char predict(String substring) {
		if(substring.charAt(0)==substring.charAt(1))
			return substring.charAt(0);
		else{
			if(substring.indexOf('R')!=-1 && substring.indexOf('P')!=-1){
				return 'S';
			}else if(substring.indexOf('R')!=-1 && substring.indexOf('S')!=-1){
				return 'P';
			}else{//PS
				return 'R';
			}
		}
	}
	private static int checkWin(char myBet, char opponentBet) {
		if((myBet=='R' && opponentBet=='S')||(myBet=='S' && opponentBet=='P')||(myBet=='P' && opponentBet=='R'))
			return 1;
		return 0;
	}

}
