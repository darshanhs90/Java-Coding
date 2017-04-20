package hackerRank.WeekOfCode31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
 * Link:https://www.hackerrank.com/contests/w31/challenges/zero-one-game
 */
public class _03ZeroOneGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		for(int a0 = 0; a0 < g; a0++){
			int n = in.nextInt();
			int[] sequence = new int[n];
			ArrayList<Integer> list=new ArrayList<>();
			for(int sequence_i=0; sequence_i < n; sequence_i++){
				sequence[sequence_i] = in.nextInt();
				list.add(sequence[sequence_i]);
			}
/*			boolean breaker=false;
			boolean turn=true;//Alice turn
			while(!breaker)
			{
				int index=-1;
				for (int i = 1; i < list.size()-1; i++) {
					if((i-1)>=0 && (i+1) <list.size())
					{
						if(list.get(i-1)==0 && list.get(i+1)==0)
						{
							index=i;
							break;
						}
					}
				}
				//System.out.println(turn==false?"Bob Turn":"Alice Turn");
				if(index==-1)
				{
					breaker=true;
				}
				else{
					list.remove(index);
					turn=!turn;
				}
				//System.out.println(Arrays.toString(list.toArray()));
			}
			System.out.println(turn==true?"Bob":"Alice");
			// If Alice wins, print 'Alice' on a new line; otherwise, print 'Bob'
*/			

/*
10
5
0 0 0 1 1
5
0 0 1 0 1
5
1 0 0 0 1
5
0 1 0 0 1
5
1 1 0 0 0
5
0 1 1 0 0
5
1 0 1 0 0
5
0 1 0 1 0
5
1 0 0 1 0
5
0 0 1 1 0*/
			
			
			
			boolean turn=true;
			int prevIndex=0,nextIndex=2;
			Stack<Integer> stack=new Stack<Integer>();
			stack.add(prevIndex);
			for (int i = 1; i < sequence.length-1; i++) {
				nextIndex=i+1;
				prevIndex=stack.peek();
				if(sequence[prevIndex]==0 && sequence[nextIndex]==0)
				{
					turn=!turn;
					//check for the prevIndex
					while(true)
					{
						if(stack.size()>1)
						{
							int prev=stack.pop();
							int prePrev=stack.peek();
							if(sequence[prePrev]==0 && sequence[nextIndex]==0){
								turn=!turn;
							}
							else{
								stack.push(prev);
								break;
							}
						}
						else{
							break;
						}
					}
				}
				else{
					stack.push(i);
				}
			}
			System.out.println(turn==true?"Bob":"Alice");



		}
	}
}

