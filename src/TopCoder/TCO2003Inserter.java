package TopCoder;

/*
 * TCO 2003
 * Link:https://community.topcoder.com/stat?c=problem_statement&pm=927&rd=4700
 */



public class TCO2003Inserter {

	public static void main(String[] args) {
		//System.out.println(insert(new String[]{"#<B># #$# 2","#comes # #before this# 1"},"$100 before this $300"));
		System.out.println(insert(new String[]{"#,# # and# 1","#,# # and# 2","#,# # and# 3"},"lions and tigers and bears"));
		/*System.out.println(insert(new String[]{"#import java.util.*; # #public class # 1"},"public class Inserter"));
		System.out.println(insert(new String[]{"# # # # 1","# # # # 2","# # # # 3","# # # # 4","# # # # 5","# # # # 6"},"add lots of spaces"));
		System.out.println(insert(new String[]{"# # # # 6","# # # # 5","# # # # 4","# # # # 3","# # # # 2","# # # # 1"},"order matters quite a bit"));
		System.out.println(insert(new String[]{"#A# #..# 2","#A# #..# 5","#A# #..# 123456789"},"...."));*/
	}

	public static String insert(String[] commands, String original){
		for (int i = 0; i < commands.length; i++) {
			System.out.println(original);
			String inputArray[]=commands[i].split("#");
			String insertableString=inputArray[1].substring(0);
			String findString=inputArray[3].substring(0);
			int position=Integer.parseInt(inputArray[4].trim());
			System.out.println("findString-"+findString);
			int counter=0;
			while(true){
				
				
				
				
				
			}
		}
		return original;
	}
}
