package Lab02;

import java.util.Random;
import java.util.Scanner;

/*
* Testcase
* Invalid choice
* Check for random seed
* */

public class RockPaperScissor {
    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());//provide true random seed for better randomization
        Scanner scanner = new Scanner(System.in);
        int playerChoice, botChoice;

        while(true){
            System.out.print("scissor (0), rock (1), paper (2): ");
            playerChoice = scanner.nextInt();
            if(playerChoice<0 || playerChoice>3){
                System.out.println("Invalid choice (0-3)\n");
                continue;
            }
            botChoice = random.nextInt(3);
            showWinner(playerChoice, botChoice);

        }
    }

    public static String intToChoice(int number){
        String choice;

        switch (number){
            case 0: choice="scissor"; break;
            case 1: choice="rock"; break;
            case 2: choice="paper"; break;
            default: choice="UNIDENTIFIED";
        }

        return choice;
    }

    public static void showWinner(int player,int bot){

        //System.out.println((player+1)%3 + "\t" + bot);
        //use math for less conditional statements
        if(player == bot){
            System.out.printf("The computer is %s. You are %s too. It is a draw\n\n", intToChoice(bot), intToChoice(player));
        }
        else if((player+1)%3 == bot){
            System.out.printf("The computer is %s. You are %s. You lose\n\n", intToChoice(bot), intToChoice(player));
        }
        else{
            System.out.printf("The computer is %s. You are %s. You won\n\n", intToChoice(bot), intToChoice(player));
        }
    }
}
