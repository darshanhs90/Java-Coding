package Usaco.Chapter1;

/*
ID: hsdars2
LANG: JAVA
TASK: gift1 
LINK : http://train.usaco.org/usacoprob2?a=tHd4I0AnLp3&S=gift1
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class _03GreedyGiftGivers {
	public static void main (String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		ArrayList<String> nameList=new ArrayList<String>();
		int N=Integer.parseInt(f.readLine());
		HashMap<String,Integer> finalMoneyMap=new HashMap<String,Integer>();
		HashMap<String,Integer> initialMoneyMap=new HashMap<String,Integer>();
		for (int i = 0; i < N; i++) {
			String name=f.readLine();
			nameList.add(name);
			initialMoneyMap.put(name, 0);
			finalMoneyMap.put(name, 0);
		}
		int counter=0;
		while(counter<N)
		{	
			counter++;
			String sender=f.readLine();
			String moneySplit=f.readLine();
			int inputMoney=Integer.parseInt(moneySplit.split(" ")[0]);
			initialMoneyMap.put(sender, inputMoney);
			int noOfRecipients=Integer.parseInt(moneySplit.split(" ")[1]);
			if(noOfRecipients<=0)
				continue;
			int amountAdded=inputMoney/noOfRecipients;
			int leftOver=inputMoney-(amountAdded*noOfRecipients);
			for (int i = 0; i < noOfRecipients; i++) {
				String recipient=f.readLine();
				if(finalMoneyMap.containsKey(recipient))
				{
					finalMoneyMap.put(recipient,finalMoneyMap.get(recipient)+amountAdded);
				}
				else{
					finalMoneyMap.put(recipient,amountAdded);
				}
			}	
			if(finalMoneyMap.containsKey(sender))
			{
				finalMoneyMap.put(sender,finalMoneyMap.get(sender)+leftOver);
			}
			else{
				finalMoneyMap.put(sender,leftOver);
			}
		}
		
		for (int i = 0; i < nameList.size(); i++) {
			out.println(nameList.get(i)+" "+(finalMoneyMap.get(nameList.get(i))-initialMoneyMap.get(nameList.get(i))));
		}
		
		out.close();       
		System.exit(0);
	}
}