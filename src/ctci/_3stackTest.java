package ctci;


/*Implementation of Stack Data Structure*/
public class _3stackTest {
	public static void main(String[] args) {
		_3stack stack=new _3stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.pop();
		System.out.println(stack.size());
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.isEmpty());
		stack.pop();
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack.toString());
	}
}
