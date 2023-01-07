package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StreamAssignment {
	public static void main(String[] args) {
		Employee emp1 = new Employee(1, "Sahil", "Developer", 8000);
		Employee emp2 = new Employee(2, "Rachit", "Developer", 12000);
		Employee emp3 = new Employee(3, "Rahul", "Developer", 15000);
		Employee emp4 = new Employee(4, "Shradha", "Developer", 8000);

		Employee emp5 = new Employee(5, "Hemant", "QA", 5000);
		Employee emp6 = new Employee(6, "Nisha", "HR", 6500);
		Employee emp7 = new Employee(7, "Nitesh", "Manager", 20000);

		Department dept1 = new Department(1, "Backend Development", 1);
		Department dept2 = new Department(2, "Full Stack Development", 2);
		Department dept3 = new Department(3, "UI Development", 3);
		Department dept4 = new Department(2, "Full Stack Development", 4);
		Department dept5 = new Department(5, "Testing", 5);
		Department dept6 = new Department(6, "HR", 6);
		Department dept7 = new Department(7, "Management", 7);

		List<Integer> departmentIds = new ArrayList<Integer>();
		departmentIds.add(1);
		departmentIds.add(2);
		departmentIds.add(3);
		departmentIds.add(4);
		departmentIds.add(5);
		departmentIds.add(6);
		departmentIds.add(7);

		Company company = new Company(1, "Excel", departmentIds);

		// List of department
		List<Department> departmentList = new ArrayList<>();
		departmentList.add(dept1);
		departmentList.add(dept2);
		departmentList.add(dept3);
		departmentList.add(dept4);
		departmentList.add(dept5);
		departmentList.add(dept6);
		departmentList.add(dept7);

		// List of employees
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		employeeList.add(emp4);
		employeeList.add(emp5);
		employeeList.add(emp6);
		employeeList.add(emp7);

		/**
		 * Exercise 1 — Obtain a list of Department belongs to Position “Developer” with
		 * salary > 10000
		 */

		/**
		 * Using streams first filtering out the developer employees with salary greater
		 * than 10k, then fetching their employee IDs and finally storing their IDs to a
		 * set.
		 */

		Set<Integer> devsWithSalaryGreaterThanTenk = employeeList.stream().filter(
				(emp) -> emp.getEmployeePosition().equalsIgnoreCase("Developer") && emp.getEmployeeSalary() > 10000)
				.map(Employee::getEmployeeId).collect(Collectors.toSet());

		/**
		 * We have Ids of Devs who earns more than 10k. Using those Ids filtering out
		 * the department having those Employee Ids and finally collecting them to a
		 * list.
		 */
		List<String> deptBelongsToDevWithSalaryGtrThanTenk = departmentList.stream()
				.filter((dept) -> devsWithSalaryGreaterThanTenk.contains(dept.getEmployeeId()))
				.map(Department::getDepartmentName).collect(Collectors.toList());

		/**
		 * Printing on console the departments belongs to position "Developer with
		 * salary > 10k.
		 */
		System.out.println(deptBelongsToDevWithSalaryGtrThanTenk);

		/**
		 * Exercise 2 — Get the cheapest Employee of “Developer” category
		 */

		/**
		 * First we filter out the employees belongs to the dev category then we use
		 * Collectors grouping by which produce a map having key as an employee salary
		 * and value as a list of all employee having that salary and as this map is of
		 * type tree map hence the entries in map will be sorted according to the salary
		 * Hence, fetching the first entry will solve our problem of fetching the
		 * cheapest employee of "Developer" Category.
		 */
		List<String> cheapestEmployeeOfDev = employeeList.stream()
				.filter((e) -> e.getEmployeePosition().equalsIgnoreCase("Developer"))
				.collect(Collectors.groupingBy(Employee::getEmployeeSalary, TreeMap::new,
						Collectors.mapping(Employee::getEmployeeName, Collectors.toList())))
				.firstEntry().getValue();

		System.out.println("Cheapest Developer employees " + cheapestEmployeeOfDev);

		/**
		 * Exercise 3 — Get the 3 most highest paid Employee
		 */

		/**
		 * Using stream first sorting the employee list in descending order of salary,
		 * then fetching the top 3 values because they are the three highest salary
		 * employee and then finally mapping the name of employees and collecting them
		 * to a list.
		 */
		List<String> threeHighestPaidEmployee = employeeList.stream()
				.sorted((e1, e2) -> e2.getEmployeeSalary() - e1.getEmployeeSalary()).limit(3)
				.map(Employee::getEmployeeName).collect(Collectors.toList());

		System.out.println("Three highest paid employees " + threeHighestPaidEmployee);

		/**
		 * Exercise 4 — Calculate total lump sum salary of Developer” category Employee.
		 */

		/**
		 * Using collectors summing int on particular property of the object to
		 * calculate that property sum. In our case that property is salary.
		 */
		int totalEmployeeSalary = employeeList.stream().collect(Collectors.summingInt(Employee::getEmployeeSalary));
		System.out.println("Total Employee Salary " + totalEmployeeSalary);

		/**
		 * Exercise 5 - Get the Department which has most No. of Employees.
		 */

		/**
		 * First grouping the departments and the count of the employees working in that
		 * in form of a map.
		 */
		Map<String, Long> departmentAndEmployees = departmentList.stream()
				.collect(Collectors.groupingBy(Department::getDepartmentName, Collectors.counting()));

		/**
		 * After the grouping the department and number of employees work in that
		 * applying max of stream on entry set of map using natural order comparator to
		 * fetch the maximum value of number of employees in each department and then
		 * finally printing the department name.
		 */
		String departmentWithHighestEmployee = departmentAndEmployees.entrySet().stream()
				.max(Map.Entry.comparingByValue()).get().getKey();
		System.out.println(departmentWithHighestEmployee);
	}

}
