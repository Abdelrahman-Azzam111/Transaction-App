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


