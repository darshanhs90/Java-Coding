package ctci;

import java.io.InputStreamReader;
import java.util.Scanner;


/*Implementation of CTCI 1.4*/
public class _6Arrays_3 {
	public static void main(String args[]){
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputString=scanner.nextLine();
		int trueLength=Integer.parseInt(scanner.nextLine());
		System.out.println(replaceString(inputString,trueLength));
	}

	public static String replaceString(String inputString, int trueLength) {
		char[] inputArray=inputString.toCharArray();
		int noOfSpaces=0;
		for(int i=0;i<inputArray.length;i++){
			if(inputArray[i]==' ')
				noOfSpaces++;
		}
		/*		if(((noOfSpaces*3)+(inputArray.length-noOfSpaces))>trueLength)
			return inputString;
		else{//convert the String
		 */			
		int index=0;
		int inputIndex=0;
		String outputString="";
		while(index<inputArray.length){
			if(inputArray[inputIndex]!=' '){
				outputString+=inputArray[inputIndex];
				index++;
			}
			else{
				outputString+="%20";
				index+=3;
			}
			inputIndex++;
		}
		return outputString;
		//}
	}

}
