import java.util.Comparator;
import java.util.PriorityQueue;
public class Heap {
    static class Student implements Comparable<Student>{//implements Comparable<Student> this is interface give a class the power to compare its objects on the basis of someproperty
        String name;
        int rank;

        public Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }

        //using the method of the comparable interface
        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;

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

        PriorityQueue<Student> pq=new PriorityQueue<>();
        pq.add(new Student("A", 4));
        pq.add(new Student("B", 5));
        pq.add(new Student("C", 2));
        pq.add(new Student("D", 12));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + "->" + pq.peek().rank);//doesnot matter how you have added the priority will be given to the lowest values integer
            pq.remove();
        }

        //CBT=completely filled binary treee is the tree in which rach noide is filled with max 2 children and in case if it is not so then elements are filled from left to right
        
    }
    
}
