import java.util.List;

public class Department {
	private String Name;
	private List<Employee> employees;
	private Branch branch;
	private static double Working_hours;
	
	public Department(String name, List<Employee> employees, Branch branch) {
		super();
		Name = name;
		this.employees = employees;
		this.branch = branch;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public static double getWorking_hours() {
		return Working_hours;
	}

	public static void setWorking_hours(double working_hours) {
		Working_hours = working_hours;
	}

	@Override
	public String toString() {
		return "Department [Name=" + Name + ", employees=" + employees + ", branch=" + branch + "]";
	}
	
	
	

}
