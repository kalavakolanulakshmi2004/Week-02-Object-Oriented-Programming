import java.util.Scanner;
interface Loanable {
    void applyForLoan();
    double calculateLoanEligibility();
}
abstract class BankAccount implements Loanable {
    private int accountNumber;
    private String holderName;
    private double balance;
    protected double eligibilityMultiplier;
    protected double interestRate;
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getHolderName() {
        return holderName;
    }
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setEligibilityMultiplier(double eligibilityMultiplier) {
        this.eligibilityMultiplier = eligibilityMultiplier;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient Balance");
        }
    }
    public abstract double calculateInterest();
    public void displayAccountDetails() {
        System.out.println("Account No: " + accountNumber + "\nName: " + holderName
                + "\nBalance: " + balance + "\nInterest: " + calculateInterest()
                + "\nLoan Eligibility: " + calculateLoanEligibility());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[2];
        SavingsAccount sa = new SavingsAccount();
        System.out.println("Enter details for Savings Account:");
        System.out.print("Account Number: ");
        sa.setAccountNumber(sc.nextInt());
        sc.nextLine();
        System.out.print("Holder Name: ");
        sa.setHolderName(sc.nextLine());
        System.out.print("Balance: ");
        sa.setBalance(sc.nextDouble());
        System.out.print("Interest Rate : ");
        sa.setInterestRate(sc.nextDouble());
        System.out.print("Eligibility Multiplier: ");
        sa.setEligibilityMultiplier(sc.nextDouble());
        sc.nextLine();
        accounts[0] = sa;
        CurrentAccount ca = new CurrentAccount();
        System.out.println("Enter details for Current Account:");
        System.out.print("Account Number: ");
        ca.setAccountNumber(sc.nextInt());
        sc.nextLine();
        System.out.print("Holder Name: ");
        ca.setHolderName(sc.nextLine());
        System.out.print("Balance: ");
        ca.setBalance(sc.nextDouble());
        System.out.print("Interest Rate : ");
        ca.setInterestRate(sc.nextDouble());
        System.out.print("Eligibility Multiplier: ");
        ca.setEligibilityMultiplier(sc.nextDouble());
        sc.nextLine();
        accounts[1] = ca;
        System.out.println("\nAccount Details:");
        for (BankAccount acc : accounts) {
            acc.applyForLoan();
            acc.displayAccountDetails();
        }
    }
}
class SavingsAccount extends BankAccount {
    public double calculateInterest() {
        return getBalance() * interestRate/100;
    }
    public void applyForLoan() {
        System.out.println("Savings Account Loan Applied.");
    }
    public double calculateLoanEligibility() {
        return getBalance() * eligibilityMultiplier;
    }
}
class CurrentAccount extends BankAccount {
    public double calculateInterest() {
        return getBalance() * interestRate/100;
    }
    public void applyForLoan() {
        System.out.println("Current Account Loan Applied.");
    }
    public double calculateLoanEligibility() {
        return getBalance() * eligibilityMultiplier;
    }
}