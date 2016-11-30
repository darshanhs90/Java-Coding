package hackerRank.Algorithms.Implementation;

import java.util.Scanner;
/*
 * https://www.hackerrank.com/challenges/designer-pdf-viewer
 */
public class _26DesignerPDFViewer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 26;
        int h[] = new int[n];
        for(int h_i=0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int max=0;
        for (int i = 0; i < word.length(); i++) {
			max=Math.max(h[word.charAt(i)-'a'],max);
		}
        System.out.println(max*word.length());
    }
}
