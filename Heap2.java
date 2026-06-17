import java.util.*;
public class Heap2 {
    static class Heap{
        ArrayList<Integer> arr=new ArrayList<>();

        public void add(int data){
            //add at last;
            arr.add(data);
            int x=arr.size()-1;
            int par=(x-1)/2;

            while(x>0 && arr.get(x)<arr.get(par)){
                //swap;

                int temp=arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x=par;
                par=(x-1)/2;
            }
        }
    }

    public static void main(String[] args) {
        
    }
    
}
