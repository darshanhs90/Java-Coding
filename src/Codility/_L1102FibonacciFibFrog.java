package Codility;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/fib_frog
 * To be checked later
 */

public class _L1102FibonacciFibFrog {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3,1,2,3,6}));
	}
	public static int solution(int[] A){
		int N=A.length;
		 if (N <= 2){
		        return 1;
		    }
		    
		    //each reached[i] cell remembers the minimum jumps made to reach there so far.
		    int reached[] = new int[N];
		    
		    //these two cells can be reached when there are leaves there.
		    //since 0 and 1 can be reached by the first jump, we only care if 
		    //there is a leaf or not.
		    reached[0] = A[0]; 
		    reached[1] = A[1];
		    
		    //we now N <= 100,000. Since fib(25) == 75025, fib(26) = 121393,
		    //we only have to generate 25 fibonacci numbers.
		    int fibN_length = 26;
		    int fibN[]=new int[fibN_length];
		    
		    fibN[0] = 0;
		    fibN[1] = 1;
		    
		    int i = 2;
		    while (i < fibN_length){
		        fibN[i] = fibN[i - 1] + fibN[i - 2];
		        //if one jump is enough, we can simply return here.
		        if (fibN[i] - 1 == N){
		            return 1;
		        }
		        //we also mark the position that can be reached by the first jump.
		        if (fibN[i] - 1 < N && A[fibN[i] - 1] == 1){
		            reached[fibN[i] - 1] = 1; 
		        }
		        i++;
		    }
		    
		    //let's check each cell
		    int min = 0x7FFFFFFF;
		    for (i = 0; i < N; i++){
		        //if the cell is not reachable, we can neglect it.
		        if (reached[i] == 0){   
		            continue;
		        }
		        int min_jumps_to_here = reached[i];
		        int j;
		        
		        for (j = 2; j < fibN_length; j++){
		            int next_pos = i + fibN[j];            
		            
		            //if we can reach the other bank (the position N),
		            // update min if necessary.
		            if (next_pos == N){
		                min = min_jumps_to_here + 1 < min ? min_jumps_to_here + 1 : min;
		                break;
		            }
		            
		            //if the next jump is too large, or there is no leaf there,
		            //we can neglect this jump.
		            if (next_pos > N || A[next_pos] == 0){
		                continue;
		            }
		                        
		            //if we have never reached to the next position before, or we can reach 
		            //the next position with less jumps, update the min number of jumps
		            // at the position.
		            if (reached[next_pos] == 0 || 
		                reached[next_pos] > min_jumps_to_here + 1){
		                reached[next_pos] = min_jumps_to_here + 1;
		            }
		        }
		    }
		    
		    return min == 0x7FFFFFFF ? -1 : min;
		}


}