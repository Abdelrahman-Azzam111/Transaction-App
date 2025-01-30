import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.time.LocalDate;


public class Client extends Person {

	private String id, hashedPassword;
	private List<Account> account;
	public Client(String id, String Fname, String Lname, String gender, Date dateOfBirth,String Email,String hashedPassword) {
		String name=Fname+" "+Lname;
		int age= 25;
		super(name,age,"0151212","1544545",new Address(), Gender.valueOf(gender));
		this.id=id;
		this.hashedPassword=hashedPassword;

	}
	public Client(String name, int age, String phoneNumber, String nationalId, Address address, Gender gender, String id, List<Account> account, String hashedPassword) {
		super(name, age, phoneNumber, nationalId, address, gender);
		this.id = id;
		this.account = account;
		this.hashedPassword = hashedPassword;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}


	public String DisplayAccounts()
	{
		String op="";
		int i=0;
		for(Account a : account)
		{
			op+=i;
			op+=' '+a.toString();
			op+='\n';
			i++;
		}
//		System.out.println( op);
	return op;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", account=" + account + "]";
	}
}
