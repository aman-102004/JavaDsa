import java.util.*;
public class Hashing {

    public static void main(String[] args) {
        //create
        //HashMaps Are unordered maps there is no fixed order of storage of data in a hashmap
        //O(1)
        HashMap<String,Integer> hm=new HashMap<>();

        hm.put("India",100);
        hm.put("China",150);
        hm.put("US",50);
        hm.put("Indonesia",6);
        hm.put("Nepal",5);

        // System.out.println(hm);


        // //Get
        // //O(n)
        // int population=hm.get("India");
        // System.out.println(population);


        // //Contains Key return true or false
        // //O(n)
        // System.out.println(hm.containsKey("US"));
        

        // //Remove
        // System.out.println(hm.remove("US"));
        // System.out.println(hm);


        // //Size
        // System.out.println(hm.size());
    
        // //isEmpty
        // System.out.println(hm.isEmpty());

        //Iteration on a hashmap
        Set<String> keys=hm.keySet();
        System.out.println(keys);

        for (String key : keys) {
            System.out.println("key="+key+",value "+hm.get(key));
            
        }
    }
    
}
