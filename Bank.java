import java.util.Scanner;

// Base class for all accounts
class Account {
    protected String customerName;
    protected String accountNumber;
    protected String accountType;
    protected double balance;

    // Constructor
    public Account(String customerName, String accountNumber, String accountType, double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Display balance
    public void displayBalance() {
        System.out.println("Account Holder: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: " + balance);
    }

    // Withdraw money (to be overridden)
    public void withdraw(double amount) {
        System.out.println("Withdraw function not implemented for base class.");
    }
}

// Savings Account
class SavAcct extends Account {
    private double interestRate = 5.0; // 5% annual interest

    public SavAcct(String customerName, String accountNumber, double balance) {
        super(customerName, accountNumber, "Savings", balance);
    }

    // Compute compound interest and deposit it
    public void computeInterest(int years) {
        double interest = balance * Math.pow((1 + interestRate / 100), years) - balance;
        balance += interest;
        System.out.println("Interest of " + interest + " has been added. New balance: " + balance);
    }

    // Withdraw money (with check for sufficient balance)
    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

// Current Account
class CurAcct extends Account {
    private final double MIN_BALANCE = 1000.0;
    private final double SERVICE_CHARGE = 100.0;

    public CurAcct(String customerName, String accountNumber, double balance) {
        super(customerName, accountNumber, "Current", balance);
    }

    // Withdraw money with penalty check
    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: " + balance);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Check and apply penalty if balance < minimum
    private void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Balance below minimum! Service charge of " + SERVICE_CHARGE + " imposed.");
            System.out.println("New balance after penalty: " + balance);
        }
    }
}

// Main class
public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter customer name: ");
        String name = sc.nextLine();

        System.out.println("Enter account number: ");
        String accNo = sc.nextLine();

        System.out.println("Enter account type (savings/current): ");
        String type = sc.nextLine().toLowerCase();

        Account account;
        if (type.equals("savings")) {
            account = new SavAcct(name, accNo, 0);
        } else {
            account = new CurAcct(name, accNo, 0);
        }

        while (true) {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (account instanceof SavAcct)
                System.out.println("4. Compute Interest");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    account.withdraw(wd);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    if (account instanceof SavAcct) {
                        System.out.print("Enter number of years: ");
                        int years = sc.nextInt();
                        ((SavAcct) account).computeInterest(years);
                    } else {
                        System.out.println("Interest calculation not available for Current Account.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for banking with us!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

