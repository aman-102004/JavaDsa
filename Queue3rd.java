import java.util.*;
import java.util.LinkedList;

public class Queue3rd {
    public static void main(String[] args) {
        Deque<Integer> deque=new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);

        System.out.println(deque);

        deque.removeFirst();
        //deque.removeLast();

        System.out.println(deque);

        System.out.println("First Element is "+deque.getFirst());
        System.out.println("Last Element is "+deque.getLast());
    }
    

}
