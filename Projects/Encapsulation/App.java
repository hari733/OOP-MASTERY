import java.util.Scanner;

class Bank {
    private String accountHolder;
    private String accountNumber;
    private int pin;
    private long balance;
    private int re_attempt;

    private static final Scanner scn = new Scanner(System.in);

    Bank(String accountHolder, String accountNumber, long balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = 1234;
        this.re_attempt = 3;
    }

    private int getPin() {
        System.out.print("Enter PIN: ");
        return scn.nextInt();
    }

    private boolean checkPin(int pin) {
        return this.pin == pin;
    }

    private boolean verifyPin() {
        int attempt = 1;
        while (attempt <= re_attempt) {
            if (checkPin(getPin())) {
                return true;
            } else {
                System.out.println("❌ Wrong PIN. Attempts left: " + (re_attempt - attempt));
                attempt++;
            }
        }
        System.out.println("❌ Maximum attempts reached. Access denied.");
        return false;
    }

    public void deposit(long amount) {
        if (!verifyPin()) return;

        if (amount > 0) {
            this.balance += amount;
            System.out.println("✅ Deposit successful! New balance: " + this.balance);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void withdraw(long amount) {
        if (!verifyPin()) return;

        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount.");
        } else if (amount > this.balance) {
            System.out.println("❌ Insufficient funds.");
        } else {
            this.balance -= amount;
            System.out.println("✅ Withdrawal successful! Remaining balance: " + this.balance);
        }
    }

    public long getBalance() {
        return balance;
    }

    public void getDetails() {
        System.out.println("\n🔍 Account Details:");
        System.out.println("Account Holder: " + this.accountHolder);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Balance: " + this.balance);
    }
}


public class App {
    public static void main(String[] args) {
        Bank user1 = new Bank("Ramesh", "171007", 100);
        System.out.println("🏦 Welcome");
        user1.getDetails();

        Scanner scn = new Scanner(System.in);
        System.out.println("\nPress for deposit --(d)");
        System.out.println("Press for withdraw --(w)");
        char response = scn.next().charAt(0);

        if (response == 'd') {
            System.out.print("Enter amount: ");
            long amount = scn.nextLong();
            user1.deposit(amount);
        } else if (response == 'w') {
            System.out.print("Enter amount: ");
            long amount = scn.nextLong();
            user1.withdraw(amount);
        } else {
            System.out.println("❌ Invalid option selected.");
        }

        user1.getDetails();
        scn.close();
    }
}
