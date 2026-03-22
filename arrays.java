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
                int end=j;
                for(int k=start;k<=end;k++ ){//this loop is used for printing
                    System.out.print(numbers[k]+" ");
                }
                System.out.println();

            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
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
        int numbers[]={2,4,6,8,10};
        printSubarrays(numbers);
    }
}
