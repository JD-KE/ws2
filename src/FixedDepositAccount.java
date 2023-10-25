public class FixedDepositAccount extends BankAccount{
    private float interest;
    private int duration;

    public FixedDepositAccount(String name, float balance, float interest, int duration) {
        super(name, balance);
        this.interest = interest;
        this.duration = duration;
    }

    public FixedDepositAccount(String name, float balance, float interest) {
        this(name, balance, interest, 6);
    }

    public FixedDepositAccount(String name, float balance) {
        this(name, balance, 3);
    }

    @Override
    public void deposit(float amount) {}

    @Override
    public void withdraw(float amount) {}

    public float getBalance() {
        float newBalance = super.getAccountBalance() * (1 + interest / 100);
        super.setAccountBalance(newBalance);
        return newBalance;
    }

    public float getInterest() {
        return interest;
    }

    public int getDuration() {
        return duration;
    }

}
