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
        int bitmass=(~0)<<i;//~0==-1
        return n&bitmass;
    }

    public static int clearBitsinRange(int n,int i,int j){
        int a=((~0)<<(j+1));
        int b=(1<<i)-1;//1<<b=2^b (pattern used for no of one in the right hand side)
        int bitmass=a | b;
        return n&bitmass;
    }

    public static boolean powerof2(int n){
        return (n & (n-1))==0;
    }

    public static int countbits(int n){

        int count=0;
        while(n>0){
            if((n&1)!=0){//checked LSB
                count++;
            }
            n=n>>1;
        }
        return count;
    }

    public static int fastExpo(int a,int n){
        int ans=1;

        while(n>0){
            if((n&1)!=0){//check LSB
                ans=ans*a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        // oddoreven(3);

        System.out.println(fastExpo(5, 3));
        
    }
    
}
