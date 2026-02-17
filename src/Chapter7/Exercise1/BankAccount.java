package Chapter7.Exercise1;

/**
 * **Exercise 7.1** — Create a `BankAccount` class with:
 * - Fields: `accountHolder` (String), `balance` (double)
 * - Constructor that takes the holder name and initial balance
 * - Methods: `deposit(double amount)`, `withdraw(double amount)`, `getBalance()`, `displayInfo()`
 * - `withdraw` should refuse if the amount exceeds the balance*/

public class BankAccount {
    private final String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public BankAccount(String accountHolder) {
        this(accountHolder, 0.0);

    }

    public void deposit(double amount) {
        if(amount > 0) {
            this.balance += amount;
            System.out.println("New balance: " + balance);
        } else {
            throw new IllegalArgumentException("Amount Must be positive!");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            this.balance -= amount;
            System.out.println("New balance: " + balance);
        }
        else if(amount > balance) {
            throw new IllegalArgumentException("Insufficient funds!! || Amount to withdraw: " + amount + " MAD");
        } else if(amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be zero or negative!! || Amount: " + amount + " MAD");
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public void displayInfo() {
        System.out.println("accountHolder: " + accountHolder + " || balance: " + balance + " MAD");
    }

}
