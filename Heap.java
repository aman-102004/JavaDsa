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



    
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x,int y,int distSq,int idx){
            this.x=x;
            this.y=y;
            this.distSq=distSq;
            this.idx=idx;
        }
        @Override
        public int compareTo(Point p2){
            return this.distSq-p2.distSq;
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
        int ropes[]={2,3,3,4,6};

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }

        int cost=0;

        while(pq.size()>1){
            int min=pq.remove();
            int min2=pq.remove();
            cost+=min+min2;
            pq.add(min+min2);

        }

        System.out.println("final Min Cost is :"+ cost);

    }
    
}
