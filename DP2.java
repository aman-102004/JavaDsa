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
    public static void main(String[] args) {
        //ClIMBING STAIRS
        System.out.println(ClimbingStairsRecursion(5));
        int n=5;
        int ways[]=new int[n+1];
        Arrays.fill(ways,-1);
        System.out.println(ClimbingStairsMemoization(n, ways));

    }
}
