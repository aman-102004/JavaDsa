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

    public static void printarr(int numbers[]){
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int  numbers[]={1,2,3,8,4,9};
        selectionsort(numbers);
        printarr(numbers);
        
    }
    
}
