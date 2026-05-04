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

    public static boolean isSafe(char board[][],int row,int col){
        //vertical up
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        //diag left up
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //diag right up
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }


    // public static void nQueens(char board[][],int row){
    //     if(row==board.length){
    //         // printboard(board);
    //         count++;
    //         return;
    //         }

    //     for(int j=0;j<board.length;j++){
    //         if(isSafe(board,row,j)){
    //             board[row][j]='Q';
    //             nQueens(board, row+1);
    //             board[row][j]='x';

    //         }
            
    //     }

    // }
    public static boolean nQueens(char board[][],int row){
        if(row==board.length){
            // printboard(board);
            count++;
            return true;
            }

        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                if(nQueens(board, row+1)){
                    return true;
                };
                board[row][j]='x';

            }
            
        }
        return false;

    }

    static int count=0; 
    public static void printboard(char board[][]){
        System.out.println("---------chess board--------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // // int arr[]=new int[5];
        // // changearr(arr, 0, 1);
        // // System.out.println();
        // // printarray(arr);

        // String str="abc";
        // // findSubsets(str, "", 0);
        // findpermutation(str, "");

        int n=4;
        char board[][]=new char[n][n];
        //initialise
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='x';
            }
        }

        // nQueens(board,0);
        // System.out.println("Total ways to solve n queens is:"+ count);
        

        if(nQueens(board, 0)){
            System.out.println("Solution is possible");
            printboard(board);
        }else{
            System.out.println("Solution is not possible");
        }
    
    
    }
}
    

