public class Recursion{

    public static void PrintReverse(int n){
        
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        PrintReverse(n-1);


    }

    public static void PrintNum(int n){
        
        if(n==1){
            System.out.print(n);
            return;
        }

        PrintNum(n-1);
        System.out.print(n+" ");
        


    }

    public static int Factorial(int n){

        if(n==0){
            return 1;
        }
        return n*Factorial(n-1);
    }

    public static int Sum(int n){

        if(n<0){
            return -1;
        }
        if(n==0){
            return 0;
        }
        return n+Sum(n-1);
    }

    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        int fnm1=fib(n-1);
        int fnm2=fib(n-2);
        int fn=fnm1+fnm2;
        return fn;
    }

    public static boolean isSorted(int arr[],int i){//i is the starting index from where we need to check
        if(i==arr.length-1){
            return true;
        }
        
        if(arr[i]>arr[i+1]){
            return false;
        }
        
        return isSorted(arr, i+1);
    }

    public static int FirstOccurence(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        
        if(arr[i]==key){
            return i;
        }
        else{
            return FirstOccurence(arr,key,i+1);
            
        }

    }

    public static int LastOccurence(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        int isFound=LastOccurence(arr, key, i+1);
        if(isFound==-1 && arr[i]==key){
            return i;
        }

        return isFound;

        

        
    }

    public static int Powx(int x,int n){
        if(n==0){
            return 1;
        }
        return x * Powx(x,n-1);
    }

    public static int OptimisedPowx(int x,int n){
       
        if(n==0){
            return 1;
        }
        int half=OptimisedPowx(x, n/2);
        int halfpowersq=half*half;
        
       if(n%2!=0){
        halfpowersq=x*halfpowersq;
       }
       return halfpowersq;
    }
    public static void main(String[] args) {
        // int n=6;
        // // PrintReverse(n);
        // // PrintNum(n);
        // System.out.println(Factorial(n));
        // int n=5;
        // System.out.println(Sum(n));

        // int n=5;
        // System.out.println(fib(n));

        // int arr[]={1,2,8,4,5};
        // // System.out.println(isSorted(arr, 0));
        // System.out.println(FirstOccurence(arr, 8, 0));

        // int arr[]={1,2,3,2,6,8,2};
        // System.out.println(LastOccurence(arr, 2, 0));

        int x=2;
        int n=6;
        // System.out.println(Powx(x, n));
        System.out.println(OptimisedPowx(x, n));
    }
}