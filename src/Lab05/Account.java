package Lab05;

import java.util.Date;
import java.util.Scanner;

/*
* Testcase
* Correctness
* Overdraft
* Negative annual interest rate
* Negative withdraw
* Negative deposit
* Negative balance
* */

public class Account {
    private int id;
    private double balance,annualInterestRate;
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
    //Caution Here!
    public void withdraw(double cash){
        if(cash <= 0){
            System.err.println("You can only withdraw positive number of cash!");
            return;
        }
        if(this.balance < cash){
            System.err.println("Overdraft is not allow!");
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

    public static void main(String[] args) {
        System.out.println("--- Account Test ---");
        System.out.print("Initial Balance: ");
        Scanner scanner = new Scanner(System.in);
        int cash = scanner.nextInt();
        Account account = new Account(1122, cash);
        account.setAnnualInterestRate(4.5);

        System.out.print("How much you'd like to withdraw?: ");
        cash = scanner.nextInt();
        account.withdraw(cash);

        System.out.print("How much you'd like to deposit?: ");
        cash = scanner.nextInt();
        account.deposit(cash);
        scanner.close();

        System.out.println("Balance: " + account.getBalance() + "\nMonthly Interest: " + account.getMonthlyInterest() + "\nDate Created: " + account.getDateCreated());
    }
}
