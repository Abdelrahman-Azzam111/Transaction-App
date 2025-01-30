import java.util.List;

public class Branch {
	private Address address;
	private List<Employee> employees;
	private List<Department>departments;
	public Branch(Address address, List<Employee> employees, List<Department> departments) {
		super();
		this.address = address;
		this.employees = employees;
		this.departments = departments;
	}
	public Branch() {}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	

}
