package DP;

public class countConstructTab {

    public static int countConstruct(String target, String[] wordBank){
        int[] table = new int[target.length()+1];
        table[0] = 1;

        for(int i = 0; i < table.length; i++){
            if(table[i] > 0){
                for(String word : wordBank){
                    if(i + word.length() < table.length && target.substring(i, i + word.length()).equals(word)){
                        table[i+word.length()] += table[i];
                    }
                }
            }
        }

        return table[target.length()];
    }



    public static void main(String[] args) {
        System.out.println(countConstruct("", new String[]{"bo", "rd", "ate"}));
        System.out.println(countConstruct("abcdef", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(countConstruct("skateboard", new String[]{"bo", "d", "ate", "te", "ska", "sk", "boar"}));
        System.out.println(countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeeee", "eeeeeeee", "eeeeeee"}));
    }
}
