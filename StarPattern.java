public class StarPattern {
    public static void main(String[] args) {
        int n=5;

        //star
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }


        //inverted star
        // for(int i=n;i>=0;i--){
        //     for(int j=0;j<=i;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        //halfPyramid

        // for(int i=1;i<=n;i++){
        //     for (int j=1;j<=i;j++){
        //         System.out.print(j);
        //     }
        //     System.out.println();

        // }

        //character pattern
        char ch='A';
         for(int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();

        }
    }
}
