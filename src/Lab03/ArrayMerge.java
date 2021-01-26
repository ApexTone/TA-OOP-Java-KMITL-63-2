package Lab03;

import java.util.Scanner;
/*
* Testcase
* Correctness of Output
* */
public class ArrayMerge {
    public static void main(String[] args) {
        System.out.print("Enter list1: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String[] valueString = line.split(" ");
        int[] list1 = new int[valueString.length];
        for(int i=0;i<valueString.length;i++){
            list1[i] = Integer.parseInt(valueString[i]);
        }

        System.out.print("Enter list2: ");
        line = scanner.nextLine();
        valueString = line.split(" ");
        int[] list2 = new int[valueString.length];
        for(int i=0;i<valueString.length;i++){
            list2[i] = Integer.parseInt(valueString[i]);
        }

        int[] sortedList = merge(list1, list2);

        System.out.print("The merged list is ");
        for(int i : sortedList){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    //list1, list2 must be sorted
    public static int[] merge(int[] list1, int[] list2){
        int leftLen = list1.length;
        int rightLen = list2.length;
        int[] sortedList = new int[leftLen+rightLen];
        int sortedIndex = 0, left=0, right=0;


        while(left < leftLen && right < rightLen){
            if(list1[left] < list2[right]){
                sortedList[sortedIndex] = list1[left];
                left++;
            }
            else{
                sortedList[sortedIndex] = list2[right];
                right++;
            }
            sortedIndex++;
        }

        while(left < leftLen){
            sortedList[sortedIndex] = list1[left];
            left++;
            sortedIndex++;
        }
        while(right < rightLen){
            sortedList[sortedIndex] = list2[right];
            right++;
            sortedIndex++;
        }
        return sortedList;
    }
}
