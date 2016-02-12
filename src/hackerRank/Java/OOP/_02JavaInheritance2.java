package hackerRank.Java.OOP;

/*
 * Link:https://www.hackerrank.com/challenges/java-inheritance-2
 */

public class _02JavaInheritance2 {

	//Write your code here
	//Write your code here
	class Arithmetic{
	    public String getName(){
	        return this.getClass().getName();
	    }
	}
	class Adder extends Arithmetic{
	    public int add(int a,int b){
	        return a+b;
	    }
	    
	}

}
