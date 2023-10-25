import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankAccount {
    private String holderName;
    private String accountNumber;
    private float accountBalance;
    private List<String> transactions = new ArrayList<>();
    private boolean isClosed = false;
    private String creationDate = "25.10.2023";
    private String closeDate;

    public BankAccount(String name, float initBalance) {
        holderName = name;
        accountBalance = initBalance;
        Random random = new Random();
        accountNumber = String.valueOf(random.nextInt(1000));
    }

    public BankAccount(String name) {
        this(name, (float) 0.0);
    }

    public float getBalance () {
        return accountBalance;
    }

    public String getName () {
        return holderName;
    }

    public String getAccountNumber () {
        return accountNumber;
    }

    public List<String> getTransactions () {
        return transactions;
    }
    public boolean getClosed() {
        return isClosed;
    }

    public String getCreationDate () {
        return creationDate;
    }

    public String getClosingDate () {
        return closeDate;
    }

    public void deposit(float amount) {
        if (isClosed) {
            throw new IllegalArgumentException("Account is closed. Deposit cancelled.");
        } else if (amount <= 0) {
            throw new IllegalArgumentException("Negative or zero amount entered. Please deposit a positive amount.");
        } else {
            accountBalance += amount;
            String announce = "deposit $%.2f at 25.10.2023".formatted(amount);
            transactions.add(announce);
            System.out.println(announce);
        }
    }

    public void withdraw(float amount) {
        if (isClosed) {
            throw new IllegalArgumentException("Account is closed. Withrawal cancelled.");
        } else if (amount <= 0) {
            throw new IllegalArgumentException("Negative or zero amount entered. Please deposit a positive amount.");
        } else if (accountBalance < amount) {
            throw new IllegalArgumentException("Withdrawing more than balance in account. Withdrawal cancelled.");
        } else {
            accountBalance -= amount;
            String announce = "withdraw $%.2f at 25.10.2023".formatted(amount);
            transactions.add(announce);
            System.out.println(announce);
        }
    }

    public void close() {
        isClosed = true;
        closeDate = "25.10.2023";
        System.out.println("Account closed");
    }
}
