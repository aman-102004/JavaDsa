import java.net.SocketTimeoutException;
import java.util.* ;
public class matrices {

    public static boolean search(int matrix[][],int key){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
               if(matrix[i][j]==key){
                System.out.println("found at cell ("+i+","+j +")");
                return true;
               }
            }
        }
        System.out.println("Key Not found");
        return false;
    }

    public static int diagonalsum(int matrix[][]){
        int sum=0;
        //primary diaonal sum;//condition for primary diagonal(i==j)//condition for secondary diagonal (i+j=n-1)
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(i==j){
        //             sum+=matrix[i][j];
        //         }
        //         if(i+j==matrix.length-1){
        //             sum+=matrix[i][j];
        //         }
        //     }
        // }

        for(int i=0;i<matrix.length;i++){
            //primary
            sum+=matrix[i][i];
            //secondary
            if(i!=matrix.length-1-i)
                sum+=matrix[i][matrix.length-i-1];
        }
        return sum;
    }
    public static void main(String[] args) {
    //     int matrix[][]=new int[3][3];
    //     int n=matrix.length;//for no of rows;
    //     int m=matrix[0].length;//for no of columns;
    //     Scanner sc=new Scanner(System.in);
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             matrix[i][j]=sc.nextInt();
    //         }
    //     }
    //     //output
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             System.out.print(matrix[i][j]+" ");
    //         }
    //         System.out.println();

    //     }
    //     search(matrix,5);
    // }
    int matrix[][]={{1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}};
    System.out.println(diagonalsum(matrix));

    
}
}