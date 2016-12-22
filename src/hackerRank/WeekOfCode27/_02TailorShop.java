package hackerRank.WeekOfCode27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/contests/w27/challenges/tailor-shop
 */
public class _02TailorShop {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        Arrays.sort(a);
        long count=0;
        int value=a[0]/p;
        int prevCount=a[0]%p==0?value+1:value+2;
        count=prevCount-1;
        for (int i = 1; i < a.length; i++) {
        	int num=(int)Math.ceil(a[i]/(double)p);
        	if(num<=prevCount){
        		num=prevCount;
        		prevCount++;
        	}
        	else{
        		prevCount=num+1;
        	}
			count+=num;
		}
        System.out.println(count); 
    }
}

