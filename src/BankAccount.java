import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.time.LocalDate;

public class BankAccount {
    private String holderName;
    private String accountNumber;
    private float accountBalance;
    private List<String> transactions = new ArrayList<>();
    private boolean isClosed = false;
    private String creationDate;
    private String closeDate;

    public BankAccount(String name, float initBalance) {
        holderName = name;
        accountBalance = initBalance;
        Random random = new Random();
        accountNumber = String.valueOf(random.nextInt(1000));
        creationDate = LocalDate.now().toString();
    }

    public BankAccount(String name) {
        this(name, (float) 0.0);
    }

    public float getAccountBalance () {
        return accountBalance;
    }

    public void setAccountBalance(float amount) {
        accountBalance = amount;
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

    public void setClosed(boolean closed) {
        isClosed = closed;
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
        if (isClosed) {
            System.out.println("Account is already closed.");
        } else {
            isClosed = true;
            closeDate = LocalDate.now().toString();
            System.out.println("Account closed");
        }
    }
}
