package DP;

public class canConstructTab {

    public static boolean canConstruct(String target, String[] wordBank){
        boolean[] table = new boolean[target.length() + 1];
        table[0] = true;

        for(int i = 0; i <= target.length(); i++){
            if(table[i]){
                for(String word : wordBank){
                    //look for specific characters that match our wordBank word and make sure
                    //it isn't out of bounds
                    if(i + word.length() < table.length && target.substring(i, i + word.length()).equals(word)){
                        table[i + word.length()] = true;
                    }
                }
            }
        }

        return table[target.length()];
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("", new String[]{"bo", "rd", "ate"}));
        System.out.println(canConstruct("abcdef", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeeee", "eeeeeeee", "eeeeeee"}));
    }
}
