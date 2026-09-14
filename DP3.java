import java.util.*;
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

    //lc44
    public static boolean WildCardMatch(String s,String p){
        int n=s.length();
        int m=p.length();

        boolean dp[][]=new boolean[n+1][m+1];

        //dp array means -if we take string of length n and other strring of length p will they match basically breaking into smaller problems
        
        //initialise

        //case 1
        dp[0][0]=true;

        //case2
        //pattern empty
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;
        }

        //case 3 
        //String s is empty

        for(int j=1;j<m+1;j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j]=dp[0][j-1];
            }   
        }

        //dp solution

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //case 1
                //ith char==jth char || jth char=='?'
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];

                }else{
                    dp[i][j]=false;
                }
            }
        }

        return dp[n][m];
    }

    public static int catalanNum(int n){
        if(n==0 || n==1){
            return 1;
        }

        int ans=0;
        for(int i=0;i<n;i++){
            ans+=catalanNum(i)*catalanNum(n-i-1);
        }

        return ans;

    }

    public static int catalanNumMemo(int n,int dp[]){
        if(n==0 || n==1){
            return 1;
        }

        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=ans+catalanNumMemo(i,dp)*catalanNumMemo(n-i-1,dp);
        }

       

        return dp[n]=ans;

    }

    public static int catalanNumTabu(int n){
        //dp[i]==ith catalan num

        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];//ci=cj*Ci-j-i;
            }

        }

        return dp[n];

    }

    public static int countBST(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                int left=dp[j];
                int right=dp[i-j-1];
                dp[i]+=left*right;
            }
        }

        return dp[n];
    }

    public static int mountainranges(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                int inside=dp[j];
                int outside=dp[i-j-1];
                dp[i]+=inside*outside;
            }
        }

        return dp[n];
    }

    //lc368
     public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        @SuppressWarnings("unchecked")
        ArrayList<Integer> dp[]=new ArrayList[nums.length];

        for(int i=0;i<nums.length;i++){
            dp[i]=new ArrayList<>();
            dp[i].add(nums[i]);

            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[j].size()+1>dp[i].size()){
                    dp[i]=new ArrayList<>(dp[j]);
                    dp[i].add(nums[i]);
                }
            }
        }

        ArrayList<Integer> ans=dp[0];

        for(int i=1;i<dp.length;i++){
            if(dp[i].size()>ans.size()){
                ans=dp[i];
            }
        }

        return ans;
    }

    public static int MCM(int arr[],int start,int end){//we will be taking another varible inside a loop to make a cut and divide the matrices into number of small problems
        
        if(start==end){
            return 0;//single matrix case
        }

        //basic matrix understanding
        
        // axb * c*d = a*d;(onlt possible if b==c)
        //total operations=a * b *d;(b = c so we can take anyone)

        int ans=Integer.MAX_VALUE;

        for(int k=start;k<=end-1;k++){
            //k=the part from where we gonna divide the matrix into two parts
            int cost1=MCM(arr,start,k);//Ai......Ak=arr[i-1]*arr[k];
            int cost2=MCM(arr,k+1,end);//Ak+1.....A=arr[k]*arr[end];
            
            int cost3=arr[start-1]*arr[k]*arr[end];//cost of multiplication of two matrix is explained above

            ans=Math.min(ans,cost1+cost2+cost3);
        }


        return ans;

    }
    public static void main(String[] args) {
        //CONVERTING STRING 1 TO 2 
        //3 operations possible insert,remove,replace for each opeation cost is 1
        //find min cost

        // String s1="intention";
        // String s2="execution";
        // System.out.println(convertString(s1, s2));

        // String s3="aman";
        // String s4="naman";

        
        // System.out.println(convertString(s3,s4));




        //WildCard Matching
        // String s="baaabab";
        // String p="*****ba*****ab";
        // System.out.println(WildCardMatch(s, p));


        //catalan NUm
        //recursion
        //Similar type===== count BSTS and Mountain ranges
        // System.out.println(catalanNum(4));
        

        //memoization
        // int n=4;
        // int dp[]=new int[n+1];
        // Arrays.fill(dp,-1);


        // System.out.println(catalanNumMemo(n, dp));

        //Catalan Tabu
        // System.out.println(catalanNumTabu(n));

        // System.out.println(countBST(n));
        // System.out.println(mountainranges(n));


        //MATRIX CHAIN MULTIPLICATION

        int arr[]={1,2,3,4,3};
        System.out.println(MCM(arr,1,arr.length-1));



    }
}
