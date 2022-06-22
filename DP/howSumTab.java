package DP;

import java.util.ArrayList;

public class howSumTab {

    public static ArrayList<Integer> howSum(int target, int[] nums){

        ArrayList<Integer>[] table = new ArrayList[target + 1];
        table[0] = new ArrayList<>();

        for(int i = 0; i <= target; i++){
            if(table[i] != null){
                for(int num : nums){
                    if(i + num <= target){
                        table[i + num] = new ArrayList<>(table[i]);
                        table[i + num].add(num);
                    }
                }
            }
        }
        return table[target];
    }


    public static void main(String[] args) {
        System.out.println(howSum(7, new int[]{2, 3}));
        System.out.println(howSum(7, new int[]{5,3,4,7}));
        System.out.println(howSum(7, new int[]{2,4}));
        System.out.println(howSum(8, new int[]{2,3,5}));
        System.out.println(howSum(300, new int[]{7,14}));
    }
}
