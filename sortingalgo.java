public class sortingalgo {

    public static void bubblesort(int numbers[]){

        for(int i=0;i<numbers.length-1;i++){
            for(int j=0;j<numbers.length-1-i;j++){
                if(numbers[j]>numbers[j+1]){
                    int temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;

                }

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

        int  numbers[]={3,2,5,4,1};
        bubblesort(numbers);
        printarr(numbers);
        
    }
    
}
