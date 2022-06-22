package CTCI;

public class P1_7 {

    public static int rotate_matrix(int[][] matrix){
        if(matrix.length == 0 || matrix.length != matrix[0].length) return 0;
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++){
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++){
                int offset = i - first;

                int top = matrix[first][i];

                matrix[first][i] = matrix[last-offset][first];

                matrix[last-offset][first] = matrix[last][last-offset];

                matrix[last][last-offset] = matrix[i][last];

                matrix[i][last] = top;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        for(int i = 0; i < arr.length; i++){
            int count = 0;
            for(int j = 0; j < arr.length; j++){
                arr[i][j] = count;
                count++;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        rotate_matrix(arr);
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
