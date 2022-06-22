package DP;

import java.util.HashMap;

public class canConstruct {
    public static boolean canConstruct(String target, String[] wordBank){
        if(target.equals("")) return true;

        for(String word : wordBank){
            if(target.indexOf(word) == 0){
                String suffix = target.substring(word.length());
                if(canConstruct(suffix, wordBank)) return true;
            }
        }
        return false;
    }

    static HashMap<String, Boolean> map = new HashMap<>();
    public static boolean canConstruct_DP(String target, String[] wordBank){
        if(map.containsKey(target)) return map.get(target);
        if(target.equals("")) return true;

        for(String word : wordBank){
            if(target.indexOf(word) == 0){
                String suffix = target.substring(word.length());
                if(canConstruct_DP(suffix, wordBank)){
                    map.put(target, true);
                    return true;
                }
            }
        }
        map.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("", new String[]{"bo", "rd", "ate"}));
        System.out.println(canConstruct("abcdef", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(canConstruct_DP("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeeee", "eeeeeeee", "eeeeeee"}));
        //System.out.println("potato".substring("pot".length()));
    }
}
