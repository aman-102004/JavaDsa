public class TwoPointer{
    //lc3727
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=Math.abs(nums[i]);
        }

        Arrays.sort(nums);

        int left=0;
        int right=nums.length-1;
        int j=0;
        long ans=0;
        while(left<=right){
            if(j%2==0 ){
                ans+=nums[right]*nums[right];
                right--;

            }else{
                ans-=nums[left]*nums[left];
                left++;
            }
            j++;


        }

        return ans;
    }

    //lc2874
    public long maximumTripletValue(int[] nums) {
        int prefixmax[]=new int[nums.length];
        prefixmax[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefixmax[i]=Math.max(prefixmax[i-1],nums[i]);
        }

        int suffixmax[]=new int[nums.length];
        suffixmax[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            suffixmax[i]=Math.max(suffixmax[i+1],nums[i]);
        }

        long ans=0;

        for(int i=1;i<prefixmax.length-1;i++){
            long diff=prefixmax[i-1]-nums[i];
            long mul=diff*suffixmax[i+1];
            ans=Math.max(ans,mul);
        }

        return ans;
    }

    //lc611
    public int triangleNumber(int[] nums) {

        //approach used =fixing the biggest side after sorting
        //take two pointer
        //if codn satisfied all triangle in rangle j to k can be include as array is sorted then k--
        //else it means the sum is smaller then j++;
        Arrays.sort(nums);
        int count=0;
        for(int i=nums.length-1;i>=0;i--){
            int j=0;
            int k=i-1;

            while(j<k){
                if(nums[j]+nums[k]>nums[i]){
                    count+=k-j;
                    k--;
                }else{
                    j++;
                }
            }

        }

        return count;
    }


    //lc392
     public boolean isSubsequence(String s, String t) {

        //appraoch 1
        // int n=s.length();
        // int m=t.length();
        // int dp[][]=new int[n+1][m+1];

        // for(int i=1;i<n+1;i++){
        //     for(int j=1;j<m+1;j++){
        //         if(s.charAt(i-1)==t.charAt(j-1)){
        //             dp[i][j]=dp[i-1][j-1]+1;
        //         }else{
        //             int ans1=dp[i-1][j];
        //             int ans2=dp[i][j-1];
        //             dp[i][j]=Math.max(ans1,ans2);
        //         }
        //     }
        // }

        // return dp[n][m]==s.length()?true:false;


        //approach 2
        if(s.length()==0){
            return true;
        }else if(s.length()==1 && t.length()==1){
           return s.charAt(0)==t.charAt(0)?true:false;
        }

        


        int pointer1=0;
        int pointer2=0;

        while(pointer1<s.length() && pointer2<t.length()){
            if(s.charAt(pointer1)==t.charAt(pointer2)){
                pointer1++;
                pointer2++;
            }else{
                pointer2++;
            }
            if(pointer1==s.length()){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        
    }
}