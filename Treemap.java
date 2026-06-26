import java.util.TreeMap;
public class Treemap {
    public static void main(String[] args) {
        
        TreeMap<String,Integer> tm=new TreeMap<>();
        tm.put("India", 100);
        tm.put("Albania",50);

        System.out.println(tm);
    }

    
}


//here keys are returned in the sorted order
//put get and remove has time complexity of O(logn)
//Implemented using red black trees