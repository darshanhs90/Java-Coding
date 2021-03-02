package FacebookPrep;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _0772BasicCalculatorIII {

	public static void main(String[] args) {
		System.out.println(calculate("1+1"));
		System.out.println(calculate("6-4/2"));
		System.out.println(calculate("2*(5+5*2)/3+(6/2+8)"));
		System.out.println(calculate("(2+6*3+5-(3*14/7+2)*5)+3"));
		System.out.println(calculate("0"));
	}

	public static int calculate(String s) {
		Queue<Character> q = new LinkedList<Character>();
		char[] cArr = s.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			if (cArr[i] != ' ')
				q.offer(cArr[i]);
		}
		Stack<Integer> stack = new Stack<Integer>();
		return calculate(q, stack);
	}

	public static int calculate(Queue<Character> q, Stack<Integer> stack) {
		int num = 0;
		int sign = +1;
		Character prevOperand = null;
		Stack<Integer> tempStack = new Stack<Integer>();
		while (!q.isEmpty()) {
			Character c = q.poll();
			if (Character.isDigit(c)) {
				String str = c + "";
				while (!q.isEmpty() && Character.isDigit(q.peek())) {
					str += q.poll();
				}
				if (prevOperand == null) {
					tempStack.push(sign * Integer.parseInt(str));
				} else {
					if (prevOperand == '*') {
						tempStack.push(tempStack.pop() * Integer.parseInt(str));
					} else {
						tempStack.push(tempStack.pop() / Integer.parseInt(str));
					}
				}
				prevOperand = null;
			} else if (c == '+') {
				sign = +1;
			} else if (c == '-') {
				sign = -1;
			}
			else if(c=='(')
			{
				num = calculate(q,tempStack);
				if (prevOperand == null) {
					tempStack.push(sign * num);
				} else {
					if (prevOperand == '*') {
						tempStack.push(tempStack.pop() * num);
					} else {
						tempStack.push(tempStack.pop() / num);
					}
				}
				prevOperand = null;
			}
			else if(c ==')')
			{
				break;
			}
			else if( c=='*' || c== '/')
			{
				prevOperand = c;
			}
		}
		
		int val = 0;
		while(!tempStack.isEmpty())
		{
			val+=tempStack.pop();
		}
		stack.push(val);
		return val;
	}

}
