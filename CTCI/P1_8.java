package CTCI;
import java.util.ArrayList;

public class P1_8 {

    public static void zero(int[][] matrix){
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for(int i = 0; i < row.length; i++){
            if (row[i]) nullifyRow(matrix, i);
        }

        for(int j = 0; j < column.length; j++) {
            if (column[j]) nullifyColumn(matrix, j);
        }
    }

    public static void nullifyRow(int[][] matrix, int row){
        for(int j = 0; j < matrix[0].length; j++){
            matrix[row][j] = 0;
        }
    }

    public static void nullifyColumn(int[][] matrix, int col){
        for(int i = 0; i < matrix.length; i++){
            matrix[i][col] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][4];

        for(int i = 0; i < arr.length;i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = 2;
            }
        }
        arr[0][2] = 0;
        arr[2][1] = 0;
        zero(arr);
        for(int i = 0; i < arr.length;i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}
