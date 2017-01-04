package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _089GrayCode {
	public static void main(String[] args) {
		System.out.println(grayCode(2));
	}
	public static List<Integer> grayCode(int n) {
		List<Integer> list=new ArrayList<Integer>();
		if(n<=0){
			list.add(0);
			return list;
		}
		List<String> strList=new ArrayList<String>();
		strList.add("0");
		strList.add("1");

		for (int i = 2; i <=n; i++) {
			List<String> strListNew=new ArrayList<String>();
			for (int j = 0; j < strList.size(); j++) {
				if(j%2==0)
				{
					strListNew.add(strList.get(j)+"0");
					strListNew.add(strList.get(j)+"1");
				}
				else
				{
					strListNew.add(strList.get(j)+"1");
					strListNew.add(strList.get(j)+"0");
				}
			}
			strList=strListNew;
		}
		for (int i = 0; i < strList.size(); i++) {
			list.add(Integer.parseInt(strList.get(i), 2));
		}
		return list;
	}
}