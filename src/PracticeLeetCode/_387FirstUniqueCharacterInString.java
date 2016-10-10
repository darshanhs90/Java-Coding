package PracticeLeetCode;

public class _387FirstUniqueCharacterInString {
	public static void main(String[] args) {
		System.out.println(firstUniqChar("loveleetcode"));
	}
	static class Counter{
		int count,index;
		public Counter(int count,int index) {
			this.count=count;
			this.index=index;a
		}
	}
	public static int firstUniqChar(String s) {
		if(s==null||s.length()==0)
			return -1;
		Counter[] counterArr=new Counter[26];
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if(counterArr[c-'a']!=null)
			{
				counterArr[c-'a'].count+=1;
			}
			else{
				counterArr[c-'a']=new Counter(1, i);
			}
		}
		int firstPos=s.length();
		for (int i = 0; i < counterArr.length; i++) {
			if(counterArr[i]!=null && counterArr[i].count==1)
			{
				int newIndex=counterArr[i].index;
				if(newIndex<firstPos)
				{
					firstPos=newIndex;
				}
			}
		}
		return firstPos==s.length()?-1:firstPos;
	}
}
