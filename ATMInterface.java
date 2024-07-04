import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
class ATM {
    private final BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. New balance: " + account.getBalance());
    }

    public double checkBalance() {
        return account.getBalance();
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(0.0);
        ATM atm = new ATM(account);

        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter amount to withdraw:");
                    double amount = scanner.nextDouble();
                    atm.withdraw(amount);
                    break;
                case 2:
                    System.out.println("Enter amount to deposit:");
                    amount = scanner.nextDouble();
                    atm.deposit(amount);
                    break;
                case 3:
                    System.out.println("Current balance: " + atm.checkBalance());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

