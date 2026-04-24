public class Recursion2 {

    public static int tilingProblem(int n){//2 x n is the size of the floor
        //work
        //first vertical choice
        
        if(n==0 || n==1){
            return 1;
        }
        
        int fnm1=tilingProblem(n-1);

        //horizonatal choide
        int fnm2=tilingProblem(n-2);

        int totalways=fnm1+fnm2;

        return totalways;
    }

    public static void RemoveDuplicates(String str,int idx,StringBuilder sb,boolean map[]){
        if(idx==str.length()){
            System.out.println(sb);
            return;
        }
        char currchar=str.charAt(idx);
        if(map[currchar-'a']==true){
            RemoveDuplicates(str,idx+1,sb,map);
        }
        else{
            map[currchar-'a']=true;
            RemoveDuplicates(str, idx+1, sb.append(currchar), map);
        }
    }

    public static int friendspairing (int n){

        if(n==1 || n==2){
            return n;
        }
        //choice

        //1st choice remain single
        int fnm1=friendspairing(n-1);

        //2nd choice make a pairs

        int fnm2=friendspairing(n-2)*(n-1);

        return fnm1+fnm2;
    }

    public static void BinaryStrings(int n,int lastplace,String str){

        if(n==0){
            System.out.println(str);
            return;
        }

        BinaryStrings(n-1,0, str+"0");
        if(lastplace==0){
            BinaryStrings(n-1,1, str+"1");
        }
    }

    public static void Occurences(int arr[],int key,int startindex){

        if(startindex==arr.length){
            return;
        }
        // int current=arr[startindex];
        // if(current==key){
        //     System.out.println(startindex);
        //     Occurences(arr, key, startindex+1);
        // }
        // else{
        // Occurences(arr, key, startindex+1);

        if(arr[startindex]==key){
            System.out.println(startindex+" ");
        }
        Occurences(arr, key, startindex+1);
        }
    
    static String digits[]={"zero","one","two","three","four","five","six","seven","eight","nine"};

    public static void printdigits(int n){
        if(n==0){
            return;
        }
        int lastdigit=n%10;
        printdigits(n/10);
        System.out.print(digits[lastdigit]+" ");
    }

    public static void towerOfHanoi(int n, String src, String helper, String dest) {

        if (n == 1) {
            System.out.println("Transfer disk 1 from " + src + " to " + dest);
            return;
        }

        // Step 1: move n-1 disks from src to helper
        towerOfHanoi(n - 1, src, dest, helper);

        // Step 2: move nth disk
        System.out.println("Transfer disk " + n + " from " + src + " to " + dest);

        // Step 3: move n-1 from helper to dest
        towerOfHanoi(n - 1, helper, src, dest);
    }

    public static void main(String[] args) {
        // System.out.println(tilingProblem(3));

        // String str="aapnaaaacollegge";
        // RemoveDuplicates(str,0,new StringBuilder(""),new boolean [26]);

        // System.out.println(friendspairing(5));
        // BinaryStrings(3, 0,"");

        // int arr[]={1,2,3,2,6,3,2,2,5,2};
        // Occurences(arr, 2, 0);

        // printdigits(2013);

        towerOfHanoi(3,"A","B","C");

    }

    
}
