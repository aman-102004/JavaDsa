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

    public static void findSubsets(String str,String ans,int i){
        //base case
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }

        //recursion
        //yes
        findSubsets(str, ans+str.charAt(i), i+1);
        //no
        findSubsets(str, ans, i+1);


    }

    public static void findpermutation(String str,String ans){
        //base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //recursion
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);

            String Newstr=str.substring(0,i)+str.substring(i+1);
            findpermutation(Newstr, ans+curr);

        }
    }
    public static void main(String[] args) {
        // int arr[]=new int[5];
        // changearr(arr, 0, 1);
        // System.out.println();
        // printarray(arr);

        String str="abc";
        // findSubsets(str, "", 0);
        findpermutation(str, "");
    }
}
    

