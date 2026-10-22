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

    
    public static void main(String[] args) {
        
    }
}