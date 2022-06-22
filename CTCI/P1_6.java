package CTCI;

public class P1_6{


    //check if next character is different than last
    //if not then add count and increment pointer
    //if yes then set count to 1 and increment pointer
    //have a new string to append
    //ends up being inefficient since string concatenation is O(n^2)
    //therefore this comes to be O(p + c^2) where
    //p is size of string and c is character concatentation.

    static String compress(String str){
        if(str.length() < 1)
            return str;

        int count = 1;
        char[] temp = str.toCharArray();
        String output = Character.toString(temp[0]);

        for(int i = 1; i < temp.length; i++){
            if(temp[i] != temp[i-1]){
                output = output + String.valueOf(count) + Character.toString(temp[i]);
                count = 1;
            }
            else if(temp[i] == temp[i-1] && i == temp.length-1){
                output += String.valueOf(++count);
            }
            else{
                count++;
            }

        }
        if(temp[temp.length-1] != temp[temp.length-2]){
            output += String.valueOf(count);
        }

        return output;
    }

    //CTCI Solution
    //Optimal short solution simply uses a stringbuilder to append


    static String compress1(String str){
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for(int i = 0; i < str.length(); i++){
            countConsecutive++;

            //eloquent way of checking each character is different
            //since it checks up to last character also didn't need to
            //make a char array

            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)){
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        //returns whichever is smaller
        return compressed.length() < str.length() ? compressed.toString() : str;

    }





    public static void main(String args[]){
        System.out.println(compress1("AaBbCcsdfboweewboidc"));

    }

}
