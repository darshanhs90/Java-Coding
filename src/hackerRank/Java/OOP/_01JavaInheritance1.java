package hackerRank.Java.OOP;

/*
 * Link:https://www.hackerrank.com/challenges/java-inheritance-1
 */

public class _01JavaInheritance1 {

	static class Animal{
		void walk()
		{
			System.out.println("I am walking");
		}
	}

	static class Bird extends Animal
	{
		void fly()
		{
			System.out.println("I am flying");
		}
		void sing()
		{
			System.out.println("I am singing");
		}
	}

	public static void main(String args[])
	{

		Bird bird = new Bird();
		bird.walk();
		bird.fly();
		bird.sing();

	}


}
