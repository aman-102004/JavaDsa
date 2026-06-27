import java.util.*;
import java.util.HashMap;
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

    public static String getStart(HashMap<String,String> tickets){
        HashMap<String,String> revMap=new HashMap<>();
        //String key:tickets.keySet()- ShortForm for iterating in a hashmap
        for(String key:tickets.keySet()){
            revMap.put(tickets.get(key),key);

        }

        for(String key:tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key;//Startinf point

            }
        }

        return null;


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
        // String s="racer";
        // String t="caret";
        // System.out.println(isAnagram(s, t));


        //Iternary for tickets O(n)

        // HashMap<String,String> tickets=new HashMap<>();
        // tickets.put("Chennai","Bengaluru");
        // tickets.put("Mumbai","Delhi");
        // tickets.put("Goa","Chennai");
        // tickets.put("Delhi","Goa");

        // String start=getStart(tickets);
        // System.out.print(start);
        // for(String key : tickets.keySet()){
        //     System.out.print("->"+tickets.get(start));
        //     start=tickets.get(start);
        // }
        // System.out.println();


        //Largest Surbarray with Sum=0;

        // int arr[]={15,-2,2,-8,1,7,10,23};

        // HashMap<Integer,Integer> map=new HashMap<>();
        // //(sum,idx);

        // int sum=0;
        // int len=0;
        // //sum of an array i+1 to j is sum of j -sum of i;
        // for(int j=0;j<arr.length;j++){
        //     sum+=arr[j];
        //     if(map.containsKey(sum)){
        //         len=Math.max(len,j-map.get(sum));
        //     }else{
        //         map.put(sum,j);
        //     }
        // }

        // System.out.println("Largest subarray is:"+len);


        //Subarray wiwth sum=k
        int arr[]={10,2,-2,-20,10};
        int k=-10;
        HashMap<Integer,Integer> map=new HashMap<>();
        //(sum,count)
        //added 0,1 as when sum-k=0 means whole subarray sum is equal to i 
        map.put(0,1);
        int sum=0;
        int ans=0;
        //sum of an array i to j is sum of j - sum of i-1 so sum of j-k=sum of i;
        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);

            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        System.out.println(ans);


    }
    
}
