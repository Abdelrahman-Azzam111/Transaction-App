public class Address {
	private String city;
	private String street;
	private String code;
	public Address(String city, String street, String code) {
		
		this.city = city;
		this.street = street;
		this.code = code;
	}

	public Address() {

	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
