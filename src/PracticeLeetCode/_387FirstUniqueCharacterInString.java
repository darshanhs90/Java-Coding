package PracticeLeetCode;

public class _387FirstUniqueCharacterInString {
	public static void main(String[] args) {
		System.out.println(firstUniqChar("itwqbtcdprfsuprkrjkausiterybzncbmdvkgljxuekizvaivszowqtmrttiihervpncztuoljftlxybpgwnjb"));
	}

	static class WordNode{
		int count;
		int index;
		public WordNode(int count,int index) {
			this.count=count;
			this.index=index;
		}
	}

	public static int firstUniqChar(String s) {
		if(s==null||s.length()<1)
			return -1;
		WordNode[] wordArr=new WordNode[26];
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if(wordArr[c-'a']==null)
			{
				wordArr[c-'a']=new WordNode(1, i);
			}
			else{
				wordArr[c-'a'].count++;				
			}
		}
		int pos=s.length();
		for (int i = 0; i < wordArr.length; i++) {
			if(wordArr[i]!=null && wordArr[i].count==1)
			{
				pos=Math.min(pos, wordArr[i].index);
			}
		}
		return pos==s.length()?-1:pos;
	}

}
