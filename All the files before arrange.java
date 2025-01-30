

import java.util.List;

public class Account {
    private String id;
    private String type;
    private double balance;
    private Status status;

    private List<Transaction>transaction;
    public Account(String id, String type, double balance, Status status, String date, List<Transaction> transaction) {
        super();
        this.id = id;
        this.type = type;
        this.balance = balance;
        this.status = status;

        this.transaction = transaction;
    }
    public Boolean validAmount(double amount) {
        return balance >= amount;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }
    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }
    @Override
    public String toString() {
        return "Account [id=" + id + ", type=" + type + ", balance=" + balance + ", status=" + status
                + ", transaction=" + transaction + "]";
    }



}


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


public class Card {
	private String CCV;
	private String id;
	private String expire_date;
	private String type;
	public Card(String cCV, String id, String expire_date, String type) {
		super();
		CCV = cCV;
		this.id = id;
		this.expire_date = expire_date;
		this.type = type;
	}
	public String getCCV() {
		return CCV;
	}
	public void setCCV(String cCV) {
		CCV = cCV;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExpire_date() {
		return expire_date;
	}
	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Card [CCV=" + CCV + ", id=" + id + ", expire_date=" + expire_date + ", type=" + type + "]";
	}
	
	

}


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
public enum Gender {
	M,F;

}

///**
// * Main class to implement a banking system that manages client data, accounts, and transactions.
// * The program authenticates users, fetches their account and transaction details, and displays them.
// */
//import java.io.*;
//import java.nio.file.*;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.*;
//import java.util.Random;
//
///**
//     * Loads credentials (username and hashed password) from the client file.
//     * @param filePath The path to the client credentials file.
//     * @return A map of username to hashed password.
//     */
//    public static Map<String, String> loadCredentials(String filePath) {
//        Map<String, String> credentials = new HashMap<>();
//        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts.length >= 2) {
//                    String username = parts[0].trim();
//                    String hashedPassword = parts[1].trim();
//                    credentials.put(username, hashedPassword);
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading client credentials file: " + e.getMessage());
//            return null;
//        }
//        return credentials;
//    }
//    /**
//     * Checks if a given account ID exists in the accounts CSV file.
//     * @param accountId The account ID to check.
//     * @return True if the account ID exists, false otherwise.
//     */
//    public static boolean isAccountIdValid(int accountId) {
//        try (BufferedReader reader = Files.newBufferedReader(Paths.get(accountFilePat))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts.length > 0 && Integer.parseInt(parts[0].trim()) == accountId) {
//                    return true;
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading accounts file: " + e.getMessage());
//        } catch (NumberFormatException e) {
//            System.err.println("Invalid account ID format: " + e.getMessage());
//        }
//        return false;
//    }
//
//
//    /**
//     * Fetches client details from the client file based on the username.
//     * @param username The username of the client.
//     * @param filePath The path to the client file.
//     * @return A Client object containing the client's details.
//     */
//    public static Client fetchClientData(String username, String filePath) {
//        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts[0].equals(username)) {
//                    String id = parts[2].trim();
//                    System.out.println(id);
//                    String name = parts[0].trim();
//                    int age = Integer.parseInt(parts[3].trim());
//                    String phoneNumber = parts[5].trim();
//                    String nationalId = parts[6].trim();
//                    Gender gender = Gender.valueOf(parts[4].trim().toUpperCase());
//                    Address address = new Address(); // Placeholder for Address creation
//                    return new Client(name, age, phoneNumber, nationalId, address, gender, id, new ArrayList<>(), parts[1]);
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading client data file: " + e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * Hashes a password using SHA-256.
//     * @param password The password to hash.
//     * @return The hashed password as a hexadecimal string.
//     */
//    public static String hashPassword(String password) {
//        try {
//            MessageDigest digest = MessageDigest.getInstance("SHA-256");
//            byte[] hashBytes = digest.digest(password.getBytes());
//            StringBuilder hexString = new StringBuilder();
//            for (byte b : hashBytes) {
//                String hex = Integer.toHexString(0xff & b);
//                if (hex.length() == 1) hexString.append('0');
//                hexString.append(hex);
//            }
//            return hexString.toString();
//        } catch (NoSuchAlgorithmException e) {
//            System.err.println("Hashing algorithm not found: " + e.getMessage());
//            return null;
//        }
//    }
//
//    /**
//     * Fetches accounts for a client based on their ID.
//     * @param clientId The client ID to match.
//     * @param accountFilePath The path to the accounts file.
//     * @param transactionFilePath The path to the transactions file.
//     * @return A list of Account objects belonging to the client.
//     */
//    public static List<Account> fetchAccountsForClient(String clientId, String accountFilePath, String transactionFilePath) {
//        List<Account> accounts = new ArrayList<>();
//        System.out.println("Loading accounts from " + accountFilePath);
//        try (BufferedReader accountReader = Files.newBufferedReader(Paths.get(accountFilePath))) {
//            String line;
//            while ((line = accountReader.readLine()) != null) {
//                String[] parts = line.split(",");
//
//                if (parts[6].trim().equalsIgnoreCase(clientId.trim())) {
//                    String accountId = parts[0];
//                    System.out.println(accountId);
//                    String type = parts[2];
//                    double balance = Double.parseDouble(parts[1]);
//                    Status status = Status.valueOf(parts[3].toUpperCase());
//                    String date = parts[4];
//                    List<Transaction> transactions = fetchTransactionsForAccount(accountId, transactionFilePath);
//                    accounts.add(new Account(accountId, type, balance, status, date, transactions));
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading account data file: " + e.getMessage());
//        }
//        return accounts;
//    }
//
//    /**
//     * Fetches transactions for a specific account.
//     * @param accountId The account ID to match.
//     * @param transactionFilePath The path to the transactions file.
//     * @return A list of Transaction objects linked to the account.
//     */
//    public static List<Transaction> fetchTransactionsForAccount(String accountId, String transactionFilePath) {
//        List<Transaction> transactions = new ArrayList<>();
//        try (BufferedReader transactionReader = Files.newBufferedReader(Paths.get(transactionFilePath))) {
//            String line;
//            while ((line = transactionReader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts[4].equals(accountId)) {
//                    String transactionId = parts[0];
//                    double balance = Double.parseDouble(parts[1]);
//                    String description = parts[3];
//                    transactions.add(new Transaction(transactionId, balance, description));
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading transaction data file: " + e.getMessage());
//        }
//        return transactions;
//    }
//}
//
//


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Mainprog {
    // File paths for client, account, and transaction data
    static String clientFilePat = "C:\\Collge related\\Bank\\Clint data.csv";  // Path to the client credentials file
    static String accountFilePat = "C:\\Collge related\\Bank\\Account.csv"; // Path to the accounts CSV file
    static String transactionFilePat = "C:\\Collge related\\Bank\\Transactions.csv"; // Path to the transactions CSV file

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SQLDB.Connect();
        Client loggedInClient = null;

        while (true) {
            System.out.print("1: Login as Employee\n2: Client\n3:Exit\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline


            switch (choice) {
                case 1:
                    Person loggedInEmployee ;
                     while (true) {
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();

                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();

                        String hashedPassword = password;

//            String hashedPassword = hashPassword(password);
                        if (hashedPassword == null) {
                            System.out.println("Error hashing password. Try again.");
                            continue;
                        }

                        // Verify username and hashed password using SQLDB
                        if (SQLDB.verifyEmployeeCredentials(username, hashedPassword)) {
                            System.out.println("Login successful!");
                            loggedInEmployee = SQLDB.getEmployeeData(username);
                            break;
                        } else {
                            System.out.println("Invalid credentials. Try again.");
                        }
                    }

                    if (loggedInEmployee == null) {
                        System.out.println("Error retrieving client details. Exiting.");
                        return;
                    }
                    if((loggedInEmployee instanceof Manager))
                    {
                    while (true) {
                        System.out.print("1:write employee in file\n" +

                                "2 Exit\n ");
                        boolean flag = false;


                    }
                    }else if((loggedInEmployee instanceof Employee))
                    {

                    }
                    break;

                case 2:

                    // Login process to authenticate the user
                    while (true) {
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();

                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();

                        String hashedPassword = password;

//            String hashedPassword = hashPassword(password);
                        if (hashedPassword == null) {
                            System.out.println("Error hashing password. Try again.");
                            continue;
                        }

                        // Verify username and hashed password using SQLDB
                        if (SQLDB.verifyClientCredentials(username, hashedPassword)) {
                            System.out.println("Login successful!");
                            loggedInClient = SQLDB.fetchClientData(username);
                            break;
                        } else {
                            System.out.println("Invalid credentials. Try again.");
                        }
                    }

                    if (loggedInClient == null) {
                        System.out.println("Error retrieving client details. Exiting.");
                        return;
                    }

                    // Fetch accounts and link them to the logged-in client
                    List<Account> accounts = SQLDB.fetchAccountsForClient(loggedInClient.getId());
                    loggedInClient.setAccount(accounts);

                    // Display client and account details
//        System.out.println("Welcome, " + loggedInClient.getName() + "!");
                    System.out.println( loggedInClient.DisplayAccounts());

                    // Load credentials from the client file
//
                    // Display logged-in client's details
                    System.out.println("Welcome, " + loggedInClient.getName() + "!");

                    while (true) {
                        System.out.print("1:Tranfer\n" +
                                "2 withdrawl using OTP\n" +
                                "3 diplay your accounts\n" +
                                "4 Exit\n ");
                        boolean flag = false;
                        int option = scanner.nextInt();
                        int index;
                        double Amount;
                        int reciver_id;
                        switch (option) {
                            //transaction Case
                            case 1:


                                do {
                                    System.out.println("choose account to make Transfer from ");
                                    loggedInClient.DisplayAccounts();
                                    index = scanner.nextInt();


                                }
                                while (index > 0 && index > loggedInClient.getAccount().size() - 1);
                                String accoutnid=loggedInClient.getAccount().get(index).getId();

                                do {
                                    System.out.println("Enter valid  Amount ");

                                    Amount = scanner.nextDouble();
                                }
                                while (!loggedInClient.getAccount().get(index).validAmount(Amount));

                                do {
                                    System.out.println("Enter   Reciver ID");
                                    reciver_id = scanner.nextInt();
                                }while (!SQLDB.DoesAccountExist(reciver_id));
                                int sender_id=accoutnid.charAt(0)-'0';
                                int id =accoutnid.charAt(0)-'0';
                                if( SQLDB.MakeTransaction(sender_id,Amount,"Transfer",reciver_id))
                                {
                                    loggedInClient.getAccount().get(sender_id).getTransaction().add(new Transaction(id,"transfer",Amount,"Transfer to account "+reciver_id));
                                }


                                break;
                            //WithDraw case
                            // Case 2: Withdrawal using OTP
                            case 2:
                                index = -1;
                                Amount = -1.0;

                                do {
                                    System.out.println("Choose account to make Withdrawal from: ");
                                    loggedInClient.DisplayAccounts();
                                    index = scanner.nextInt();
                                } while (index < 0 || index >= loggedInClient.getAccount().size());

                                do {
                                    System.out.println("Enter valid Amount: ");
                                    Amount = scanner.nextDouble();
                                } while (!loggedInClient.getAccount().get(index).validAmount(Amount));

                                String withdrawalAccountId = loggedInClient.getAccount().get(index).getId();
                                int withdrawalAccountNumericId = Integer.parseInt(withdrawalAccountId);

                                if (SQLDB.MakeTransaction(withdrawalAccountNumericId, Amount, "Withdrawal",withdrawalAccountNumericId )) {
                                    System.out.println("The Withdrawal OTP is: " + generateRandomSixDigits() + " (valid for 15 minutes)");
                                    loggedInClient.getAccount().get(index).getTransaction()
                                            .add(new Transaction(withdrawalAccountId.charAt(0)-'0',"Withdrawal", Amount, "Withdrawal"));
                                }
                                break;

                            // display Your Account
                            case 3:
                                System.out.println("Your accounts have been written to account_details.txt");
                                try (FileWriter writer = new FileWriter("account_details.txt")) {
                                    // Redirect DisplayAccounts output to a file
                                    writer.write("Your accounts:\n");
                                    writer.write(loggedInClient.DisplayAccounts() + "\n");

                                    System.out.println("Accounts successfully written to file.");
                                } catch (IOException e) {
                                    System.err.println("Error writing accounts to file: " + e.getMessage());
                                }
                                break;
                            case 4:
                                flag=true;
                        }
                        if (flag==true )
                        {
                            break;
                        }
                    }

                case 3:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }



//        scanner.close();
    }
    /**
     * Modifies the balances in the account CSV file by subtracting from the sender
     * and adding to the receiver. Also appends a new transaction to the transaction CSV file.
     *
     * @param senderAccountId The account ID of the sender.
     * @param receiverAccountId The account ID of the receiver.
     * @param amount The amount to transfer.
     * @param accountFilePath The path to the accounts CSV file.
     * @param transactionFilePath The path to the transactions CSV file.
     * @return True if the operation was successful, false otherwise.
     */
    public static boolean processTransaction(String senderAccountId, String receiverAccountId, double amount, String accountFilePath, String transactionFilePath) {
        List<String> fileContent = new ArrayList<>();
        boolean senderUpdated = false, receiverUpdated = false;

        // Step 1: Modify account balances in the account CSV file
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(accountFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 7) { // Ensure the line has enough columns
                    fileContent.add(line);
                    continue;
                }

                String accountId = parts[0].trim();
                double balance = Double.parseDouble(parts[1].trim());

                if (accountId.equals(senderAccountId)) {
                    if (balance < amount) {
                        System.err.println("Insufficient balance in the sender's account.");
                        return false;
                    }
                    parts[1] = String.valueOf(balance - amount);
                    senderUpdated = true;
                } else if (accountId.equals(receiverAccountId)) {
                    parts[1] = String.valueOf(balance + amount);
                    receiverUpdated = true;
                }

                fileContent.add(String.join(",", parts));
            }

            if (!senderUpdated || !receiverUpdated) {
                System.err.println("One or both account IDs not found.");
                return false;
            }
        } catch (IOException e) {
            System.err.println("Error reading account file: " + e.getMessage());
            return false;
        }

        // Write the updated account data back to the CSV file
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(accountFilePath))) {
            for (String line : fileContent) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to account file: " + e.getMessage());
            return false;
        }

        // Step 2: Append a new transaction to the transaction CSV file
        try (BufferedWriter transactionWriter = Files.newBufferedWriter(Paths.get(transactionFilePath), StandardOpenOption.APPEND)) {
            String senderTransaction = String.format("%s,%.2f,%s,%s,%s",
                    UUID.randomUUID().toString(), -amount, "Transfer to account " + receiverAccountId, "DEBIT", senderAccountId);
            String receiverTransaction = String.format("%s,%.2f,%s,%s,%s",
                    UUID.randomUUID().toString(), amount, "Transfer from account " + senderAccountId, "CREDIT", receiverAccountId);

            transactionWriter.write(senderTransaction);
            transactionWriter.newLine();
            transactionWriter.write(receiverTransaction);
            transactionWriter.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to transaction file: " + e.getMessage());
            return false;
        }

        return true;
    }

    private static int generateRandomSixDigits() {
        Random random = new Random();
        return 100000 + random.nextInt(900000); // Ensures 6 digits
    }

    public void TransferMoney(int sender, int receiver, int amount) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(accountFilePat))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && Integer.parseInt(parts[0].trim()) == sender) {


                }
            }
        } catch (IOException e) {
            System.err.println("Error reading accounts file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid account ID format: " + e.getMessage());
        }

    }
    /**
     * Loads credentials (username and hashed password) from the client file.
     * @param filePath The path to the client credentials file.
     * @return A map of username to hashed password.
     */
    public static Map<String, String> loadCredentials(String filePath) {
        Map<String, String> credentials = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String username = parts[0].trim();
                    String hashedPassword = parts[1].trim();
                    credentials.put(username, hashedPassword);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading client credentials file: " + e.getMessage());
            return null;
        }
        return credentials;
    }
    /**
     * Checks if a given account ID exists in the accounts CSV file.
     * @param accountId The account ID to check.
     * @return True if the account ID exists, false otherwise.
     */
    public static boolean isAccountIdValid(int accountId) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(accountFilePat))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && Integer.parseInt(parts[0].trim()) == accountId) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading accounts file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid account ID format: " + e.getMessage());
        }
        return false;
    }


    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Hashing algorithm not found: " + e.getMessage());
            return null;
        }
    }
    /**
     * Fetches client details from the client file based on the username.
     * @param username The username of the client.
     * @param filePath The path to the client file.
     * @return A Client object containing the client's details.
     */
//    public static Client fetchClientData(String username, String filePath) {
//        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts[0].equals(username)) {
//                    String id = parts[2].trim();
//                    System.out.println(id);
//                    String name = parts[0].trim();
//                    int age = Integer.parseInt(parts[3].trim());
//                    String phoneNumber = parts[5].trim();
//                    String nationalId = parts[6].trim();
//                    Gender gender = Gender.valueOf(parts[4].trim().toUpperCase());
//                    Address address = new Address(); // Placeholder for Address creation
//                    return new Client(name, age, phoneNumber, nationalId, address, gender, id, new ArrayList<>(), parts[1]);
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading client data file: " + e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * Hashes a password using SHA-256.
//     * @param password The password to hash.
//     * @return The hashed password as a hexadecimal string.
//     */
//
//    /**
//     * Fetches accounts for a client based on their ID.
//     * @param clientId The client ID to match.
//     * @param accountFilePath The path to the accounts file.
//     * @param transactionFilePath The path to the transactions file.
//     * @return A list of Account objects belonging to the client.
//     */
//    public static List<Account> fetchAccountsForClient(String clientId, String accountFilePath, String transactionFilePath) {
//        List<Account> accounts = new ArrayList<>();
//        System.out.println("Loading accounts from " + accountFilePath);
//        try (BufferedReader accountReader = Files.newBufferedReader(Paths.get(accountFilePath))) {
//            String line;
//            while ((line = accountReader.readLine()) != null) {
//                String[] parts = line.split(",");
//
//                if (parts[6].trim().equalsIgnoreCase(clientId.trim())) {
//                    String accountId = parts[0];
//                    System.out.println(accountId);
//                    String type = parts[2];
//                    double balance = Double.parseDouble(parts[1]);
//                    Status status = Status.valueOf(parts[3].toUpperCase());
//                    String date = parts[4];
//                    List<Transaction> transactions = fetchTransactionsForAccount(accountId, transactionFilePath);
//                    accounts.add(new Account(accountId, type, balance, status, date, transactions));
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading account data file: " + e.getMessage());
//        }
//        return accounts;
//    }
//
//    /**
//     * Fetches transactions for a specific account.
//     * @param accountId The account ID to match.
//     * @param transactionFilePath The path to the transactions file.
//     * @return A list of Transaction objects linked to the account.
//     */
//    public static List<Transaction> fetchTransactionsForAccount(String accountId, String transactionFilePath) {
//        List<Transaction> transactions = new ArrayList<>();
//        try (BufferedReader transactionReader = Files.newBufferedReader(Paths.get(transactionFilePath))) {
//            String line;
//            while ((line = transactionReader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts[4].equals(accountId)) {
//                    String transactionId = parts[0];
//                    double balance = Double.parseDouble(parts[1]);
//                    String description = parts[3];
//                    transactions.add(new Transaction(transactionId, balance, description));
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading transaction data file: " + e.getMessage());
//        }
//        return transactions;
//    }
}


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


import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class SQLDB   {
    static Connection conn;

    // Method to connect to the sql server
    public static void Connect() {
        // Connection URL for MySQL
        String url = "jdbc:mysql://127.0.0.1:3306/bank";

        try {
            conn = DriverManager.getConnection(url, "root", "1234");
//            System.out.println("Connected to MySQL database successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean MakeTransaction(int SourceAccount, double Amount, String Type, Integer DestinationAccount) {
        try {
            CallableStatement statement = conn.prepareCall("{CALL PerformTransaction(?, ?, ?, ?)}");
            statement.setInt(1, SourceAccount);
            statement.setDouble(3, Amount);
            statement.setString(2, Type);
            statement.setInt(4, DestinationAccount);
            statement.execute();
            System.out.println("Transaction Had been made Successfully");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean DoesAccountExist(int accountID) {
        // Query to check if the account exists
        String query = "SELECT 1 FROM Account WHERE Account_ID = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            // Set the account ID parameter
            pstmt.setInt(1, accountID);

            // Execute the query
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Return true if a row exists
            }
        } catch (SQLException e) {
            System.err.println("Error verifying account existence: " + e.getMessage());
            e.printStackTrace();
        }

        // Return false if an exception occurs
        return false;
    }
    public static Person getEmployeeData(String username) {
        String employeeQuery = "SELECT * FROM Employee WHERE username = ?";
        String managerQuery = "SELECT Manager_SSN FROM Branch_Department WHERE Manager_SSN = ?";
        String employeesUnderManagerQuery = "SELECT * FROM Employee WHERE SSN IN (SELECT employee_id FROM Employee_Branch WHERE branch_id = (SELECT Branch_ID FROM Branch_Department WHERE Manager_SSN = ?))";

        try (PreparedStatement employeeStmt = conn.prepareStatement(employeeQuery)) {
            employeeStmt.setString(1, username);

            try (ResultSet rs = employeeStmt.executeQuery()) {
                if (rs.next()) {
                    // Retrieve employee fields
                    String id = rs.getString("SSN");
                    String fName = rs.getString("FName");
                    String lName = rs.getString("LName");
                    String email = rs.getString("Email");
                    double salary = rs.getDouble("Salary");
                    String position = rs.getString("Position");
                    LocalDate birthDate = rs.getDate("BDate").toLocalDate();
                    Gender gender = Gender.valueOf(rs.getString("Gender"));
                    String phoneNumber = "N/A"; // Placeholder
                    String nationalId = "N/A"; // Placeholder
                    Address address = new Address(); // Replace with actual address logic if available

                    // Combine first and last names
                    String name = fName + " " + lName;

                    // Calculate age based on birthDate
                    int age = Period.between(birthDate, LocalDate.now()).getYears();

                    // Check if the employee is a manager
                    try (PreparedStatement managerStmt = conn.prepareStatement(managerQuery)) {
                        managerStmt.setString(1, id);
                        try (ResultSet managerRs = managerStmt.executeQuery()) {
                            if (managerRs.next()) {
                                // Fetch employees reporting to the manager
                                List<Employee> employees = new ArrayList<>();
                                try (PreparedStatement empUnderManagerStmt = conn.prepareStatement(employeesUnderManagerQuery)) {
                                    empUnderManagerStmt.setString(1, id);
                                    try (ResultSet empRs = empUnderManagerStmt.executeQuery()) {
                                        while (empRs.next()) {
                                            String empId = empRs.getString("SSN");
                                            String empFName = empRs.getString("FName");
                                            String empLName = empRs.getString("LName");
                                            String empEmail = empRs.getString("Email");
                                            double empSalary = empRs.getDouble("Salary");
                                            String empPosition = empRs.getString("Position");
                                            LocalDate empBirthDate = empRs.getDate("BDate").toLocalDate();
                                            Gender empGender = Gender.valueOf(empRs.getString("Gender"));

                                            // Combine first and last names
                                            String empName = empFName + " " + empLName;
                                            int empAge = Period.between(empBirthDate, LocalDate.now()).getYears();

                                            employees.add(new Employee(empName, empAge, "N/A", "N/A", new Address(), empGender, empId, empSalary));
                                        }
                                    }
                                }

                                // Return the Manager object
                                return new Manager(name, age, phoneNumber, nationalId, address, gender, employees);
                            }
                        }
                    }

                    // If not a manager, return a regular Employee object
                    return new Employee(name, age, phoneNumber, nationalId, address, gender, id, salary);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if the employee data is not found
    }


    public static boolean verifyEmployeeCredentials(String username, String hashedPassword) {
        String query = "SELECT 1 FROM Employee WHERE username = ? AND password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Returns true if credentials are valid
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Returns false if an exception occurs
        }
    }

    // Verify credentials (username and hashed password)
        public static boolean verifyClientCredentials(String username, String hashedPassword) {
            String query = "SELECT 1 FROM Client WHERE username = ? AND password = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, username);
                pstmt.setString(2, hashedPassword);
                try (ResultSet rs = pstmt.executeQuery()) {
                    return rs.next();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

    // Fetch client data by username
    public static Client fetchClientData(String username) {
        String query = "SELECT * FROM Client WHERE username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Client(
                            rs.getString("C_ID"),
                            rs.getString("FName"),
                            rs.getString("LName"),
                            rs.getString("Gender"),
                            rs.getDate("BDate"), // Use java.sql.Date here, as your constructor expects Date
                            rs.getString("Email"),
                            rs.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Fetch accounts for a client by client ID
    public static List<Account> fetchAccountsForClient(String clientId) {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM Account WHERE C_ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, clientId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Account account = new Account(
                            rs.getString("Account_ID"),
                            rs.getString("Name"),
                            rs.getDouble("Balance"),
                            Status.valueOf(rs.getString("Status").toUpperCase()),
                            rs.getString("Type"),
                            new ArrayList<>() // Transactions will be fetched later
                    );
                    // Fetch transactions for this account
                    account.setTransaction(fetchTransactionsForAccount(account.getId()));
                    accounts.add(account);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    // Fetch transactions for an account by account ID
    public static List<Transaction> fetchTransactionsForAccount(String accountId) {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM Transactions WHERE Account_ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, accountId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    transactions.add(new Transaction(
                            rs.getInt("T_ID"),
                            rs.getString("Type"),
                            rs.getDouble("Amount"),
                            rs.getString("description")
                    ));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}


public enum Status {
	ACTIVE , INACTIVE;


}

//import java.io.*;
//import java.nio.file.*;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.*;
//public class Test {
//         public static String hashPassword(String password) {
//            try {
//                MessageDigest digest = MessageDigest.getInstance("SHA-256");
//                byte[] hashBytes = digest.digest(password.getBytes());
//                StringBuilder hexString = new StringBuilder();
//                for (byte b : hashBytes) {
//                    String hex = Integer.toHexString(0xff & b);
//                    if (hex.length() == 1) hexString.append('0');
//                    hexString.append(hex);
//                }
//                return hexString.toString();
//            } catch (NoSuchAlgorithmException e) {
//                System.err.println("Hashing algorithm not found: " + e.getMessage());
//                return null;
//            }
//        }
//    private static Map<String, String> loadCredentials(String filePath) {
//        Map<String, String> credentials = new HashMap<>();
//
//        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts.length == 2) {
//                    String username = parts[0].trim();
//                    String hashedPassword = parts[1].trim();
//                    credentials.put(username, hashedPassword);
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading CSV file: " + e.getMessage());
//            return null;
//        }
//
//        return credentials;
//    }
//    private static void addNewUser(String filePath, String username, String password) {
//        String hashedPassword = hashPassword(password);
//
//
//        if (hashedPassword == null) {
//            System.err.println("Error hashing the password. User not added.");
//            return;
//        }
//
//        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)) {
//            writer.write(username + "," + hashedPassword);
//            writer.newLine();
//            System.out.println("User added successfully.");
//        } catch (IOException e) {
//            System.err.println("Error writing to CSV file: " + e.getMessage());
//        }
//    }
//    public static void main(String[] args) {
//
//      Scanner scanner = new Scanner(System.in);
//
//        String csvFilePath;
//       csvFilePath = "C:\\Collge related\\Bank\\Clint data.csv" ;
//    //    csvFilePath="C:\\Users\\Mahmoud\\OneDrive\\Desktop\\Clint data.csv";
//        Map<String, String> credentials = loadCredentials(csvFilePath);
//
//        if (credentials == null) {
//            System.out.println("Error loading credentials. Exiting.");
//            return;
//        }
//
//        while (true) {
//            System.out.print("Enter username: ");
//            String username = scanner.nextLine();
//
//            System.out.print("Enter password: ");
//            String password = scanner.nextLine();
//
//            String hashedPassword = hashPassword(password);
//
//            if (hashedPassword == null) {
//                System.out.println("Error hashing password. Try again.");
//                continue;
//            }
//
//            // Check credentials
//            System.out.println(credentials.get(username));
//            if (credentials.containsKey(username) && credentials.get(username).equals(hashedPassword.trim())) {
//                System.out.println("Login successful!");
//                //TODO:Create client object
//
//                break;
//            }
//            else {
//                System.out.println("Wrong password!");
//
//
//            }
//
//        }
//
//        scanner.close();
//    }
//}



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
