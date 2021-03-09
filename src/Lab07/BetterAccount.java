package Lab07;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/*
 * Testcase
 * Class Design
 * */

public class BetterAccount {
    private int id;
    private double annualInterestRate;
    protected double balance;
    final private Date dateCreated;
    private String name;
    private ArrayList<Transaction> transactions;

    public BetterAccount(){
        this(0,0);
    }

    public BetterAccount(int id, double balance) {
        this("NONAME", id, balance);
    }

    public BetterAccount(String name, int id, double balance) {
        this.setName(name);
        this.setId(id);
        this.setBalance(balance);
        this.setAnnualInterestRate(0);
        this.dateCreated = new Date();
        this.transactions = new ArrayList<>();
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name.length() <= 0){
            System.out.println("Name must contain at least 1 character");
            return;
        }
        this.name = name;
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
        transactions.add(new Transaction(new Date(),'W',cash,this.balance,"Withdraw"));
    }
    public void deposit(double cash){
        if(cash <= 0){
            System.err.println("You can only deposit positive number of cash!");
            return;
        }
        this.balance += cash;
        transactions.add(new Transaction(new Date(),'D',cash,this.balance,"Deposit"));
    }

    public void printTransactions(){
        System.out.printf("%-30s%-8s%-10s%-10s%n", "Date","Type","Amount","Balance");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
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
    public static void main(String[] args) {
        BetterAccount account = new BetterAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        account.setName(scanner.nextLine());
        System.out.print("Account ID: ");
        account.setId(scanner.nextInt());
        System.out.print("Annual Interested Rate: ");
        account.setAnnualInterestRate(scanner.nextDouble());
        System.out.print("Balance: ");
        account.setBalance(scanner.nextDouble());

        Random random = new Random(System.currentTimeMillis());
        for(int i=0;i<10;i++){
            int choice = random.nextInt()%2;
            double cash = 100+random.nextDouble()*1000;
            if(choice==0){
                account.withdraw(cash);
            }
            else{
                account.deposit(cash);
            }
        }

        account.printTransactions();
    }
}

class Transaction{
    final private Date date;
    final private char type;
    final private double amount, balance;
    final private String description;

    public Transaction(Date date, char type, double amount, double balance, String description) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%-30s%-8c%-10.2f%-10.2f", this.date.toString(),this.type,this.amount,this.balance);
    }
}

