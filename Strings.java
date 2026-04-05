import java.util.*;
public class Strings {

    public static void printletters(String str){
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }
        System.out.println();
    }

    public static boolean checkPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                //not a palindrome 
                return false;
            }

        }
        return true;
    }

    public static float distancefromorigin(String str){
        int start=0;
        int end=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='N'){
                start++;
            }
            if(str.charAt(i)=='S'){
                start--;
            }
            if(str.charAt(i)=='E'){
                end++;

            }
            if(str.charAt(i)=='W'){
                end--;
            }

        }
        double distance=Math.sqrt(Math.pow(start,2)+Math.pow(end,2));
        return (float)distance;
    }
    public static void main(String[] args) {
        // char arr[]={'a','b','c','d'};
        // String str="abcd";
        // String str2=new String("xyz");

        // //Strings in java are IMMUTABLE;

        // Scanner sc=new Scanner(System.in);
        
        // String name;
        // name=sc.nextLine();//we can use next also but it does not include words after space and only include a single word 
        // System.out.println(name);

        // String fullname="Aman Vishwakarma";
        // System.out.println(fullname.length());

        //concatenation 
        // String firstname="Aman";
        // String Lastname="Vish";
        // String fullname=firstname+" "+Lastname;
        // // System.out.println(fullname.charAt(0));
        // printletters(fullname);

        // String str="aman";
        // System.out.println(checkPalindrome(str));;

        String direction="WNEENESENNN";
        System.out.println(distancefromorigin(direction));

        //we can use str.equals(str3) to compare values of two strings because == fails in case of strings when declared using new keyword
    }
    
}
