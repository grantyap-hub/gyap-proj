package DP;

import java.util.*;

public class allConstructTab {


    //m = target.length
    //n = wordBank.length

    //Time Complexity: O(n^m)
    //Explanation: For every word in the word bank, we need to
    //look over the target length each time to check our specific phrase. Slight
    //improvement from recursion as we still need to be in exponential time to
    //find all possible values

    //Space Complexity: O(n^m)
    //Explanation: Our call stack needs to include holding a table with each of our
    //possible combinations of words in our wordbank to make up our target value, this
    //means that our total space complexity would be roughly the same as our time.
    public static List<List<String>> allConstruct(String target, String[] wordBank){
        List<List<String>>[] table = new ArrayList[target.length() + 1];
        for(int i = 0; i < table.length; i++){
            table[i] = new ArrayList<>();
        }
        table[0] = new ArrayList<>(Arrays.asList(new ArrayList<String>()));
        for(int i = 0; i < table.length; i++){
            for(String word : wordBank){
                if(i + word.length() < table.length && target.substring(i).indexOf(word) == 0){
                    List<List<String>> newCombinations = new ArrayList<>();

                    for(List<String> subArray : table[i]){
                        List<String> temp = new ArrayList<>(subArray);
                        temp.add(word);
                        newCombinations.add(temp);
                    }
                    for(List<String> subArray : newCombinations){
                        table[i + word.length()].add(new ArrayList<>(subArray));
                    }
                }
            }
        }
        return table[target.length()];
    }



    public static void main(String[] args) {
        System.out.println(allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
        System.out.println(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}));
        System.out.println(allConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(allConstruct("eeeeeeeeeee",
                new String[]{"e", "ee", "eee", "eeee", "eeeeee", "eeeeeeee", "eeeeeee"}));
    }
}
