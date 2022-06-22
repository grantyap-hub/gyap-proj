package CTCI;


public class P1_4{
    //3 Given Solutions, couldn't solve this on my won
    //1 - HashTable implementation
    //2 - Checking as we go in one loop of char arrays
    //3 - bit vectors
    //
    //I prefer the 2nd solution since it was my train of thought,
    //but implementing a hashtable solution would be good practice
    //For now, here is 2.

    public static int getCharNumber(Character c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z){
            return val - a;
        }
        return -1;
    }

    public static boolean isPermutationOfPalindrome(String phrase){
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') -
                Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()){
            int x = getCharNumber(c);
            if (x != -1){
                table[x]++;
                if(table[x] % 2 == 1){
                    countOdd++;
                } else{
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }





    public static void main(String args[]){
        System.out.println(isPermutationOfPalindrome("Tact Coa"));
    }

}
