public abstract class Person {
	private String name;

	private int age;
	private String phone_number;
	private String national_id;
	private Address Address;
	private Gender Gender;
	
	
	public Person(String name, int age, String phone_number, String national_id,
			Address address, Gender gender) {
		super();
		this.name = name;

		this.age = age;
		this.phone_number = phone_number;
		this.national_id = national_id;
		Address = address;
		Gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getNational_id() {
		return national_id;
	}
	public void setNational_id(String national_id) {
		this.national_id = national_id;
	}
	public Address getAddress() {
		return Address;
	}
	public void setAddress(Address address) {
		Address = address;
	}
	
	public Gender getGender() {
		return Gender;
	}
	public void setGender(Gender gender) {
		Gender = gender;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + " , age=" + age + ", phone_number=" + phone_number
				+ ", national_id=" + national_id + ", Address=" + Address + ", Gender=" + Gender + "]";
	}
	
	
	
	


}
