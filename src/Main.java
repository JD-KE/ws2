import java.util.List;

public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Name", 1000);
        System.out.println(account.getBalance());

        account.deposit(123);

        System.out.println(account.getBalance());

        account.withdraw(123);

        System.out.println(account.getBalance());

        // account.close();

        account.withdraw(123);

        System.out.println(account.getBalance());

        account.close();

        System.out.println("%s, %s, %s, %s, %b".formatted(
            account.getName(),account.getAccountNumber(), account.getCreationDate(),account.getClosingDate(),account.getClosed()));

        List<String> transactions = account.getTransactions();
        transactions.forEach(System.out::println);
        

    }
    
}
