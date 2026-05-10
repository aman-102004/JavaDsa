import java.util.*;
public class MultidimentionalArrayLists {

    public static int storewater(ArrayList <Integer> height){
        //Bruteforce 
        int maxwater=0;

        for(int i=0;i<height.size();i++){

            for(int j=i+1;j<height.size();j++){
                int ht=Math.min(height.get(i),height.get(j));
                int wd=j-i;
                int currwater=ht * wd;
                maxwater=Math.max(maxwater,currwater);

            }

        }
        return maxwater;
    }

    //solving same question using two pointer approach
    public static int storewater2(ArrayList<Integer> height){
        int lp=0;
        int hp=height.size()-1;

        int maxwater=0;
         while(lp<hp){
            int h=Math.min(height.get(lp),height.get(hp));
            int width=hp-lp;
            int currwater=h*width;
            maxwater=Math.max(maxwater,currwater);

            if(height.get(lp)<height.get(hp)){
                lp++;
            }
            else{
                hp--;
            }
           

         }
          return maxwater;
    }
    public static void main(String[] args) {
        // ArrayList <ArrayList<Integer>> mainlist=new ArrayList<>();
        // ArrayList<Integer> list =new ArrayList<>();

        // list.add(1);list.add(2);
        // mainlist.add(list);

        // ArrayList<Integer> list2=new ArrayList<>();
        // list2.add(3);list2.add(4);
        // mainlist.add(list2);

        // for(int i=0;i<mainlist.size();i++){
        //     ArrayList <Integer> currlist=mainlist.get(i);
        //     for(int j=0;j<currlist.size();j++){
        //         System.out.print(currlist.get(j)+" ");
        //     }
        //     System.out.println();
        // }

        // System.out.println(mainlist);


        ArrayList<Integer> height=new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        height.add(9);

        System.out.println(storewater(height));
        System.out.println(storewater2(height));

    }
    
}
