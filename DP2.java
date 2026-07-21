import java.util.*;
public class DP2 {
    public static int ClimbingStairsRecursion(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        return ClimbingStairsRecursion(n-1)+ClimbingStairsRecursion(n-2);
    }

    //after dp=O(n)  before dp=O(2^n)
    public static int ClimbingStairsMemoization(int n,int ways[]){
        if(n==0){
            return 1;
        }

        if(n<0){
            return 0;
        }

        if(ways[n]!=-1){
            return ways[n];
        }

        ways[n]=ClimbingStairsMemoization(n-1, ways)+ClimbingStairsMemoization(n-2, ways);
        return ways[n];
    }

    public static int ClimbingStairsTabulation(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i]=dp[i-1];
            }else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[n];

    }

    public static int KnapsackRecursion(int val[],int wt[],int W,int n){

        if(W==0 || n==0){
            return 0;

        }
        if(wt[n-1]<=W){//valid condn
            //include
            int ans1=val[n-1]+KnapsackRecursion(val,wt,W-wt[n-1],n-1);
            
            //exclude

            int ans2=KnapsackRecursion(val,wt,W,n-1);
            
            return Math.max(ans1,ans2);
        }else{
            return KnapsackRecursion(val,wt,W,n-1);
        }

    }

    public static int KnapsackMemoization(int val[],int wt[],int W,int n,int dp[][]){
        //here we will be creating a 2d array for memozation
        //cause her 2 varibles are changing wt and n 
        //dp[i][j] means 0-i items are left and j capacity is left and we need to calculate and store the max profix at dp[i][j]

         if(W==0 || n==0){
            return 0;

        }

        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){//valid condn
            //include
            int ans1=val[n-1]+KnapsackMemoization(val,wt,W-wt[n-1],n-1,dp);
            
            //exclude

            int ans2=KnapsackMemoization(val,wt,W,n-1,dp);
            
            dp[n][W]=Math.max(ans1,ans2);
            return dp[n][W];
        }else{
            dp[n][W]=KnapsackMemoization(val,wt,W,n-1,dp);
            return dp[n][W];
        }

    }

    public static int KnapsackTabulation(int val[],int wt[],int W){
        int dp[][]=new int[val.length+1][W+1];

        //initialisation
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }

        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }


        //tabulation code
        for(int i=1;i<val.length+1;i++){
            for(int j=1;j<W+1;j++){
                int v=val[i-1];
                int w=wt[i-1];//ith item weight and value

                //valid condn
                if(w<=j){
                    int incProfit=v+dp[i-1][j-w];
                    int excProfit=dp[i-1][j];

                    dp[i][j]=Math.max(incProfit,excProfit);
                }else{//invalid cond
                    int excProfit=dp[i-1][j];
                    dp[i][j]=excProfit;

                }
            }

            

        }

        return dp[val.length][W];

        //dp[i][j] means what will be the max profit at i items and j max weight and store that at dp[i][j]
    }

    public static boolean targetSumSubsetTabulation(int arr[],int sum){
        boolean dp[][]=new boolean[arr.length+1][sum+1];
        //items;
        //j=sum;
        //meaning of dp[i][j]=is there any subset in i items whose sum is equal to target sum
        //one more base condition when items are 0 and sum=x but we ar not initialising it as java by default assigns false values to all the cells

        for(int i=0;i<arr.length+1;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<sum+1;j++){
                //include
                int v=arr[i-1];
                if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j]=true;
                }
                //exclude
                else if(dp[i-1][j]==true){
                    dp[i][j]=true;
                }
            }
        }

        return dp[arr.length][sum];

    }
    public static void main(String[] args) {
        //ClIMBING STAIRS
        // System.out.println(ClimbingStairsRecursion(5));
        // int n=5;
        // int ways[]=new int[n+1];
        // Arrays.fill(ways,-1);
        // System.out.println(ClimbingStairsMemoization(n, ways));

        // System.out.println(ClimbingStairsTabulation(n));


        //0/1 Knapsack
        // int val[]={15,14,10,45,30};
        // int wt[]={2,5,1,3,4};
        // int W=7;

        // System.out.println(KnapsackRecursion(val, wt, W, val.length));

        // //we have taken wt+1 and val+1 cause we need to store the base case also and that is extra in that so we need extra space for storing that data

        // int dp[][]=new int[val.length+1][W+1];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // System.out.println(KnapsackMemoization(val, wt, W,val.length,dp));


        // //for tabulation
        // //create a table
        // //understand the meaning of the table and initialise it with base cases
        // //now fill the table from small to large

        // System.out.println(KnapsackTabulation(val, wt, W));





        //Target Sum
        int arr[]={4,2,7,1,3};
        int sum=10;
        System.out.println(targetSumSubsetTabulation(arr, sum));


    }
}
