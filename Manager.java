import java.util.List;

public class Manager extends Person {
	private List<Employee> employees;

	public Manager(String name,  int age, String phone_number, String national_id,
			Address address, Gender gender, List<Employee> employees) {
		super(name, age, phone_number, national_id, address, gender);
		this.employees = employees;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
public String displayEmployees() {
	String result = "";
	int i = 1;
	for (Employee employee : employees) {
		result += i++ + ". ";
		result += employee.toString() + "\n";
	}
	return result;
}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Manager [employees=" + employees + "]";
	}
	
	
	
	

}
