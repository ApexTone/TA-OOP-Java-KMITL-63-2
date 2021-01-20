package Lab03;

import java.util.Random;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        System.out.print("Enter the size for the matrix: ");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(System.currentTimeMillis());
        int dimension = scanner.nextInt();
        scanner.close();

        if(dimension <= 0){
            System.err.println("Matrix dimension must be positive integer");
            System.exit(1);
        }

        int[][] matrix = new int[dimension][dimension];
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++){
                matrix[i][j] = random.nextInt(2);
            }
        }
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        int[] subDiagonal = new int[dimension-1];
        int[] superDiagonal = new int[dimension-1];
        int[] diagonal = new int[dimension];
        for(int i=0;i<dimension-1;i++){
            superDiagonal[i] = matrix[i][i+1];
        }
        for(int i=0;i<dimension;i++){
            diagonal[i] = matrix[i][i];
        }
        for(int i=1;i<=dimension-1;i++){
            subDiagonal[i-1] = matrix[i][i-1];
        }

        //row
        for(int i=0;i<dimension;i++){
            if(isSame(matrix[i], 0)){
                System.out.println("All 0s on row "+i);
            }
            else if(isSame(matrix[i], 1)){
                System.out.println("All 1s on row "+i);
            }
        }

        //column
        int[] col = new int[dimension];
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++){//build column array
                col[j] = matrix[j][i];
            }

            if(isSame(col, 0)){
                System.out.println("All 0s on column "+i);
            }
            else if(isSame(col, 1)){
                System.out.println("All 1s on column "+i);
            }
        }

        //diagonal
        if(isSame(superDiagonal, 0)){
            System.out.println("All 0s on the superdiagonal");
        }
        else if(isSame(superDiagonal, 1)){
            System.out.println("All 1s on the superdiagonal");
        }
        else{
            System.out.println("No same numbers on the superdiagonal");
        }

        if(isSame(diagonal, 0)){
            System.out.println("All 0s on the diagonal");
        }
        else if(isSame(diagonal, 1)){
            System.out.println("All 1s on the diagonal");
        }
        else{
            System.out.println("No same numbers on the diagonal");
        }

        if(isSame(subDiagonal, 0)){
            System.out.println("All 0s on the subdiagonal");
        }
        else if(isSame(subDiagonal, 1)){
            System.out.println("All 1s on the subdiagonal");
        }
        else{
            System.out.println("No same numbers on the subdiagonal");
        }
    }

    public static boolean isSame(int[] line, int allSame){
        for(int i=0;i< line.length;i++){
            if(line[i] != allSame){
                return false;
            }
        }
        return true;
    }

}
