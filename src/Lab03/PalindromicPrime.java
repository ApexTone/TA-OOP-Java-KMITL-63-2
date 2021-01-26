package Lab03;

import java.util.ArrayList;
/*
* Testcase
* Correctness of Output
* */
public class PalindromicPrime {
    public static void main(String[] args) {
        ArrayList<Integer> palindromicPrime = new ArrayList<>();

        for(int i=2;;i++){
            if(palindromicPrime.size() >= 100){
                break;
            }
            if(isPrime(i)){
                if(isPalindrome(String.valueOf(i))){
                    palindromicPrime.add(i);
                }
            }
        }
        for(int i=1;i<=palindromicPrime.size();i++){
            System.out.print(palindromicPrime.get(i-1)+" ");
            if(i%10 == 0){
                System.out.println();
            }
        }

    }

    public static boolean isPrime(int number){
        number = Math.abs(number);
        if(number == 2){
            return true;
        }
        else if(number%2 == 0 || number == 1){
            return false;
        }
        else{
            for(int i=3;i<=Math.sqrt(number);i+=2){
                if(number%i == 0){
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isPalindrome(String s){
        int left=0, right=s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
