package Jan2021Leetcode;

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
		HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
		for (Employee e : employees) {
			map.put(e.id, e);
		}
		return getImportance(id, map);
	}

	public static int getImportance(int id, HashMap<Integer, Employee> map) {
		int sum = map.get(id).importance;
		List<Integer> subordinates = map.get(id).subordinates;

		for (Integer sub : subordinates) {
			sum += getImportance(sub, map);
		}
		return sum;
	}

}
