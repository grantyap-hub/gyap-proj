package CTCI;

public class P1_5{

    //idea: first check length is >= 1
    //then check each character, if more than one is different reject


    static boolean oneAway(String str1, String str2){
        if(str1.length() == str2.length()){
            return oneEditReplace(str1,str2);
        } else if (str1.length() + 1 == str2.length()){
            return oneEditInsert(str1,str2);
        } else if (str1.length() - 1 == str2.length()){
            return oneEditInsert(str2,str1);
        }
        return false;
    }

    static boolean oneEditReplace(String s1, String s2){
        boolean foundDifference = false;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(foundDifference){
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    static boolean oneEditInsert(String s1, String s2){
        int index1 = 0;
        int index2 = 0;
        while(index2 < s2.length() && index1 < s1.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(index1 != index2)
                    return false;
                index2++;
            } else{
                index1++;
                index2++;
            }
        }
        return true;
    }

    static boolean oneEditAway(String first, String second){
        //Length checks
        if (Math.abs(first.length() - second.length()) > 1){
            return false;
        }

        //get shorter string
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() > second.length() ? second : first;


        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()){
            if (s1.charAt(index1) != s2.charAt(index2)){
                //ensure this is first difference found
                if (foundDifference) return false;
                foundDifference = true;

                //on replace move shorter pointer
                if(s1.length() == s2.length()){
                    index1++;
                }
            } else{
                index1++; //if matching move shorter pointer
            }
            index2++; //always move longer pointer
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println(oneEditAway("pale", "ple"));
    }

}

