public class DP {
    public static int FibMemoization(int n,int f[]){
        if(n==0 || n==1){
            return n;
        }
        if(f[n]!=0){
            return f[n];
        }
        f[n]=FibMemoization(n-1,f)+FibMemoization(n-2,f);
        return f[n];

    }

    public static int FibTabulaion(int n){
        int dp[]=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];

    }
    public static void main(String[] args) {
        int n=5;
        int f[]=new int[n+1];
        System.out.println(FibMemoization(n, f));
        System.out.println(FibTabulaion(n));
    }
}

//DP is advanced recursion
//Dp is way of optimising those problems who demads a optiomal solution and have choices(eg fabonacci)
//two ways of dp=Memoization(Top down)and Tabulation(Bottom up)
//Memoization-dp using recursion - write normal recursion and store the subprblems to use it whenever we need it again (basically recursion+storing)
//Tabulation-dp using loops-(a little difficult then memoization)-create and initlise a dp array(table), memorise what does table store ,fill the values from small to large