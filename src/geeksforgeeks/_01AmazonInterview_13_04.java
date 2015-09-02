package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * http://www.geeksforgeeks.org/amazon-interview-set-14-2/
 * Print all pairs(sets) of prime numbers (p,q) such that p*q <= n, where n is given number
 */;
 public class _01AmazonInterview_13_04 {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(new InputStreamReader(System.in));
		Integer N=Integer.parseInt(scanner.nextLine());
		scanner.close();
		ArrayList<Integer> primeList=printPrimes(N);
		printSets(primeList,N);
	}

	private static void printSets(ArrayList<Integer> primeList,Integer N) {
		for (int i = 0; i < primeList.size(); i++) {
			int firstElement=primeList.get(i);
			for (int j = 0; j < primeList.size(); j++) {
				int secondElement=primeList.get(j);
				if(firstElement*secondElement<N)
					System.out.print("("+firstElement+","+secondElement+")"+",");
			}
		}
		System.out.println();
	}

	private static ArrayList<Integer> printPrimes(Integer n) {
		ArrayList<Integer> primeList=findPrimes(n);
		for (int i = 0; i < primeList.size(); i++) {
			System.out.print(primeList.get(i)+",");
		}
		System.out.println();
		return primeList;
	}

	private static ArrayList<Integer> findPrimes(Integer n) {
		ArrayList<Integer> primeList=new ArrayList<Integer>();
		for (int i = 3; i <= n/3; i=i+2) {
			if(isPrime(i)){
				primeList.add(i);
			}
		}
		return primeList;
		
	}

	private static boolean isPrime(int i) {
		for (int j = 3; j < i/2; j=j+2) {
			if(i%j==0 && i!=j)
				return false;
		}
		return true;
	}

 }