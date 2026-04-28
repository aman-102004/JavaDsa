public class DivideNConquer {

    public static void printarray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void MergeSort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }

        //kaam
        int mid=si+(ei-si)/2;

        MergeSort(arr,si,mid);//left part
        MergeSort(arr, mid+1 , ei);//right part
        Merge(arr,si,mid,ei);

    }

    public static void Merge(int arr[],int si,int mid,int ei){
        int temp[]=new int[ei-si+1];
        int i=si;//iterator for left part
        int j=mid+1;//iterator for right part
        int k=0;//iterator for temp array

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
                
            }
            else{
                temp[k]=arr[j];
                j++;
                
            }
            k++;
        }

        //leftpart
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        //right part
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        //copy temp to original array
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }

    }

    public static void quickSort(int arr[],int si,int ei){
        
        if(si>=ei){
            return;
        }

        int pidx=partition(arr,si,ei);
        quickSort(arr, si, pidx-1);
        quickSort(arr,pidx+1 , ei);
    }

    public static int partition(int arr[],int si,int ei){
        int pivot=arr[ei];
        int i=si-1;//used for creating space for inserting correct element at their place

        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;

        return i;


    }

    public static int rotatedarrysearch(int arr[],int target,int si,int ei){//modified binary search approach
       if(si>ei){
        return -1;
       }
       
       
        int mid=si+(ei-si)/2;

        //found at mid
        if(arr[mid]==target){
            return mid;
        }

        //mid at line one
        if(arr[si]<=arr[mid]){
            //case a:left
            if(arr[si]<=target && target <=arr[mid]){
                return rotatedarrysearch(arr, target, si, mid-1);

            }
            //case b:right
            else{
                return rotatedarrysearch(arr, target, mid+1, ei);
            }


        }
        else{
            //case c:right
            if(arr[mid]<=target && target<=arr[ei]){
                return rotatedarrysearch(arr, target, mid+1, ei);
            }
            else{
                //case d:left
                return rotatedarrysearch(arr, target, si, mid-1);
            }

        }

    }

    public static int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return nums[i];
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int arr[]={4,5,6,7,1,2,3};
        // quickSort(arr, 0, arr.length-1);
        // printarray(arr);
        int target=5;
        // int tidx=rotatedarrysearch(arr, target, 0, arr.length-1);
        // System.out.println(tidx);

        int tidx=rotatedarrysearch(arr, target,0, arr.length-1);
        System.out.println(tidx);
        

    }
    
}
