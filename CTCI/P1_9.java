package CTCI;

public class P1_9 {

    public static boolean isrotation(String s1, String s2){
        int len = s1.length();
        if(len == s2.length() && len > 0){
            String s1s1 = s1 + s1;
            return s1s1.contains(s2);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isrotation("waterbottle", "erbottlewa"));
    }
}
