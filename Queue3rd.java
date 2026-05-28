import java.util.*;
import java.util.LinkedList;

public class Queue3rd {

    //for implementing stack using a queue use the same side to insert and remove to get desired results
    // static class Stack{
    //     Deque<Integer> deque=new LinkedList<>();

    //     public void push(int data){
    //         deque.addLast(data);
    //     }

    //     public int pop(){
    //         return deque.removeLast();
    //     }

    //     public int peek(){
    //         return deque.getLast();
    //     }
    // }


    //implementing queue using deque use opposite operations add from last adn remove from first

    static class Queue{
        Deque<Integer> deque=new LinkedList<>();

        public void add(int data){
            deque.addLast(data);
        }

        public int remove(){
            return deque.removeFirst();
        }

        public int peek(){
            return deque.getFirst();
        }
    }
    public static void main(String[] args) {
        // Deque<Integer> deque=new LinkedList<>();
        // deque.addFirst(1);
        // deque.addFirst(2);
        // deque.addLast(3);

        // System.out.println(deque);

        // deque.removeFirst();
        // //deque.removeLast();

        // System.out.println(deque);

        // System.out.println("First Element is "+deque.getFirst());
        // System.out.println("Last Element is "+deque.getLast());

        // Stack s=new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println(s.peek());

        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.peek());
    }
    

}
