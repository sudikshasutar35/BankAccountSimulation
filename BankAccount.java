import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String accountHolder;
    private double balance;
    private final List<String> transactionHistory;

    public BankAccount(String accountHolder, double initialBalance) {
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty.");
        }
        if (!Double.isFinite(initialBalance) || initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must be a valid non-negative amount.");
        }
        this.accountHolder = accountHolder.trim();
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add(String.format("Account opened | Balance: Rs. %.2f", initialBalance));
    }

    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }

    public boolean deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Invalid amount. Deposit must be greater than Rs. 0.");
            return false;
        }
        balance += amount;
        transactionHistory.add(String.format("Deposit | + Rs. %.2f | Balance: Rs. %.2f", amount, balance));
        System.out.println("Deposit successful.");
        return true;
    }

    public boolean withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Invalid amount. Withdrawal must be greater than Rs. 0.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal cancelled.");
            return false;
        }
        balance -= amount;
        transactionHistory.add(String.format("Withdrawal | - Rs. %.2f | Balance: Rs. %.2f", amount, balance));
        System.out.println("Withdrawal successful.");
        return true;
    }

    public void showTransactionHistory() {
        System.out.println("\n========== TRANSACTION HISTORY ==========");
        for (int i = 0; i < transactionHistory.size(); i++) {
            System.out.println((i + 1) + ". " + transactionHistory.get(i));
        }
        System.out.println("=========================================");
    }
}
