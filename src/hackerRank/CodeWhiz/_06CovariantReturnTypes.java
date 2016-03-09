package hackerRank.CodeWhiz;

/*
 * Maximum and Minimum
 * Link:https://www.hackerrank.com/contests/codewhiz-java-march-2016/challenges/maximum-and-minimum
 */
public class _06CovariantReturnTypes {

	class Flower{
		String whats_Your_Name(){
			return "I have many names and types";
		}
	}
	//Write your code here

	class Jasmine extends Flower{
		String whats_Your_Name(){
			return "Jasmine";
		}
	}
	class Lily extends Flower{
		String whats_Your_Name(){
			return "Lily";
		}
	}
	class Lotus extends Flower{
		String whats_Your_Name(){
			return "Lotus";
		}
	}


	class State{
		Flower your_National_Flower(){
			return new Flower();
		}
	}
	class WestBengal extends State{
		Flower your_National_Flower(){
			return new Jasmine();
		}
	}
	class Karnataka extends State{
		Flower your_National_Flower(){
			return new Lotus();
		}
	}
	class AndhraPradesh extends State{
		Flower your_National_Flower(){
			return new Lily();
		}
	}

}
