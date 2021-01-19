package Lab2;

import java.util.Scanner;
/*
* Testcase
* 1-10
* */
public class PyramidPattern {
    public static void main(String[] args) {
        System.out.print("Enter the number of lines: ");
        Scanner scanner = new Scanner(System.in);
        int level = scanner.nextInt();

        int spaces = (level-1)*2;
        for(int i=0;i<level;i++){//level control

            for(int j=0;j<spaces;j++){//front spacing
                System.out.print(" ");
            }

            for(int j=i+1;j>1;j--){//front number (not including 1)
                System.out.print(j+" ");
            }

            for(int j=1;j<=i+1;j++){//1 to i
                System.out.print(j+" ");
            }

            System.out.println();
            spaces -= 2;
        }
    }
}
