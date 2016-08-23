package hackerRank.Hack40_101;

import java.util.Scanner;

public class _01DesignerPDFViewer {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int h[] = new int[26];
		for (int i = 0; i < h.length; i++) {
			h[i]=in.nextInt();
		}
		String word=in.next();
		int maxHeight=1;
		for (int i = 0; i < word.length(); i++) {
			maxHeight=Math.max(maxHeight, h[(int)word.charAt(i)-97]);
		}
		System.out.println(maxHeight*word.length());
	}
}

