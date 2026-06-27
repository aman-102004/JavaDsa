import java.util.*;
import java.util.HashSet;
public class HashSets {
    public static void main(String[] args) {
    //     HashSet<Integer> hs=new HashSet<>();

    //     hs.add(1);
    //     hs.add(2);
    //     hs.add(4);
    //     hs.add(4);

    //     System.out.println(hs);

    //     if(hs.contains(5)){
    //         System.out.println("True");
    //     }else{
    //         System.out.println(false);
    //     }

    //     System.out.println(hs.size());
    // }

    // HashSet<String> cities =new HashSet<>();
    // cities.add("Delhi");
    // cities.add("Mumbai");
    // cities.add("Noida");

    //Iterating in a HashSet using Iterator interafce

    // Iterator it=cities.iterator();
    // while(it.hasNext()){
    //     System.out.println(it.next());

    // }

    //Iterating using advanced for loop

    // for(String city:cities){
    //     System.out.println(city);
    // }

    int arr1[] ={7,3,9};
    int arr2[] ={6,3,9,2,9,4};

    HashSet<Integer> set=new HashSet<>();

    //union
    for(int i=0;i<arr1.length;i++){
        set.add(arr1[i]);
    }

    for(int i=0;i<arr2.length;i++){
        set.add(arr2[i]);
    }

    System.out.println("union=" + set.size());



    //Intersection of elements
    set.clear();

    for(int i=0;i<arr1.length;i++){
        set.add(arr1[i]);
    }
    int count=0;
    for(int i=0;i<arr2.length;i++){
        if(set.contains(arr2[i])){
            count++;
            set.remove(arr2[i]);
        }
    }

    System.out.println("Intersection = "+count);

    





    
    }

}
//clear function is used to remove all the values in the set
//contains unique elemts will not add any duplicate elements
//add contains and remove take O(1) time
//Hashsets are implemented using hashmaps
//null values allowed