import java.util.Date;

public class Transaction {
	private String id;
	private Date date;
	private String type;
	private String source_id;
	private String target_id;
	private double amount;
	private String description;
//	public Transaction(String id,) {}
public Transaction(int id, String type, double amount, String description) {
	this.id = String.valueOf(id); // Convert int to String if necessary
	this.type = type;
	this.amount = amount;

	this.description = description;
}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public double getBalance() {
		return amount;
	}
	public void setBalance(double balance) {
		this.amount = balance;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", description=" + description
				+ "]";
	}
	
	
	

}
