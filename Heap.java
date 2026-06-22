import java.util.Comparator;
import java.util.PriorityQueue;
public class Heap {
    // static class Student implements Comparable<Student>{//implements Comparable<Student> this is interface give a class the power to compare its objects on the basis of someproperty
    //     String name;
    //     int rank;

    //     public Student(String name,int rank){
    //         this.name=name;
    //         this.rank=rank;
    //     }

    //     //using the method of the comparable interface
    //     @Override
    //     public int compareTo(Student s2){
    //         return this.rank-s2.rank;

    //     }
    // }




    // static class Point implements Comparable<Point>{
    //     int x;
    //     int y;
    //     int distSq;
    //     int idx;

    //     public Point(int x,int y,int distSq,int idx){
    //         this.x=x;
    //         this.y=y;
    //         this.distSq=distSq;
    //         this.idx=idx;
    //     }
    //     @Override
    //     public int compareTo(Point p2){
    //         return this.distSq-p2.distSq;
    //     }
    // }

    // static class row implements Comparable<row>{
    //     int soldiers;
    //     int idx;

    //     public row(int soldiers,int idx){
    //         this.soldiers=soldiers;
    //         this.idx=idx;
    //     }

    //     @Override
    //     public int compareTo(row r2){
    //         if(this.soldiers==r2.soldiers){
    //             return this.idx-r2.idx;
    //         }else{
    //             return this.soldiers-r2.soldiers;
    //         }

    //     }

    // }

    static class pair implements Comparable<pair>{
        int val;
        int idx;

        public pair(int value,int idx){
            this.val=value;
            this.idx=idx;
        }

        @Override
        public int compareTo(pair p2){
            //this is for desc order
            return p2.val-this.val;
        }
    }
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());//use this comparator.reverse order to reverse the priortiy from default that is ascending to descending

        // pq.add(3);//(o(n))
        // pq.add(4);
        // pq.add(1);
        // pq.add(7);

        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek());//doesnot matter how you have added the priority will be given to the lowest values integer
        //     pq.remove();
        // }

        // comparing objects using a priority queue

        // PriorityQueue<Student> pq=new PriorityQueue<>();
        // pq.add(new Student("A", 4));
        // pq.add(new Student("B", 5));
        // pq.add(new Student("C", 2));
        // pq.add(new Student("D", 12));

        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek().name + "->" + pq.peek().rank);//doesnot matter how you have added the priority will be given to the lowest values integer
        //     pq.remove();
        // }

        //CBT=completely filled binary treee is the tree in which rach noide is filled with max 2 children and in case if it is not so then elements are filled from left to right
        


        //SELECT K NEAREST POINTS
        // int pts[][]={{3,3},{5,-1},{-2,4}};
        // int k=2;

        // PriorityQueue<Point> pq=new PriorityQueue<>();

        // for(int i=0;i<pts.length;i++){
        //     int distSq=pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
        //     pq.add(new Point(pts[i][0],pts[i][1],distSq,i));
        // }

        // //nearest k cars

        // for(int i=0;i<k;i++){
        //     System.out.println("C"+pq.remove().idx);
        // }

        //CONNECT ROPES WITH MINUMUM LENGTH
        // int ropes[]={2,3,3,4,6};

        // PriorityQueue<Integer> pq=new PriorityQueue<>();
        // for(int i=0;i<ropes.length;i++){
        //     pq.add(ropes[i]);
        // }

        // int cost=0;

        // while(pq.size()>1){
        //     int min=pq.remove();
        //     int min2=pq.remove();
        //     cost+=min+min2;
        //     pq.add(min+min2);

        // }

        // System.out.println("final Min Cost is :"+ cost);

        //WEAKEST SOLDIER

        // int army[][]={
        //     {1,0,0,0},
        //     {1,1,1,1},
        //     {1,0,0,0},
        //     {1,0,0,0,}
        // };
        // int k=2;

        // PriorityQueue<row> pq=new PriorityQueue<>();

        // for(int i=0;i<army.length;i++){
        //     int count=0;
        //     for(int j=0;j<army[0].length;j++){
        //         count+=army[i][j]==1?1:0;

        //     }
        //     pq.add(new row(count,i));
        // }

        // for(int i=0;i<k;i++){
        //     System.out.println("R"+pq.remove().idx);
        // }

        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        int res[]=new int[arr.length-k+1];

        PriorityQueue<pair> pq=new PriorityQueue<>();

        for(int i=0;i<k;i++){
            pq.add(new pair(arr[i],i));
        }

        res[0]=pq.peek().val;

        for(int i=k;i<arr.length;i++){
            while(pq.size()>0 && pq.peek().idx <=(i-k)){
                pq.remove();
            }

            pq.add(new pair(arr[i], i));
            res[i-k+1]=pq.peek().val;
        }

        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }

    }
    
}
