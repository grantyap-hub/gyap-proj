package DP;

public class gridTravelerTab {

    public static long gridTraveler(int m, int n){
        long[][] grid = new long[m+1][n+1];
        for(long i[] : grid){
            for(long j : i){
                j = 0;
            }
        }
        grid[1][1] = 1;

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                long current = grid[i][j];
                if(j + 1 <= n) grid[i][j+1] += current;
                if(i + 1 <= m) grid[i+1][j] += current;
            }
        }
        return grid[m][n];
    }


    public static void main(String[] args) {
        System.out.println(gridTraveler(18, 18));
    }
}
