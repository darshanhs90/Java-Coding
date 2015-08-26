package ctci;




/*Implementation of Queue Data Structure Tester*/
public class _05queueTest {
	public static void main(String[] args) {
		_05queue queue =new _05queue();
		queue.add(10);
		queue.add(20);
		queue.add(50);
		queue.add(5);
		System.out.println("Queue contains 20 ?"+queue.contains(20));
		System.out.println("Queue contains 30 ?"+queue.contains(30));
		System.out.println(queue.size());
		queue.remove();
		System.out.println(queue.toString());
		System.out.println("Peeked value is"+queue.peek());
		System.out.println(queue.toString());
		System.out.println("Polled value is"+queue.poll());
		System.out.println(queue.toString());
		
		queue.clear();
		System.out.println(queue.toString());
	}
}
