package Lab07;

import java.util.Date;
import java.util.Scanner;

/*
* Testcase
* Class Design
* Overdraft
* */

public class AccountInheritance {
    public static void main(String[] args) {
        Account account = new Account(1,5000);
        CheckingAccount checking = new CheckingAccount(2,5000,5000);
        SavingAccount saving = new SavingAccount(3,5000);
        account.setAnnualInterestRate(4.5);
        checking.setAnnualInterestRate(4.5);
        saving.setAnnualInterestRate(4.5);
        System.out.print("Input Overdraft Limit: ");
        Scanner scanner = new Scanner(System.in);
        checking.setOverdraftLimit(scanner.nextDouble());
        System.out.print("Input Withdraw Amount: ");
        double cash = scanner.nextDouble();
        scanner.close();

        account.withdraw(cash);
        checking.withdraw(cash);
        saving.withdraw(cash);


        System.out.println(account);
        System.out.println(checking);
        System.out.println(saving);
    }
}

// NOTE:
// private: class
// default(no modifier): class+package
// protected: class+package+subclass
// public: class+package+subclass+world
// Further reading: https://softwareengineering.stackexchange.com/questions/238581/why-is-there-no-subclasses-only-access-modifier-in-java/238592
class Account {
    private int id;
    private double annualInterestRate;
    protected double balance;
    final private Date dateCreated;

    public Account(){
        this(0,0);
    }

    public Account(int id, double balance) {
        this.setId(id);
        this.setBalance(balance);
        this.setAnnualInterestRate(0);
        this.dateCreated = new Date();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        if (balance < 0) {
            System.err.println("Account's balance can't be negative");
            this.balance = 0;
            return;
        }
        this.balance = balance;

    }
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public void setAnnualInterestRate(double annualInterestRate) {
        if(annualInterestRate < 0){
            System.err.println("Annual interest rate can't be negative");
            this.annualInterestRate = 0;
            return;
        }
        this.annualInterestRate = annualInterestRate;
    }
    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate(){
        return this.annualInterestRate/12;
    }
    public double getMonthlyInterest(){
        return this.balance * this.getMonthlyInterestRate()/100;
    }

    public void withdraw(double cash){
        if(cash <= 0){
            System.err.println("You can only withdraw positive number of cash!");
            return;
        }
        if(this.balance < cash){
            System.err.println("Overdraft is not allow by default!");
            return;
        }
        this.balance -= cash;
    }
    public void deposit(double cash){
        if(cash <= 0){
            System.err.println("You can only deposit positive number of cash!");
            return;
        }
        this.balance += cash;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", annualInterestRate=" + annualInterestRate +
                ", dateCreated=" + dateCreated +
                '}';
    }
}

class CheckingAccount extends Account{
    private double overdraftLimit;
    public CheckingAccount() {
        this(5000);
    }

    public CheckingAccount(double overdraftLimit) {
        this.setOverdraftLimit(overdraftLimit);
    }

    public CheckingAccount(int id, double balance, double overdraftLimit) {
        super(id, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        if(overdraftLimit > 0) {
            this.overdraftLimit = overdraftLimit;
        }
        else{
            System.out.println("Overdraft must be positive number. Default at 5000.0");
            this.overdraftLimit = 5000;
        }
    }

    @Override
    public void withdraw(double cash) {
        if(cash <= 0){
            System.err.println("You can only withdraw positive number of cash!");
            return;
        }
        if(this.balance+this.overdraftLimit < cash){
            System.err.println("Can't overdraft more than your account limit: "+this.overdraftLimit);
            return;
        }
        super.balance -= cash;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                super.toString() +
                ", overdraftLimit=" + overdraftLimit +
                "}";
    }
}

class SavingAccount extends Account{
    public SavingAccount() {
        super();
    }
    public SavingAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void withdraw(double cash){
        if(cash <= 0){
            System.err.println("You can only withdraw positive number of cash!");
            return;
        }
        if(this.balance < cash){
            System.err.println("Overdraft is not allow in saving account!");
            return;
        }
        this.balance -= cash;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                super.toString() +
                "}";
    }
}
