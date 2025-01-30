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
