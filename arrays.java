import java.util.*;

public class arrays {

    public static int linearSearch(int numbers[],int key){

        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==key){
                return i;

            }

        }
        return -1;

    }


    public static int LargestNum(int numbers[]){

        int largest = Integer.MIN_VALUE;//used to signify smallest value(- infinity)

        for (int i=0;i<numbers.length;i++){
            if(largest<numbers[i]){
                largest=numbers[i];

            }

        }
        return largest;

    }

    public static int Binarysearch(int numbers[],int key){
        int start=0;
        int end =numbers.length-1;
        while(start<=end){
            int mid =(start+end)/2;
            //comparasions
            if(numbers[mid]==key){
                return mid;
            }
            if(numbers[mid]<key){
                start=mid+1;
            }else{
                end=mid-1;
            }

        }
        return -1;
    }

    public static void RevArray(int numbers[]){
        int first=0,last=numbers.length-1;
        while(first<last){
            //swap
            int temp=numbers[last];
            numbers[last]=numbers[first];
            numbers[first]=temp;
            first++;
            last--;
        }
    }

    public static void pairs(int numbers[]){
        for(int i=0;i<numbers.length;i++){
            int curr=numbers[i];
            for(int j=i+1;j<numbers.length;j++){
                System.out.print("("+curr+","+numbers[j]+") ");
            }
            System.out.println();
        }
    }

    public static void printSubarrays(int numbers[]){
        for(int i=0;i<numbers.length;i++){
            int start=i;
            for(int j=i;j<numbers.length;j++){
                int sum =0;
                int end=j;
                for(int k=start;k<=end;k++ ){//this loop is used for printing
                    System.out.print(numbers[k]+" ");
                    sum=sum+numbers[k];
                }
                System.out.print(" Sum :"+ sum);
                System.out.println();

            }
            System.out.println();
        }
    }



    public static void SubarraySum(int numbers[]){
        int sum =0;
        int maxsum=Integer.MIN_VALUE;
         for(int i=0;i<numbers.length;i++){
            int start=i;
            for(int j=i;j<numbers.length;j++){
                
                
                int end=j;
                sum =0;
                for(int k=start;k<=end;k++ ){//this loop is used for printing
                    
                    sum=sum+numbers[k];
                    
                    
                }System.out.println(sum);

                if(sum>maxsum){
                    maxsum=sum;
                }
                
            }
            
        }
        System.out.println("Max Sum="+maxsum);
    }
  
    public static void SubarraySumOptimised(int numbers[]){//using prefixes
        int sum =0;
        int maxsum=Integer.MIN_VALUE;
        int prefix[]=new int[numbers.length];
        prefix[0]=numbers[0];
        //calculating prefix array
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+numbers[i];
        }

         for(int i=0;i<numbers.length;i++){
            int start=i;
            for(int j=i;j<numbers.length;j++){
                
                
                int end=j;
                sum =start==0?prefix[end]:prefix[end]-prefix[start-1];
                // for(int k=start;k<=end;k++ ){//this loop is used for printing
                    
                //     sum=sum+numbers[k];
                    
                    
                // }
                // System.out.println(sum);

                if(sum>maxsum){
                    maxsum=sum;
                }
                
            }
            
        }
        System.out.println("Max Sum="+maxsum);
    }

    public static void kadanes(int numbers[]){
        int ms=Integer.MIN_VALUE;
        int cs=0;

        for(int i=0;i<numbers.length;i++){
            cs=cs+numbers[i];
            if(cs<0){
                cs=0;
            }
            ms=Math.max(cs,ms);
        }
        System.out.println("our max Subarray sum is : "+ ms);
    }

    public static boolean duplicates(int numbers[]){
        for (int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]==numbers[j]){
                    return true;
                }
            }
        }
        return false;

        
    }

    //leetcode 3069
     public int[] resultArray(int[] nums) {
        int arr1[]=new int[nums.length];
        int arr2[]=new int[nums.length];

        int j=0;
        int k=0;
        arr1[j]=nums[0];
        arr2[k]=nums[1];
        j++;
        k++;

        for(int i=2;i<nums.length;i++){
            if(arr1[j-1]>arr2[k-1]){
                arr1[j]=nums[i];
                j++;
            }else{
                
                arr2[k]=nums[i];
                k++;
            }
        }

        int ans[]=new int[nums.length];

        int l=0;
        for(int i=0;i<j;i++){
            ans[l]=arr1[i];
            l++;
        }

        for(int i=0;i<k;i++){
            ans[l]=arr2[i];
            l++;
        }

        return ans;

        

        
    }

    public static int Gcd(int num1,int num2){
        while(num2!=0){
            int temp=num2;
            num2=num1%num2;
            num1=temp;

        }
        return num1;

    }

    public long gcdSum(int[] nums) {
        int max=0;
       
        

        int prefixGcd[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            prefixGcd[i]=Gcd(nums[i],max);
        }
        Arrays.sort(prefixGcd);
        
        int n1=0;
        int n2=prefixGcd.length-1;
        long sum=0;
        while(n1<n2){
            sum+=Gcd(prefixGcd[n1],prefixGcd[n2]);
            n1++;
            n2--;
        }

        return sum;

    }

    //lc 643
    public double findMaxAverage(int[] nums, int k) {

        int left = 0;
        int right = k;

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        
        while (right < nums.length) {

            sum = sum - nums[left] + nums[right];

            maxSum = Math.max(maxSum, sum);

            left++;
            right++;
        }

        return (double) maxSum / k;
    }


    //lc3903
     public int firstStableIndex(int[] nums, int k) {
        int prefixmax[]=new int[nums.length];
        int suffixmin[]=new int[nums.length];

        int max=0;
        for(int i=0;i<nums.length;i++){
            
            int currnum=nums[i];
            max=Math.max(max,currnum);
            prefixmax[i]=max;
        }

        int min=nums[nums.length-1];
        suffixmin[nums.length-1]=min;
        for(int i=nums.length-2;i>=0;i--){
            
            int currnum=nums[i];
            min=Math.min(min,currnum);
            suffixmin[i]=min;
        }

        

        for(int i=0;i<nums.length;i++){
            if (prefixmax[i] - suffixmin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
    public static void main(Strings[] args) {
        // linear search

        // int numbers[]={2,4,6,8,10,12,14,16};
        // // int key=10;

        // // int index=linearSearch(numbers, key);
        // // if(index==-1){
        // //     System.err.println("Element not Found");
        // // }
        // // else{
        // //     System.out.println("Element found at index:"+ index);
        // // }

        //largest element 
        // int numbers[]={1,2,6,3,5};

        // System.out.println("largest Value is : "+ LargestNum(numbers));


        //binary search
        // int numbers[]={2,4,6,8,10,12,14};
        // int key=10;
        // System.out.println("Index for key is :"+Binarysearch(numbers, key));


        //Reverse an array
        // int numbers[]={2,4,6,8,10};
        // RevArray(numbers);
        // for(int i=0;i<numbers.length;i++){
        //     System.out.print(numbers[i]+" ");
        // }


        //pairs in an array

        // int numbers[]={2,4,6,8,10};
        // pairs(numbers);

        //subarrays in an array
        // int numbers[]={2,4,6,8,10};
        // printSubarrays(numbers);

        //max Subarrays Bruteforce
        // int numbers[]={1,-2,6,-1,3};
        // SubarraySum(numbers);

        //prefix method
        // int numbers[]={1,-2,6,-1,3};
        // SubarraySumOptimised(numbers);

        //kedanes algorithm
        // int numbers[]={-2,-3,4,-1,-2,1,5,-3};
        // kadanes(numbers);

        int numbers[]={1,2,4,6,7};
        System.out.println(duplicates(numbers));

    }
}
