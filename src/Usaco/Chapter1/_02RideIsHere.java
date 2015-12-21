package Usaco.Chapter1;


/*
ID: hsdars2
LANG: JAVA
TASK: ride 
LINK : http://train.usaco.org/usacoprob2?a=AQQ5FacsnQI&S=ride
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class _02RideIsHere {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    String st1 = (f.readLine());
    String st2 = (f.readLine());
    int sum1=1,sum2=1;
	for (int i = 0; i <st1.length(); i++) {
		sum1*=(st1.charAt(i)-64);
	}
	for (int i = 0; i <st2.length(); i++) {
		sum2*=(st2.charAt(i)-64);
	}
	System.out.println(st1);
	System.out.println(st2);
	
	if(sum1%47==sum2%47)
	    out.println("GO");
	else
	    out.println("STAY");
    out.close();       
    System.exit(0);
  }
}