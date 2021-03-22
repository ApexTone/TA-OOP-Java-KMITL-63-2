package Quiz01;

import java.util.Scanner;

public class MatrixOp {
    public static void main(String[] args) {
        System.out.print("Input size of matrix: ");
        Scanner scanner = new Scanner(System.in);
        int matrixSize = scanner.nextInt();
        System.out.println("Random matrix:");

        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {  //generate matrix
            for(int j=0;j<matrixSize;j++){
                matrix[i][j]= (int)(Math.random()*10);
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        int maxValue = Integer.MIN_VALUE;
        int x=0,y=0,value;
        for (int i = 0; i < matrixSize; i++) {
            for(int j=0;j<matrixSize;j++){
                value = matrix[i][j];
                if(value > maxValue){//find first largest number
                    maxValue = value;
                    x = j;
                    y = i;
                }
            }
        }
        System.out.println("The firsts found largest member is: "+maxValue+" at ("+y+","+x+")");

        StringBuilder valueList = new StringBuilder();
        if(y==0){
            valueList.append("NO");
        }
        else{
            for(int i=y-1;i>=0;i--){
                if(i == 0)
                    valueList.append(matrix[i][x]);
                else
                    valueList.append(matrix[i][x]).append(", ");
            }
        }
        System.out.println("Top: "+valueList.toString());
        valueList = new StringBuilder();

        if(x==matrixSize-1){
            valueList.append("NO");
        }
        else{
            for(int i=x+1;i<matrixSize;i++){
                if(i+1 == matrixSize)
                    valueList.append(matrix[y][i]);
                else
                    valueList.append(matrix[y][i]).append(", ");
            }
        }
        System.out.println("Right: "+valueList.toString());
        valueList = new StringBuilder();

        if(y==matrixSize-1){
            valueList.append("NO");
        }
        else{
            for(int i=y+1;i<matrixSize;i++){
                if(i+1 == matrixSize)
                    valueList.append(matrix[i][x]);
                else
                    valueList.append(matrix[i][x]).append(", ");
            }
        }
        System.out.println("Bottom: "+valueList.toString());
        valueList = new StringBuilder();

        if(x==0){
            valueList.append("NO");
        }
        else{
            for(int i=x-1;i>=0;i--){
                if(i == 0)
                    valueList.append(matrix[y][i]);
                else
                    valueList.append(matrix[y][i]).append(", ");
            }
        }
        System.out.println("Left: "+valueList.toString());
    }
}
