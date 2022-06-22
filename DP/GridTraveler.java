package DP;

import java.util.HashMap;

public class GridTraveler {

    public static long gridTraveler(int m, int n){
        if(m == 1 && n == 1) return 1;
        if(m == 0 || n == 0) return 0;
        return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
    }
    public static HashMap<String, Long> map = new HashMap<>();
    public static long gridTraveler_DP(int m, int n){
        String key = m + "," + n;
        if(map.containsKey(key)) return map.get(key);
        if(m == 1 && n == 1) return 1;
        if(m == 0 || n == 0) return 0;
        map.put(key, gridTraveler_DP(m - 1, n) + gridTraveler_DP(m, n - 1));
        return map.get(key);
    }

    public static void main(String[] args) {
        System.out.println(gridTraveler(1,1));
        System.out.println(gridTraveler(2,3));
        System.out.println(gridTraveler(3,2));
        System.out.println(gridTraveler(3,3));
        System.out.println(gridTraveler_DP(18,18));

    }
}
