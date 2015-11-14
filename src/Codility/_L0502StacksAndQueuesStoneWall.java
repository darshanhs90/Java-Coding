package Codility;

import java.util.Stack;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/stone_wall
 */

public class _L0502StacksAndQueuesStoneWall {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{8,8,5,7,9,8,7,4,8}));
	}
	 public static int solution(int[] H) {
         int len = H.length;
         Stack<Integer> stack = new Stack<>();
         int blockRectangles = 0;
         for (int i = 0; i < len; ++i) {
             int element = H[i];
             if (stack.isEmpty()) {
                 stack.push(element);
                 blockRectangles++;
             } else {
                 while (!stack.isEmpty() && stack.peek() > element) {
                     stack.pop();
                 } 
                 if (!stack.isEmpty() && stack.peek() == element) {
                    continue;
                 } else {
                     stack.push(element);
                     blockRectangles++;
                 }
             }
         }

         return blockRectangles;
     }

}