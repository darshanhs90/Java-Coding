package hackerRank.WeekOfCode28;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w28/challenges/the-great-xor
 */
public class _02TheGreatXor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            if(x==Math.pow(2, Math.ceil(Math.log(x)/Math.log(2))))
            {
            	System.out.println(((long)Math.pow(2, Math.ceil(Math.log(x)/Math.log(2)))-1));
            }
            else{
                System.out.println(((long)Math.pow(2, Math.ceil(Math.log(x)/Math.log(2)))-x-1));
            }
        }
    }
}

