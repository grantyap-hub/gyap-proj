package DP;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class howSum {

    public static ArrayList<Integer> howSum(int targetSum, int[] numbers){
        if(targetSum == 0) return new ArrayList<Integer>();
        if(targetSum < 0) return null;


        for(int i : numbers){
            int remainder = targetSum - i;
            ArrayList<Integer> result = howSum(remainder, numbers);
            if(result != null){
                result.add(i);
                return result;
            }
        }
        return null;
    }
    public static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static ArrayList<Integer> howSum1(int targetSum, int[] numbers){
        if(targetSum == 0) return new ArrayList<Integer>();
        if(targetSum < 0) return null;
        if(map.containsKey(targetSum)) return map.get(targetSum);

        for(int i : numbers){
            int remainder = targetSum - i;
            ArrayList<Integer> result = howSum1(remainder, numbers);
            if(result != null){
                ArrayList<Integer> temp = new ArrayList<>(result);
                temp.add(i);
                map.put(targetSum, result);
                return map.get(targetSum);
            }
        }
        map.put(targetSum, null);
        return null;
    }


    public static void main(String[] args) {
        System.out.println(howSum(7, new int[]{2, 3}));
        System.out.println(howSum(7, new int[]{5,3,4,7}));
        System.out.println(howSum(7, new int[]{2,4}));
        System.out.println(howSum(8, new int[]{2,3,5}));
        System.out.println(howSum1(300, new int[]{7,14}));
    }

}
