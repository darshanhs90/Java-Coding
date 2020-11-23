package Nov2020Leetcode;

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
		HashMap<Integer, Integer> importanceMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
			employeeMap.put(employee.id, employee);
		}

		return getImportanceRecursive(importanceMap, employeeMap, id);
	}

	public static int getImportanceRecursive(HashMap<Integer, Integer> importanceMap,
			HashMap<Integer, Employee> employeeMap, int id) {
		Employee e = employeeMap.get(id);
		if (!importanceMap.containsKey(id)) {
			int importance = e.importance;
			for (int i = 0; i < e.subordinates.size(); i++) {
				Integer subordinateId = e.subordinates.get(i);
				importance += getImportanceRecursive(importanceMap, employeeMap, subordinateId);
			}

			return importance;
		} else {
			return importanceMap.get(id);
		}
	}

}
