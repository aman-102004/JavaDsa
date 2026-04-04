import java.util.*;
public class Strings {

    public static void main(String[] args) {
        char arr[]={'a','b','c','d'};
        String str="abcd";
        String str2=new String("xyz");

        //Strings in java are IMMUTABLE;

        Scanner sc=new Scanner(System.in);
        
        String name;
        name=sc.nextLine();//we can use next also but it does not include words after space and only include a single word 
        System.out.println(name);
    }
    
}
