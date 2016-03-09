package hackerRank.CodeWhiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Maximum and Minimum
 * Link:https://www.hackerrank.com/contests/codewhiz-java-march-2016/challenges/maximum-and-minimum
 */
class Student{
	private int token;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.token = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getToken() {
		return token;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

public class _07ServeTheStudents {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalEvents = Integer.parseInt(scanner.nextLine());
		ArrayList<Student> studList=new ArrayList<>();
		for (int i = 0; i < totalEvents; i++) {
			String input=scanner.nextLine();
			if(!input.contains("SERVED"))
			{
				String inputArray[]=input.split(" ");
				String name=inputArray[1];
				double cgpa=Double.parseDouble(inputArray[2]);
				int token=Integer.parseInt(inputArray[3]);
				Student student=new Student(token,name,cgpa);
				studList.add(student);
			}
			else{
				if(studList.size()>0){
					Collections.sort(studList,new StudentComparator());
					studList.remove(0);
				}
			}
		}
		if(studList.isEmpty())
			System.out.println("EMPTY");
		for (int i = 0; i < studList.size(); i++) {
			System.out.println(studList.get(i).getFname());
		}
	}

}
class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getCgpa()>o2.getCgpa())
			return -1;
		else if(o1.getCgpa()<o2.getCgpa())
			return 1;
		else {
			if(!o1.getFname().contentEquals(o2.getFname()))
			{
				return o1.getFname().compareTo(o2.getFname())>0?1:-1;
			}
			else{
				return o1.getToken()>o2.getToken()?1:-1;
			}
		}
	}
}
