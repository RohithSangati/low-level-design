package model;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {

	private List<String> employees;

	public Employees() {
		employees = new ArrayList<String>();
	}

	public Employees(List<String> employees) {
		this.employees = employees;
	}

	public String getAllEmployeesConcatination() {
		String res = "";
		for (String name : this.employees) {
			res = res + name + "\n";
		}
		return res;
	}

	public void loadAllEmployees() {
		// Make a db call
		this.employees.add("Dora Babu");
		this.employees.add("Moulika");
		this.employees.add("Rohith");
	}

	public Employees clone() {
		List<String> employeesCopy = new ArrayList<>();
		for (String employee : this.employees) {
			employeesCopy.add(employee);
		}
		return new Employees(employeesCopy);
	}

}
