package Codility;

import java.util.Stack;

/*
 * Author : Haridarshan H.S.
 * Link : https://codility.com/programmers/task/fish
 */

public class _L0504StacksAndQueuesFish {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{4,3,2,1,5},new int[]{0,1,0,0,0}));
	}
	public static int solution(int A[],int B[]) {
		Stack<StackObj> stack=new Stack<StackObj>();
		for (int i = 0; i < A.length; i++) {
			StackObj sb=new StackObj(A[i],(B[i]==0)?"up":"down");
			if(stack.isEmpty())
			{
				stack.push(sb);
			}
			else{
				StackObj peekedObj=stack.peek();
				if(peekedObj.direction.contentEquals("down"))
				{
					if(sb.direction.contentEquals("up"))
					{
						if(sb.value>peekedObj.value)
						{
							stack.pop();
							stack.push(sb);
						}
					}
					else{
						stack.push(sb);
					}
				}
				else{
					stack.push(sb);
				}
			}
		}
		return stack.size();
	}


}
class StackObj{
	int value;
	String direction;
	public StackObj(Integer value,String direction) {
		this.value=value;
		this.direction=direction;
	}
}