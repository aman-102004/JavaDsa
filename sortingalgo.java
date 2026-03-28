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

    public static void printarr(int numbers[]){
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int  numbers[]={1,2,3};
        bubblesort(numbers);
        printarr(numbers);
        
    }
    
}
