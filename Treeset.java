import java.util.TreeSet;
public class Treeset {

    public static void main(String[] args) {
        TreeSet<Integer> ts=new TreeSet<>();
        ts.add(100);
        ts.add(200);
        ts.add(50);
        ts.add(1);
        
        System.out.println(ts);
        
    }
    
}
//implemented using TreeMap
//stores element in sorted form;
//null values not allowed
//all time complexity is O(log n)