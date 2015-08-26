package ctci;

import java.util.Stack;


/*Implementation of String Buffer Data Structure*/
public class _04stringBuffer {
	String mainString;
	public _04stringBuffer() {
		// TODO Auto-generated constructor stub
		mainString=new String();
	}
	public void append(String string){
		mainString=new String(mainString+string);
	}
	public void append(char c){
		mainString=new String(mainString+String.valueOf(c));
	}
	public void append(int i){
		mainString=new String(mainString+i);
	}
	public int length(){
		return mainString!=null?mainString.length():0;
	}
	public void delete(int startIndex,int endIndex){
		mainString=new String(mainString.substring(0,startIndex)+mainString.substring(endIndex));
	}
	public void deleteCharAt(int i){
		mainString=new String(mainString.substring(0,i)+mainString.substring(i+1));
	}
	public void setLength(int newLength){
		if(newLength<mainString.length())
			mainString=new String(mainString.substring(0,newLength));
		else
			mainString=new String(mainString+"\u0000");
	}
	public void reverse(){
		Stack<Character> reverser=new Stack<Character>();
		for (int i = 0; i < mainString.length(); i++) {
			reverser.push(mainString.charAt(i));
		}
		int length=mainString.length();
		mainString=new String();
		for (int i = 0; i < length; i++) {
			mainString+=reverser.pop();
		}
	}
	public String toString(){
		return mainString;
	}

}
