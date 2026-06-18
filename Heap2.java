import java.util.*;
public class Heap2 {
    // static class Heap{
    //     ArrayList<Integer> arr=new ArrayList<>();

    //     public void add(int data){
    //         //add at last;
    //         arr.add(data);
    //         int x=arr.size()-1;
    //         int par=(x-1)/2;

    //         while(x>0 && arr.get(x)<arr.get(par)){
    //             //swap;

    //             int temp=arr.get(x);
    //             arr.set(x,arr.get(par));
    //             arr.set(par,temp);

    //             x=par;
    //             par=(x-1)/2;
    //         }
    //     }

    //     public int peek(){
    //         return arr.get(0);
    //     }

    //     private void heapify(int idx){
    //         int left=2*idx+1;
    //         int right=2*idx+2;

    //         int minidx=idx;

    //         if(left<arr.size() && arr.get(minidx)>arr.get(left)){
    //             minidx=left;

    //         }

    //         if(right<arr.size() && arr.get(minidx)>arr.get(right)){
    //             minidx=right;
    //         }

    //         if(minidx!=idx){
    //             //swap

    //             int temp=arr.get(idx);
    //             arr.set(idx,arr.get(minidx));
    //             arr.set(minidx,temp);

    //             heapify(minidx);


    //         }
    //     }
    //     public int remove(){
    //         int data=arr.get(0);

    //         //step1 swap fisrt And last

    //         int temp=arr.get(0);
    //         arr.set(0,arr.get(arr.size()-1));
    //         arr.set(arr.size()-1,temp);


    //         //delete last;

    //         arr.remove(arr.size()-1);

    //         //heapify

    //         heapify(0);

    //         return data;
    //     }

    //     public boolean isEmpty(){
    //         return arr.size()==0;
    //     }
    // }

    public static void heapify(int arr[],int i,int size){
        int left=2*i+1;
        int right=2*i+2;
        int maxidx=i;

        if(left<size && arr[left]>arr[maxidx]){
            maxidx=left;
        }

        if(right<size && arr[right]>arr[maxidx]){
            maxidx=right;
        }

        if(maxidx!=i){
            int temp=arr[i];
            arr[i]=arr[maxidx];
            arr[maxidx]=temp;

            heapify(arr, maxidx, size);
        }
    }

    public static void heapSort(int arr[]){//O(nlogn)
        //step 1 build maxheap for ascending order
        //call heapify all elements except the leaf ones
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }

        //step 2 push largest element at the end
        for(int i=n-1;i>0;i--){
            //largest element with last element(as its the max heap so last element will be at the first index)
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr,0,i);
        
        }
    }
    public static void main(String[] args) {
        // Heap h=new Heap();

        // h.add(3);
        // h.add(5);
        // h.add(2);
        // h.add(1);
        // h.add(4);

        // while(!h.isEmpty()){
        //     System.out.println(h.peek());
        //     h.remove();
        // }


        int arr[]={1,2,4,5,3};

        heapSort(arr);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

        
        
    }
    
}
