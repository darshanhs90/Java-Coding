package LeetCodePerformancePractice;

public class _006ZigZagConversion {

	public static void main(String[] args) {
		/*		System.out.println(convert("PAYPALISHIRING",3));
		System.out.println(convert("ABCD",2));
		System.out.println(convert("AB",1));
		System.out.println(convert("AB",2));
		System.out.println(convert("ABC",1));*/
		System.out.println(convert("oxjpkcpdekyazevyzxudsirvddoxmptaodryfhdltcmuijsigolaxevcimbwduwrzqrhxvssxgmhpgpxvdyujvwrhzpktmdvcvcbquvpbhwsposktsecncwxbljxznsdiugaqbprknmabekwwrzltxixiuwihonrkutaviuixgibkuxinythvcgewcofsbycxrctbydyelzqhzyvxsetwkzuonbgqziosmjvnmtrzvkiuidrcjkavlwjaxrrybhsqsndghwhegpyrvrvgcwcpsnqsfjqgqjykwbqfyzjeojxlbtsfpwujjkbqtuzldxxbznjxmuddedqhwioneiwqvygqufezdbacrlbfggkmjbvfjjsqtrgormhlulkxombfyengkxuwypdkyyarpiiiwptqcdnsrqypunxfkrdlggvggxaxhifdzyuddjvvcvkwikdvbggkpbqvyqvfaakzzgecsazuxmqgwwbxchhtkarkqmrrmbsnixsczrwwdoebkfzpoikyibkbpbuedmrnllpkfnjkbnmovnfjxpkitwjiydmdrgqdthpywyjzmvnhksshkepdbylbdaexiwabfrabqlaegqnskhzumpzpplqvnwsvsuwxlyabjchruujhclbqcbhtozobviypcwmoxoriqbanvluzyxpaawwovkrsvrhxotnnjhvcivpfjjfjgwkhtgxqsrjpiqnymclvlhxveobpxgzgclnxtmqndzdmrsmduybifadlpebomaurljoewerzfwnxoacjydrfeuqvbtjnteegnvmjbgljcygraicamvfspynsrwgnamvqjiblomuqlcjnkloygvsytfqneycglxwwfyhtkdmxhvlujbspwlnqsefwchdpezmmzvfkbtjirwcaxxpukfmcltznaefgdtsdqaprvacmxemubeoljcquvpjxvqeajwfcyutuvvgscv",
				918));

	}
	public static String convert(String s, int numRows) {
		if(numRows==1)
			return s;
		char c[][]=new char[numRows][s.length()];
		int row=0,col=0;
		boolean down=true;
		for (int i = 0; i < s.length(); i++) {
			if(down)
			{
				c[row][col]=s.charAt(i);
				row++;
				if(row>=numRows){
					row--;
					if(row>0)
						row--;
					col++;
					down=!down;
				}
			}
			else{
				c[row][col]=s.charAt(i);
				row--;
				col++;
				if(row<0)
				{
					row++;
					if(row<numRows)
						row++;
					col--;
					down=!down;
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				if((c[i][j]+"").trim().length()>0)
					sb.append(c[i][j]);
			}
		}
		return sb.toString();
	}
}
