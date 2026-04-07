import java.util.*;

import javax.sound.sampled.SourceDataLine;
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

    public static String substring(String str,int si,int ei){
        String Substr="";
        for(int i=si;i<ei;i++){
            Substr+=str.charAt(i);
        }
        return Substr;

    }

    public static String toUpperCase(String str){
        StringBuilder sb=new StringBuilder("");
        char ch=Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' ' &&i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }

        }
        return sb.toString();
    }

    public static String StringCompression(String str){
        StringBuilder sb=new StringBuilder("");

        for(int i=0;i<str.length();i++){
            Integer count=1;

            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;

            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count);
            }
            
        }
        return sb.toString();
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

        // String direction="WNEENESENNN";
        // System.out.println(distancefromorigin(direction));

        //we can use str.equals(str3) to compare values of two strings because == fails in case of strings when declared using new keyword
        
        // String str ="HelloWorld";
        // System.out.println(substring(str, 0, 4));
        // //there exists an susbstring function str.substring(si,ei);
        // }

        //for printing the largest string among all we use str1.compareTo(str2) returns values 0,-1 and +1 we can use compareTo to avoid the problem of capital and small alphabets
        // String fruits[]={"apple","mango","banana"};
        // String Largest=fruits[0];
        // for(int i=1;i<fruits.length;i++){
        //     if(Largest.compareTo(fruits[i])<0){
        //         Largest=fruits[i];
        //     }

        // }
        // System.out.println(Largest);

        // String str="hi, i am aman";
        // System.out.println(toUpperCase(str));

        String str="aaabbbcccc";
        System.out.println(StringCompression(str));

}
}