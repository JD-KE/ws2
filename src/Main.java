import java.util.List;

public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Name", 1000);
        System.out.println(account.getAccountBalance());

        account.deposit(123);

        System.out.println(account.getAccountBalance());

        account.withdraw(123);

        System.out.println(account.getAccountBalance());

        // account.close();

        account.withdraw(123);

        System.out.println(account.getAccountBalance());

        account.close();

        account.close();

        System.out.println("%s, %s, %s, %s, %b".formatted(
            account.getName(),account.getAccountNumber(), account.getCreationDate(),account.getClosingDate(),account.getClosed()));

        List<String> transactions = account.getTransactions();
        transactions.forEach(System.out::println);
        
        FixedDepositAccount fixed = new FixedDepositAccount("Name", 1000, 10);

        System.out.println(fixed.getBalance());
        fixed.getAccountBalance();

        fixed.deposit(100);

        fixed.withdraw(100);     

        System.out.println(fixed.getAccountBalance());

        System.out.println("%s, %s, %s, %s, %b, %3.1f, %d".formatted(
            fixed.getName(),fixed.getAccountNumber(), fixed.getCreationDate(),fixed.getClosingDate(),fixed.getClosed(),
            fixed.getInterest(), fixed.getDuration()));

    }
    
}
