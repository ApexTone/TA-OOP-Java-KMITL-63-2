package Lab06;

import java.util.Scanner;

/*
* Testcase
* negative value
* 0 height
* */
public class BMI2 {
    private String name;
    private int age;
    private double weight,feet,inches;

    public BMI2(String name, int age, double weight, double feet, double inches) {
        setName(name);
        setAge(age);
        setWeight(weight);
        if(feet <= 0 && inches <= 0){
            System.out.println("Height can be 0, default to 1'0''");
            feet = 1;
            inches = 0;
        }
        setFeet(feet);
        setInches(inches);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name.length() <= 0){
            System.err.println("Name field must not be empty! Use default name: TEMP NAME");
            this.name = "TEMP NAME";
        }
        else {
            this.name = name;
        }
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = Math.max(age, 1);

    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = Math.max(weight,1.0);
    }
    public double getFeet() {
        return feet;
    }
    public void setFeet(double feet) {
        this.feet = Math.max(feet, 1.0);
    }
    public double getInches() {
        return inches;
    }
    public void setInches(double inches) {
        this.inches = Math.max(inches, 0);
    }

    public double metricHeight(){
        return ((this.feet * 12) + this.inches) * 0.0254;
    }
    public double metricWeight(){
        return this.weight * 0.45359237;
    }

    public double calculateBMI(){
        return this.metricWeight()/Math.pow(this.metricHeight(),2);
    }
    public String intepretBMI(){
        double res = calculateBMI();
        if(res < 18.5){
            return "Underweight";
        }
        else if(res <25){
            return "Normal";
        }
        else if(res < 30){
            return "Overweight";
        }
        else{
            return "Obese";
        }
    }


    public static void main(String[] args) {
        String name;
        int age;
        double weight,feet,inches;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Age: ");
        age = scanner.nextInt();
        System.out.print("Weight (pound): ");
        weight = scanner.nextDouble();
        System.out.print("Feet: ");
        feet = scanner.nextDouble();
        System.out.print("Inches: ");
        inches = scanner.nextDouble();
        BMI2 bmi = new BMI2(name,age,weight,feet,inches);
        System.out.println(bmi.calculateBMI() + " " + bmi.intepretBMI());
    }
}
