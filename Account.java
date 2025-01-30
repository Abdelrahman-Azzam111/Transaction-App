

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
