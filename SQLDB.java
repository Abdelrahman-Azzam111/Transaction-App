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


