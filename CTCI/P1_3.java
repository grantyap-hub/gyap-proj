package CTCI;



public class P1_3{
    public static String replaceSpace(char[] str, int trueLength){
        int countSpaces = 0, index;
        for(int i = 0; i < trueLength; i++){
            if(str[i] == ' '){
                countSpaces++;
            }
        }

        index = trueLength + countSpaces*2;
        for(int i = trueLength-1; i >=0; i--){
            if(str[i] == ' '){
                str[index-1] = '0';
                str[index-2] = '2';
                str[index-3] = '%';
                index-=3;
            }
            else{
                str[index-1] = str[i];
                index-=1;
            }
        }
        return (new String(str));
    }

    public static void main(String args[]){
        System.out.println(replaceSpace("Mr John Smith    ".toCharArray(), 13));
    }


}
