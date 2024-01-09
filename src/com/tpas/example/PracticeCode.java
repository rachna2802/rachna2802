package com.tpas.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeCode {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// noofMaleAndFemaleEmployees
		getCountOfMaleFemale(employeeList);
		getDepartmentName(employeeList);
		// getGender(employeeList);
		oldestEmp(employeeList);
	}

	public static void getCountOfMaleFemale(List<Employee> employeeList) {

		Map<String, Long> mapOfGender = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		mapOfGender.entrySet().forEach(e -> System.out.print(e.getKey() + " " + e.getValue()));

	}

	// print the names of all departments in the organization.
	public static void getDepartmentName(List<Employee> employeeList) {
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

	}

	// the average age of Male and Female Employees.
	public static void getGender(List<Employee> employeeList) {
		Map<String, Double> mapOfGender = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
	}

	public static void getNameOfEmp(List<Employee> employeeList) {
		employeeList.stream().map(Employee::getName).forEach(System.out::println);

	}

	public static void countByDept(List<Employee> employeeList) {
		Map<String, Long> mapByDept = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		mapByDept.entrySet().forEach(e -> System.out.print(e.getKey() + "" + e.getValue()));

	}

	// Find out the average salary of each department.
	public static void avgSalary(List<Employee> employeeList) {
		Map<String, Double> mapAvagSal = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		mapAvagSal.entrySet().forEach(e -> System.out.print(e.getKey() + "" + e.getValue()));

	}

	// Find out the oldest employee, his/her age and department?
	public static void oldestEmp(List<Employee> employeeList) {
		List<Employee> empList = employeeList.stream().sorted(Comparator.comparing(Employee::getAge).reversed())
				.collect(Collectors.toList());
		System.out.println("old Emp::" + empList.get(0).getName() + "Age::" + empList.get(0).getAge() + "Dept::"
				+ empList.get(0).getDepartment());

	}

	// Find out the average and total salary of the organization.
	public static void getEmpSalary(List<Employee> employeeList) {
		Double empSalary = employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(empSalary);
	}

	// List down the employees of each department.
	public static void listDownDept(List<Employee> employeeList) {
		employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));

	}
	// highest experienced employees in the organization

	public static void seniorEmp(List<Employee> employeeList) {
		List<Employee> empList = employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining))
				.collect(Collectors.toList());
		System.out.println("senior Emp::" + empList.get(0).getName());
	}

}
