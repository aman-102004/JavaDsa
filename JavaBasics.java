import java.util.*;
public class JavaBasics{
    public static void main(Strings args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter A Number:");
        int num=sc.nextInt();
        boolean isPrime=true;

        if(num==2){
            System.out.println("Number is Prime");
        }

        for(int i=2;i<Math.sqrt(num);i++){

            if(num%i==0){
                isPrime=false;
            }
            
        }
        if (isPrime==true) {
            System.out.println(num+" is Prime");
            
        }

        else{
            System.out.println(num+" is not Prime");
        }
        

       

    }
}