public class DP3 {

    //leetcode question-
    //486
    // public boolean predictTheWinner(int[] nums) {
    //     int i=0;
    //     int j=nums.length-1;
    //     int dp[][]=new int[nums.length][nums.length];
    //     for(int k=0;k<nums.length;k++){
    //         for(int l=0;l<nums.length;l++){
    //             dp[k][l]=-1;
    //         }
    //     }
    //     int ans=solve(i,j,nums,dp);

    //     if(ans>=0){
    //         return true;
    //     }else{
    //         return false;
    //     }

    // }
    // public static int solve(int i,int j,int nums[],int dp[][]){
    //     if(i==j){
    //         return dp[i][j] = nums[i];
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int left=nums[i]-solve(i+1,j,nums,dp);

    //     int right=nums[j]-solve(i,j-1,nums,dp);

    //     dp[i][j]=Math.max(left,right);
    //     return dp[i][j];
    // }

    public static int convertString(String s1,String s2){
        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n+1][m+1];
        //initialisation
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                if(j==0){
                    dp[i][j]=i;
                }
            }
        }

        //bottom up step
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    int add=dp[i][j-1]+1;
                    int del=dp[i-1][j]+1;
                    int rep=dp[i-1][j-1]+1;

                    dp[i][j]=Math.min(add,Math.min(del,rep));
                }
            }
        }
        return dp[n][m];

    }
    public static void main(String[] args) {
        //CONVERTING STRING 1 TO 2 
        //3 operations possible insert,remove,replace for each opeation cost is 1
        //find min cost

        // String s1="intention";
        // String s2="execution";
        // System.out.println(convertString(s1, s2));

        String s3="aman";
        String s4="naman";

        
        System.out.println(convertString(s3,s4));


    }
}
