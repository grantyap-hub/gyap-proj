package DP;

import java.util.ArrayList;

public class bestSumTab {


    public static ArrayList<Integer> bestSum(int target, int[] nums){
        ArrayList<Integer>[] table = new ArrayList[target + 1];
        table[0] = new ArrayList<>();

        for(int i = 0; i <= target; i++){
            if(table[i] != null){
                for(int num : nums){
                    if(i + num <= target){
                        ArrayList<Integer> combination = new ArrayList<>(table[i]);
                        combination.add(num);
                        if(table[i+num] == null || table[i+num].size() > combination.size()) {
                            table[i + num] = combination;
                        }
                    }
                }
            }
        }

        return table[target];
    }


    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[]{5,3,4,7}));
        System.out.println(bestSum(8, new int[]{2,3,5}));
        System.out.println(bestSum(8, new int[]{1,4,5}));
        System.out.println(bestSum(100, new int[]{1,2,5,25}));
    }
}
