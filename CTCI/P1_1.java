package CTCI;

import java.util.ArrayList;
public class P1_1{

    //worse solution since we add() has to create a
    //new array every time, much slower
    public static Boolean is_unique(String str){
        ArrayList<Character> checker = new ArrayList<Character>();
        for (int i = 0; i < str.length(); i++){
            if(!checker.contains(str.charAt(i))){
                checker.add(str.charAt(i));
            }
            else{
                return false;
            }
        }
        return true;

    }

    //optimal time complexity of O(n) and space O(1)
    //since we have a fixed array
    public static boolean isUniqueChars(String str){
        //assuming ascii string we can't have
        //a unique string greater than 128
        if(str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i);
            //abuses every character as an index
            //if seen before its not unique
            if(char_set[val]){
                return false;
            }
            //always give a character a value of true
            //otherwise it is null
            char_set[val] = true;
        }
        return true;
    }

    //without additional data structures we would
    //need to compare every character to every other character
    //O(n^2) time and space O(1)

    //assuming we can modify string, we would sort
    //with a best O(nlogn) time but larger space.



    public static void main(String args[]){
        System.out.println(isUniqueChars("hih"));
    }
}


