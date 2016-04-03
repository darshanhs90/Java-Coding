package TopCoder;

/*
 * SRM 153 Div2
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=1774&rd=4570
 */



public class SRM153MostProfitable {
	public static void main(String[] args) {
		System.out.println(bestItem(new int[]{100,120,150,1000},new int[]{110,110,200,2000},
				new int[]{20,100,50,3},new String[]{"Video Card","256M Mem","CPU/Mobo combo","Complete machine"}));
		System.out.println(bestItem(new int[]{100},new int[]{100},new int[]{134},new String[]{"Service, at cost"}));
		System.out.println(bestItem(new int[]{38,24},new int[]{37,23},new int[]{1000,643},new String[]{"Letter","Postcard"}));
		System.out.println(bestItem(new int[]{10,10},new int[]{11,12},new int[]{2,1},new String[]{"A","B"}));
		

	}
	static String bestItem(int[] costs, int[] prices, int[] sales, String[] items){
		String bestItem="";
		int maxProfit=0;
		for (int i = 0; i < items.length; i++) {
			int itemProfit=0;
			if(prices[i]>costs[i]){
				itemProfit=(prices[i]-costs[i])*sales[i];
				if(itemProfit>maxProfit){
					maxProfit=itemProfit;
					bestItem=items[i];
				}
			}
			
		}
		return bestItem;
	}
}
