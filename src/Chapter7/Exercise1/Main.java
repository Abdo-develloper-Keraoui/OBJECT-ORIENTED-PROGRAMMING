package Chapter7.Exercise1;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Abdottawab KERAOUI");
        account1.displayInfo();
        account1.deposit(1000);
        account1.displayInfo();
        account1.withdraw(100);
        System.out.println( "Balance: " + account1.getBalance() + " MAD");

    }
}
