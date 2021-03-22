package Quiz01;

import java.util.ArrayList;
import java.util.Scanner;

/*
* Object Oriented Programming => Object rind Pogam
* */

public class NoDup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input string: ");
        String line = scanner.nextLine();
        ArrayList<Character> duplicateCharacter = new ArrayList<>();
        StringBuilder outputString = new StringBuilder();
        for(int i=0;i<line.length();i++){//loop all character
            char currentCharacter = line.charAt(i);
            //System.out.println(currentCharacter);

            if(currentCharacter == ' '){ //space is always allow
                outputString.append(currentCharacter);
            }
            else if(duplicateCharacter.lastIndexOf(currentCharacter) == -1){ //if it is not duplicated
                duplicateCharacter.add(currentCharacter);
                outputString.append(currentCharacter);
            }
        }
        //System.out.println(duplicateCharacter.toString());
        System.out.println("Output string: "+outputString.toString());
    }
}
