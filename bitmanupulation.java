import java.util.*;
public class bitmanupulation {

    public static void oddoreven(int n) {
        int bitmask=1;
        if((n&bitmask)==0){
            System.out.println("Even Number");
        }
        else{
            System.out.println("Number is Odd");
        }

    }

    public static int getIthbit(int n,int i){
        int bitmask=1<<i;

        if((n&bitmask)==0){
            return 0;

        }
        else{
            return 1;
        }

    }

    public static int setIthbit(int n,int i){
        int bitmass=1<<i;
        return n | bitmass;
    } 

    public static int clearIthbit(int n,int i){
        int bitmass= ~(1<<i);
        return n & bitmass;
    } 

    public static int updateIthbit(int n, int i,int newbit){
        // if(newbit==0){
        //     return clearIthbit(n, newbit);
        // }
        // else{
        //     return setIthbit(n, i);
        // }

        n=clearIthbit(n,i);
        int bitmass=newbit<<i;
        return n|bitmass;
    }

    public static int clearIBits(int n,int i){
        int bitmass=(~0)<<i;
        return n&bitmass;
    }
    public static void main(String[] args) {
        // oddoreven(3);

        System.out.println(clearIBits(15,2));
        
    }
    
}
