package hackerRank.CodingAssessments;

import java.util.Stack;

public class _02BoxAssessment {
	static void rpn_calculate(String[] tokens){
		Stack<String> stack=new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			boolean exceptionFlag=false;
			try{
				int x=Integer.parseInt(tokens[i]);
				stack.push(x+"");
			}
			catch(NumberFormatException n){
				exceptionFlag=true;
			}
			finally{
				if(exceptionFlag)
				{
					if(!stack.isEmpty()){
						int value2=Integer.parseInt(stack.pop());
						if(!stack.isEmpty()){
							int value1=Integer.parseInt(stack.pop());
							String result=handleInput(value1,value2,tokens[i]);
							if(result.contentEquals("Error"))
							{
								System.out.println("Invalid Input");
								System.exit(0);
							}
							else{
								stack.push(result);
							}
						}
						else{
							System.out.println("Invalid Input");
							System.exit(0);
						}
					}
					else{
						System.out.println("Invalid Input");
						System.exit(0);
					}
				}
			}
		}
		System.out.println(stack.peek());
	}


	private static String handleInput(int value1, int value2, String string) {
		String output;
		switch(string){
		case "+":output=value1+value2+"";
		break;
		case "-":output=value1-value2+"";
		break;
		case "*":output=value1*value2+"";
		break;
		case "/":output=value1/value2+"";
		break;
		default:output="Error";
		break;
		}
		return output;
	}


	public static void main(String[] args) {
		rpn_calculate(new String[]{"3","4","5","*","-"});
		rpn_calculate(new String[]{"10","100","-","90","+"});
	}
}
