import java.util.*;
public class functions {

    public static int factorial(int n){
        int fact=1;
        for(int i=1;i<=n;i++){
            fact=fact*i;

        }
        return fact;
    }
    public static void main(Strings[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter A Number:");
        int num=sc.nextInt();
        int fact=factorial(num);
        System.out.println("Factorial of:"+num +" is "+fact);
    }
    
}
 