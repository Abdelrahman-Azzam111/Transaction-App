public class Employee extends Person {

    private String id;
    private double salary;

    
    public Employee(String name, int age, String phoneNumber, String nationalId,
                    Address address, Gender gender, String id, double salary) {
        super(name, age, phoneNumber, nationalId, address, gender);
        this.id = id;
        this.salary = salary;
    }

    
    public String getId() {
        return id;
    }

   
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        this.id = id;
    }

   
    public double getSalary() {
        return salary;
    }

    
    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    
    @Override
    public String toString() {
        return super.toString() + ", Employee [id=" + id + ", salary=" + salary + "]";
    }
}
