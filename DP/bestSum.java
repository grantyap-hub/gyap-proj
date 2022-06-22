package DP;

import java.util.ArrayList;
import java.util.HashMap;

public class bestSum {

    public static ArrayList<Integer> bestSum(int targetSum, int[] numbers){
        if(targetSum == 0) return new ArrayList<Integer>();
        if(targetSum < 0) return null;

        ArrayList<Integer> shortestCombination = null;

        for(int i : numbers){
            int remainder = targetSum - i;
            ArrayList<Integer> remainderCombination = bestSum(remainder, numbers);
            if(remainderCombination != null){
                remainderCombination.add(i);
                if(shortestCombination == null || remainderCombination.size() < shortestCombination.size()){
                    shortestCombination = remainderCombination;
                }
            }
        }
        return shortestCombination;
    }

    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static ArrayList<Integer> bestSum1(int targetSum, int[] numbers){
        if(map.containsKey(targetSum)) return map.get(targetSum);
        if(targetSum == 0) return new ArrayList<Integer>();
        if(targetSum < 0) return null;
        ArrayList<Integer> shortestCombination = null;
        for(int i : numbers) {
            int remainder = targetSum - i;
            ArrayList<Integer> remainderCombination = bestSum1(remainder, numbers);
            if (remainderCombination != null) {
                ArrayList<Integer> combination = new ArrayList<>(remainderCombination);
                combination.add(i);
                if (shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }
        map.put(targetSum, shortestCombination);
        return shortestCombination;
    }




    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[]{5,3,4,7}));
        System.out.println(bestSum(8, new int[]{2,3,5}));
        System.out.println(bestSum(8, new int[]{1,4,5}));
        System.out.println(bestSum1(100, new int[]{1,2,5,25}));

    }

}
