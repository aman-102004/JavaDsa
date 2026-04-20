public class Recursion{

    public static void PrintReverse(int n){
        
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        PrintReverse(n-1);


    }
    public static void main(String[] args) {
        int n=10;
        PrintReverse(n);
    }
}