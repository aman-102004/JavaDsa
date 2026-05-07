import java.util.*;
public class arraylists {

    public static void swap(ArrayList<Integer> list,int idx1,int idx2){

        int temp=list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }

    public static void main(String[] args) {
        //how to define array lists in java
        ArrayList<Integer>list=new ArrayList<>();

        // ArrayList<String>list2=new ArrayList<>();

        //operation on arrayslists

        //1.add operation
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //adding element at a random index;
        // list.add(1,9);

        System.out.println(list);


        //2nd get operation
        
        // System.out.println(list.get(2));

        // //3rd remove element

        // System.out.println(list.remove(2));

        // System.out.println(list);
        

        //4th set element at index

        // list.set(1,10);//index at which we need to set the element and the value which we need to change is passed in the argument

        // System.out.println(list);

        //5th contains element or not

        // System.out.println(list.contains(6));

        // //6th size of an array
        // System.out.println(list.size());   
        
        // //printing array list using size just likea arrays

        // for(int i=0;i<list.size();i++){
        //     System.out.print(list.get(i)+" ");
        // }
        // System.out.println();

        //printing reverse of an array list

        // for(int i=list.size()-1;i>=0;i--){
        //     System.out.print(list.get(i)+" ");
        // }


        //Max number in an array

        // int max=Integer.MIN_VALUE;

        // for(int i=0;i<list.size();i++){
        //     max=Math.max(max,list.get(i));
        // }
        // System.out.println(max);
        
        //swapping two numbers

        // int idx=1;
        // int idx2=3;

        // swap(list, idx, idx2);
        // System.out.println(list);

        //Sorting an Array list
         


    }
    
}
