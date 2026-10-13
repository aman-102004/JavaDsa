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

    public static void main(String[] args) {
        
    }
}