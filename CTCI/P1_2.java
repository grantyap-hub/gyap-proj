package CTCI;

import java.util.Arrays;

public class P1_2{

    //A string is a permutation of another when every
    //character of one string is seen in the other string


    //Idea: Create an arraylist that stores every character
    //of one string. Then check with .contains for every character
    //in string 2.
    //
    //Time complexity of O(N + M) Assuming n is length of str1
    //and m is length of str2.
    //
    //
    //Going with unoptimal solution
    //with time O(nlogn) since we're sorting
    public static boolean checkPermutation(String str1, String str2){
        if(str1.length() != str2.length()) return false;

        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);

        //for(int i = 0; i < char1.length; i++){
        //	if(char1[i] != char2[i])
        //		return false;
        //}
        //return true;
        //instead write this
        return (new String(char1)).equals(new String(char2));

    }

    //it works gj! not most optimal way to write though.
    //Can show more modularity this way.

    public static String sort(String s){
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public static boolean permutation(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        return sort(s).equals(sort(t));
    }

    //Additionally, this has a faster time complexity:
    public static boolean l_permutation(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int[] letters = new int[128];

        char[] s_array = s.toCharArray();
        for(char c : s_array){
            letters[c]++;
        }

        for(int i = 0; i < t.length(); i++){
            int c = (int) t.charAt(i);
            letters[c]--;
            if(letters[c] < 0)
                return false;
        }

        return true;

    }






    public static void main(String args[]){
        System.out.println(l_permutation("hih", "hhi"));

    }





}

