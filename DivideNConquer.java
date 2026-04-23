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

    public static void main(String[] args) {
        int arr[]={6,3,9,5,2,8};
        MergeSort(arr, 0, arr.length-1);
        printarray(arr);

        

    }
    
}
