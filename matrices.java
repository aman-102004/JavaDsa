import java.util.* ;
public class matrices {
    public static void main(String[] args) {
        int matrix[][]=new int[3][3];
        int n=matrix.length;//for no of rows;
        int m=matrix[0].length;//for no of columns;
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        //output
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
