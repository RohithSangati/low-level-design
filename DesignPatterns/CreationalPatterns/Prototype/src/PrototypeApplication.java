import model.Employees;

public class PrototypeApplication {

	public static void main(String[] args) {

		Employees emp1 = new Employees();
		emp1.loadAllEmployees();
		System.out.println(emp1.getAllEmployeesConcatination());
		System.out.println("================");	
		
		Employees emp2 = emp1.clone();
		System.out.println(emp2.getAllEmployeesConcatination());
		System.out.println("================");
		
		System.out.println(emp1);
		System.out.println(emp2);

	}

}
