package hackerRank.HourRank10;

import java.util.Scanner;

public class _01JumpingontheCloudsRevisited {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int c[] = new int[n];
		for(int c_i=0; c_i < n; c_i++){
			c[c_i] = in.nextInt();
		}
		int index=(0+k)%n;
		int E=100;
		boolean changed=false;
		while(index!=0 && E>0)
		{
			changed=true;
			if(c[index]==0)
			{
				E=E-1;
			}
			else{
				E=E-3;
			}
			index=(index+k)%n;
		}
		if(changed && c[0]==0)
			System.out.println(E-1);
		else
			System.out.println(E-3);

	}
}

