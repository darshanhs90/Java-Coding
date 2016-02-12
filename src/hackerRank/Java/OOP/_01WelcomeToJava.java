package hackerRank.Java.OOP;

/*
 * Link:https://www.hackerrank.com/challenges/java-inheritance-1
 */

public class _01WelcomeToJava {

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
	}


	public static void main(String args[])
	{

		Bird bird = new Bird();
		bird.walk();
		bird.fly();

	}

}
