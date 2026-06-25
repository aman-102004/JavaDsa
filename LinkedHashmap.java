import java.util.LinkedHashMap;
public class LinkedHashmap {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> lhm=new LinkedHashMap<>();
        lhm.put("India",100);
        lhm.put("US",1000);

        System.out.println(lhm);
    }
}
//it uses array of doubly linked list to maintain the order
//Linked hashmap are same as hasmaps only difference is the keys are always returned in thr order they are passed
//it has same functions as that of the hashmap