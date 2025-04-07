package Problems;
import java.util.*;
public class BankAccount {
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;
    private final int accountNumber;
    private String accountHolderName;
    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }
    public static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }
    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of accounts to create: ");
        int numAccounts = scanner.nextInt();
        scanner.nextLine();
        BankAccount[] accounts = new BankAccount[numAccounts];
        for (int i = 0; i < numAccounts; i++) {
            System.out.println("\nEnter details for Account " + (i + 1) + ":");
            System.out.print("Enter Account Holder Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Account Number: ");
            int accNumber = scanner.nextInt();
            scanner.nextLine();
            accounts[i] = new BankAccount(name, accNumber);
        }
        for (BankAccount account : accounts) {
            account.displayAccountDetails();
        }
        BankAccount.getTotalAccounts();
    }
}