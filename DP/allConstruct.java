package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class allConstruct {

    //m = target.length
    //n = wordBank.length

    //Time Complexity: O(n^m)
    //Explanation: For every word in the word bank, we need to
    //look over the target length each time to check our specific phrase

    //Space Complexity: O(m)
    //Explanation: Our call stack only includes the length of one path of
    //our entire recursion tree that we form with this method.
    public static List<List<String>> allConstruct(String target, String[] wordBank){
        if(target.equals("")) return new ArrayList<>(Arrays.asList(new ArrayList<>()));

        List<List<String>> result = new ArrayList<>();

        for(String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());

                List<List<String>> suffixWays = allConstruct(suffix, wordBank);
                List<List<String>> targetWays = new ArrayList<>();
                for (int i = 0; i < suffixWays.size(); i++) {
                    List<String> temp = new ArrayList<>(suffixWays.get(i));
                    temp.add(0, word);
                    targetWays.add(temp);
                }
                for(int i = 0; i < targetWays.size(); i++){
                    result.add(new ArrayList<>(targetWays.get(i)));
                }
            }
        }
        return result;
    }


    //m = target.length
    //n = wordBank.length

    //Time Complexity: O(n^m)
    //Explanation: For every word in the word bank, we need to
    //look over the target length each time to check our specific phrase. Slight
    //improvement from recursion as we still need to be in exponential time to
    //find all possible values

    //Space Complexity: O(m)
    //Explanation: Our call stack only includes the length of one path of
    //our entire recursion tree that we form with this method.
    static HashMap<String, List<List<String>>> map = new HashMap<>();
    public static List<List<String>> allConstruct_DP(String target, String[] wordBank){
        if(map.containsKey(target)) return map.get(target);
        if(target.equals("")) return new ArrayList<>(Arrays.asList(new ArrayList<String>()));

        List<List<String>> result = new ArrayList<>();

        for(String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());

                List<List<String>> suffixWays = allConstruct_DP(suffix, wordBank);
                List<List<String>> targetWays = new ArrayList<>();
                for (int i = 0; i < suffixWays.size(); i++) {
                    List<String> temp = new ArrayList<>(suffixWays.get(i));
                    temp.add(0, word);
                    targetWays.add(temp);
                }
                for(int i = 0; i < targetWays.size(); i++){
                    result.add(new ArrayList<>(targetWays.get(i)));
                }
            }
        }
        map.put(target, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
        System.out.println(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}));
        System.out.println(allConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(allConstruct_DP("eeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeeee", "eeeeeeee", "eeeeeee"}));
    }
}
