package LeetcodeTemplate;

public class _0155MinStack {

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
	}

	static class MinStack {

		/** initialize your data structure here. */
		public MinStack() {
		}

		public void push(int x) {
		}

		public void pop() {
		}

		public int top() {
		}

		public int getMin() {
		}
	}
}
