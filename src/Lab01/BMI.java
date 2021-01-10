package Lab01;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        System.out.print("Enter weight in pounds: ");
        double weight,height;
        Scanner scanner = new Scanner(System.in);
        weight = scanner.nextDouble();
        if(weight <= 0){
            System.out.println("Weight must be positive");
            System.exit(0);
        }
        weight = weight*0.45359237;
        System.out.print("Enter height in inches: ");
        height = scanner.nextDouble();
        if(height <= 0){
            System.out.println("height must be positive");
            System.exit(0);
        }
        height = height*0.0254;

        System.out.printf("BMI is %.4f",weight/(height*height));
    }
}
