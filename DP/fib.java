package DP;

import java.util.ArrayList;
import java.util.HashMap;

public class fib {

    public static HashMap<Integer, Long> map = new HashMap<>();
    public static int fib_recursion(int n){
        if(n <= 2) return 1;

        return fib_recursion(n-1) + fib_recursion(n-2);
    }

    public static long fib_DP(int n){
        if(map.containsKey(n)) return map.get(n);
        if(n <= 2) return 1;
        map.put(n, fib_DP(n-1) + fib_DP(n-2));
        return map.get(n);
    }

    public static void main(String[] args) {
        System.out.println(fib_DP(6));
        System.out.println(fib_recursion(7));
        System.out.println(fib_recursion(8));
        System.out.println(fib_DP(500));
    }
}
