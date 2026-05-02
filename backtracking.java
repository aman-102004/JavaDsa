public class backtracking{
    public static void printarray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void changearr(int arr[],int i,int v){
        //base case
        if(i==arr.length){
            printarray(arr);
            return;

        }

        //recursion part
        arr[i]=v;
        changearr(arr, i+1, v+1);//function call step
        arr[i]=arr[i]-2;//backtracking step
        

    }

    public static void main(String[] args) {
        int arr[]=new int[5];
        changearr(arr, 0, 1);
        System.out.println();
        printarray(arr);
    }
}
    

