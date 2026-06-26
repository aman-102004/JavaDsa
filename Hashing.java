import java.util.*;
public class Hashing {

    public static boolean isAnagram(String s,String t){
       if(s.length()!=t.length()){
        return false;
       }
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);//if does not exist then 0+1 otherwise freq+1;
        }

        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(map.get(ch)!=null){
                if(map.get(ch)==1){
                map.remove(ch);
            }else{
                map.put(ch,map.get(ch)-1);
            }
                
        }else{
            return false;
        }
            
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        //create
        //HashMaps Are unordered maps there is no fixed order of storage of data in a hashmap
        // //O(1)
        // HashMap<String,Integer> hm=new HashMap<>();

        // hm.put("India",100);
        // hm.put("China",150);
        // hm.put("US",50);
        // hm.put("Indonesia",6);
        // hm.put("Nepal",5);
        // hm.put("Australia",400);

        // // System.out.println(hm);


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
        // Set<String> keys=hm.keySet();
        // System.out.println(keys);

        // for (String key : keys) {
        //     System.out.println("key="+key+",value "+hm.get(key));
            
        // }


        //Majority Element

        // int arr[]={1,3,2,5,1,3,1,5,1};
        // HashMap<Integer,Integer> map=new HashMap<>();

        // for(int i=0;i<arr.length;i++){
        //     if(map.containsKey(arr[i])){
        //         map.put(arr[i],map.get(arr[i])+1);
        //     }else{
        //         map.put(arr[i],1);
        //     }
        // }

        // Set<Integer> keySet=map.keySet();

        // for(Integer key:keySet){
        //     if(map.get(key)>arr.length/3){
        //         System.out.println(key);
        //     }
        // }


        //Valid Anagrams(O(n));
        String s="racer";
        String t="caret";
        System.out.println(isAnagram(s, t));



    }
    
}
