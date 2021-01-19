package Lab02;

import java.util.Scanner;
/*
* Testcase
* Name with space-bar
* Name with different length
* */
public class CitiesSort {
    public static void main(String[] args) {
        System.out.print("Enter the first city: ");
        final int citySize = 3;

        String[] city = new String[citySize];
        Scanner scanner = new Scanner(System.in);
        city[0] = scanner.nextLine();

        System.out.print("Enter the second city: ");
        city[1] = scanner.nextLine();
        System.out.print("Enter the last city: ");
        city[2] = scanner.nextLine();

        //bubble sort
        for(int i=0;i<citySize;i++){
            for(int j=0;j<citySize-1;j++){
                if(city[j].compareToIgnoreCase(city[j+1]) > 0){
                    String temp = city[j+1];
                    city[j+1] = city[j];
                    city[j] = temp;
                }
            }
        }

        System.out.printf("The three cities in alphabetical order are %s, %s, %s",city[0],city[1],city[2]);
    }
}
