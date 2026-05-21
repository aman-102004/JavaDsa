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

    // static class Node{
    //     int data;
    //     Node next;

    //     Node(int data){
    //         this.data=data;
    //         this.next=null;
    //     }
    // }

    // static class Stack{
    //     static Node head=null;

    //     public static boolean isEmpty(){
    //         return head==null;
    //     }

    //     public static void push(int data){
    //         Node newNode=new Node(data);
    //         if(isEmpty()){
    //             head=newNode;
    //             return;
    //         }
    //         newNode.next=head;
    //         head=newNode;
            
    //     }

    //     public static int pop(){
    //         if(isEmpty()){
    //             return -1;

    //         }

    //         int top=head.data;
    //         head=head.next;
    //         return top;
    //     }

    //     public static int peek(){
    //         if(isEmpty()){
    //             return -1;

    //         }
    //         return head.data;

    //     }

         
    // }

    public static void pushAtBottom(Stack<Integer>s,int data){

        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushAtBottom(s, data);
        s.push(top);

    }

    public static String reverseString(String str){
        Stack<Character> s=new Stack<>();
        int idx=0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;

        }

        StringBuilder result =new StringBuilder("");
        while(!s.isEmpty()){
            char curr=s.pop();
            result.append(curr);
        }

        return result.toString();

    }

    public static void printStack(Stack<Integer>s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top=s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void StockSpan(){

    }

    public static void main(String[] args) {
        //we can create stack using prebuilt stack library 
        //Stack<Integer>s=new Stack<>();
        //dont forget to import stack from java util
        //same operations can be performed
        
        // Stack s=new Stack();

        // Stack<Integer>s=new Stack<>();

        // s.push(1);
        // s.push(2);
        // s.push(3);

        // pushAtBottom(s,4);

        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }

        // String str="abc";
        // String result=reverseString(str);
        // System.out.println(result);


        Stack <Integer>s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        //3 2 1
        // printStack(s);
        reverseStack(s);
        // 1 2 3

        printStack(s);
        

        
    }
    
}
