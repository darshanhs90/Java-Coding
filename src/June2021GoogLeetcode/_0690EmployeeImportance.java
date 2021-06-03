package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0690EmployeeImportance {
	static class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;
	};

	public static void main(String[] args) {
		Employee emp1 = new Employee();
		emp1.id = 1;
		emp1.importance = 5;
		emp1.subordinates = new ArrayList<Integer>();
		emp1.subordinates.add(2);
		emp1.subordinates.add(3);

		Employee emp2 = new Employee();
		emp2.id = 2;
		emp2.importance = 3;
		emp2.subordinates = new ArrayList<Integer>();

		Employee emp3 = new Employee();
		emp3.id = 3;
		emp3.importance = 3;
		emp3.subordinates = new ArrayList<Integer>();

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);

		System.out.println(getImportance(employees, 1));
	}

	public static int getImportance(List<Employee> employees, int id) {
		
	}

}
