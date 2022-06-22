package DP;

import java.util.HashMap;

public class countConstruct {

    public static int countConstruct(String target, String[] wordBank){
        if(target.equals("")) return 1;

        int totalCount = 0;

        for(String word : wordBank){
            if(target.indexOf(word) == 0){
                int numWaysForRest = countConstruct(target.substring(word.length()), wordBank);
                totalCount += numWaysForRest;
            }
        }
        return totalCount;
    }

    static HashMap<String, Integer> map = new HashMap<>();
    public static int countConstruct_DP(String target, String[] wordBank){
        if(map.containsKey(target)) return map.get(target);
        if(target.equals("")) return 1;

        int totalCount = 0;

        for(String word : wordBank){
            if(target.indexOf(word) == 0){
                int numWaysForRest = countConstruct_DP(target.substring(word.length()), wordBank);
                totalCount += numWaysForRest;
            }
        }

        map.put(target, totalCount);
        return totalCount;
    }


    public static void main(String[] args) {
        System.out.println(countConstruct("", new String[]{"bo", "rd", "ate"}));
        System.out.println(countConstruct("abcdef", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(countConstruct_DP("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeeee", "eeeeeeee", "eeeeeee"}));
    }
}
