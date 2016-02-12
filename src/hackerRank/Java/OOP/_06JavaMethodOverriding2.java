package hackerRank.Java.OOP;

/*
 * Link:https://www.hackerrank.com/challenges/java-method-overriding-2-super-keyword
 */

public class _06JavaMethodOverriding2 {
	public static void main(String []argh)
	{
		MotorCycle M=new MotorCycle();
	}

	static  class BiCycle
	{
		String define_me()
		{
			return "a vehicle with pedals.";
		}
	}

	static class MotorCycle extends BiCycle
	{
		String define_me()
		{
			return "a cycle with an engine.";
		}

		MotorCycle()
		{


			System.out.println("Hello I am a motorcycle, I am "+ define_me());
			String temp=super.define_me(); //~~Fix me~~
			System.out.println("My ancestor is a cycle who is "+ temp );
		}

	}

}
