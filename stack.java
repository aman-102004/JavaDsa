import java.util.*;
public class stack {
    //stack using array list


    // static class Stack{
    //     static ArrayList<Integer> list=new ArrayList<>();
        
    //     //is empty operation
    //     public static boolean isEmpty(){
    //         return list.size()==0;
    //     }

    //     //push operation
    //     public static void push(int data){
    //         list.add(data);
    //     }

    //     //pop operation

    //     public static int pop(){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         int top=list.get(list.size()-1);
    //         list.remove(list.size()-1);
    //         return top;

    //     }

    //     public static int peek(){
    //         if(isEmpty()){
    //             return -1;
    //         }
    //         return list.get(list.size()-1);
    //     }

    // }

    //stack using linked list

    static class Stack{
        
    }

    public static void main(String[] args) {

        Stack s=new Stack();

        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();

        }

        
    }
    
}
