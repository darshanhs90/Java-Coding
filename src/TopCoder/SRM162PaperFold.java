package TopCoder;

/*
 * SRM 162 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1792&rd=4615
 */



public class SRM162PaperFold {
	public static void main(String[] args)  {
		System.out.println(numFolds(new int[]{8, 11},new int[]{6, 10}));
		System.out.println(numFolds(new int[]{11, 17},new int[]{6, 4}));
		System.out.println(numFolds(new int[]{11, 17},new int[]{5, 4}));
		System.out.println(numFolds(new int[]{1000,1000},new int[]{62,63}));
		System.out.println(numFolds(new int[]{100,30},new int[]{60,110}));
		System.out.println(numFolds(new int[]{1895, 6416},new int[]{401, 1000}));
	}
	public static int numFolds(int[] paper, int[] box){
		int divisions=0;
		divisions=performDivision(paper[0],paper[1],box,0);
		return divisions>8?-1:divisions;
	}
	private static int performDivision(double paperWidth,double paperHeight,int[] box,int count) {
		if(checkPaperAccomodation(paperWidth,paperHeight,box))
			return count;
		if(paperWidth<=0 ||paperHeight<=0||count>8)
			return Integer.MAX_VALUE;
		return Math.min(performDivision(paperWidth/2,paperHeight, box,count+1),performDivision(paperWidth,paperHeight/2, box,count+1));

	}
	private static boolean checkPaperAccomodation(double paperWidth,double paperHeight,int[] box) {
		int boxWidth=box[0];
		int boxHeight=box[1];
		return((paperWidth<=boxWidth && paperHeight<=boxHeight)
				||(paperWidth<=boxHeight && paperHeight<=boxWidth));
	}
}
