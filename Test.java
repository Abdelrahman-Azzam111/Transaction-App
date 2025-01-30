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
