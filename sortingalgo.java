public class sortingalgo {

    public static void bubblesort(int numbers[]){

        for(int i=0;i<numbers.length-1;i++){
            int swap=0;
            for(int j=0;j<numbers.length-1-i;j++){
                if(numbers[j]>numbers[j+1]){
                    int temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                    swap++;

                }
            }
            if(swap==0){
                System.out.println("Array is already sorted");
                break;
            }

        }

    }

    public static void selectionsort(int numbers[]){
        for(int i=0;i<numbers.length-2;i++){
            int minpos=i;
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[minpos]>numbers[j]){
                    minpos=j;
                }
            }
            //swap
            int temp=numbers[minpos];
            numbers[minpos]=numbers[i];
            numbers[i]=temp;

        }
    }
    
    public static void insertionsort(int numbers[]){
        for(int i=1;i<numbers.length;i++){
            int curr=numbers[i];
            int prev=i-1;
            //finding out the correct position for the element
            while(prev>=0&& numbers[prev]>curr){
                numbers[prev+1]=numbers[prev];
                prev--;
            }
            //insertion
            numbers[prev+1]=curr;
        }
    }

    public static void coutingsort(int numbers[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<numbers.length;i++){
            largest=Math.max(largest, numbers[i]); 
        }
        int count[]=new int[largest+1];
        for(int i=0;i<numbers.length;i++){
            count[numbers[i]]++;

        }
        //sorting
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                numbers[j]=i;
                j++;
                count[i]--;
            }
        }
    }

    public static void printarr(int numbers[]){
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
    }
    public static void main(Strings[] args) {

        int  numbers[]={1,2,3,3,3,1,5,8,4,9};
        coutingsort(numbers);
        printarr(numbers);
        
    }
    
}
