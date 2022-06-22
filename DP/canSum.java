package DP;

import java.util.HashMap;

public class canSum {


    public static boolean canSum(int targetSum, int[] numbers){
        if(targetSum == 0) return true;
        if(targetSum < 0) return false;

        for(int i : numbers){
            int remainder = targetSum - i;
            if(canSum(remainder, numbers)) return true;
        }
        return false;
    }

    static HashMap<Integer, Boolean> map = new HashMap<>();

    public static boolean canSum1(int targetSum, int[] numbers){
        if(map.containsKey(targetSum)) return map.get(targetSum);
        if(targetSum == 0) return true;
        if(targetSum < 0) return false;

        for(int i : numbers){
            int remainder = targetSum - i;

            if(canSum1(remainder, numbers)){
                map.put(targetSum, true);
                return true;
            }
        }

        map.put(targetSum, false);
        return false;
    }

    public static void main(String[] args) {

        System.out.println(canSum(7, new int[]{2, 3}));
        System.out.println(canSum(7, new int[]{5,3,4,7}));
        System.out.println(canSum(7, new int[]{2,4}));
        System.out.println(canSum(8, new int[]{2,3,5}));
        System.out.println(canSum1(300, new int[]{7,14}));

    }
}
