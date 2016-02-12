package hackerRank.Java.OOP;

/*
 * Link:https://www.hackerrank.com/challenges/java-method-overriding
 */

public class _05JavaMethodOverriding {
	public static void main(String []args)
	{
		Sports C1=new Sports();
		Soccer C2=new Soccer();
		System.out.println(C1.get_name());
		C1.get_number_of_team_members();
		System.out.println(C2.get_name());
		C2.get_number_of_team_members();
	}
	static class Sports{

		String get_name()
		{
			return "Generic Sports";
		}
		void get_number_of_team_members()
		{
			System.out.println("Each team has n players in "+get_name());
		}
	}

	static class Soccer extends Sports
	{
		String get_name()
		{
			return "Soccer Class";
		}
		void get_number_of_team_members()
		{
			System.out.println("Each team has 11 players in "+get_name());
		}
	}

}
