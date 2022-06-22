package DP;

public class canSumTab {

    public static boolean canSum(int target, int[] nums){
        boolean[] table = new boolean[target+1];
        table[0] = true;
        for(int i : nums){
            table[i] = true;
        }

        for(int i = 0; i <= target; i++){
            if(table[i] == true){
                for(int num : nums){
                    if(i+num <= target) table[i+num] = true;
                }
            }
        }

        return table[target];
    }


    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2, 3}));
        System.out.println(canSum(7, new int[]{5,3,4,7}));
        System.out.println(canSum(7, new int[]{2,4}));
        System.out.println(canSum(8, new int[]{2,3,5}));
        System.out.println(canSum(300, new int[]{7,14}));
    }
}
