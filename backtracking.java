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

    public static int gridWays(int i,int j,int n,int m){
        if(i==n-1 && j==m-1){
            return 1;
        }else if(i==n || j==n){
            return 0;
        }

        
        int w1=gridWays(i+1, j, n, m);
        int w2=gridWays(i,j+1,n,m); 

        return w1+w2;
    }

    public static boolean issafe(int sudoku[][],int row,int col,int digit){
        //col condiiton

        for(int i=0;i<=8;i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }

        //row condtition

        for(int j=0;j<=8;j++){
            if(sudoku[row][j]==digit){
                return false;
            }
        }

        //grid condition

        int sr=(row/3)*3;
        int sc=(col/3)*3;

        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }

        return true;


    }

    public static boolean sudokusolver(int sudoku[][],int row,int col){
        
        if(row==9){
            return true;
        }


        int nextrow=row,nextcol=col+1;
        if(col+1==9){
                nextrow=row+1;
                nextcol=0;
        }

        if(sudoku[row][col]!=0){
            return sudokusolver(sudoku, nextrow, nextcol);
        }

        
        
        
        for(int digit=1;digit<=9;digit++){
                if(issafe(sudoku,row,col,digit)){
                sudoku[row][col]=digit;
                if(sudokusolver(sudoku,nextrow, nextcol)){
                    return true;
                }
                sudoku[row][col]=0;

            }

        }

        return false;
    }

    public static void printsudoku(int sudoku[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
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

        // int n=4;
        // char board[][]=new char[n][n];
        // //initialise
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         board[i][j]='x';
        //     }
        // }

        // // nQueens(board,0);
        // // System.out.println("Total ways to solve n queens is:"+ count);
        

        // if(nQueens(board, 0)){
        //     System.out.println("Solution is possible");
        //     printboard(board);
        // }else{
        //     System.out.println("Solution is not possible");
        // }
    
        // int n=3,m=3;
        // System.out.println(gridWays(0, 0, n, m));

        int[][] sudoku = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},

            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},

            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };
    
        if(sudokusolver(sudoku, 0,0)){
            System.out.println("Solution Exists");
            printsudoku(sudoku);
        }
        else{
            System.out.println("Solution does not exist");
        }
    }
}
    

