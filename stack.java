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

    public static void StockSpan(int stocks[],int span[]){
        Stack<Integer> s=new Stack<>();
        span[0]=1;
        s.push(0);

        for(int i=1;i<stocks.length;i++){
            int currPrice=stocks[i];
            while(!s.isEmpty() && currPrice>stocks[s.peek()]){
                s.pop();

            }
            if(s.isEmpty()){
                span[i]=i+1;

            }else{
                int prevhigh=s.peek();
                span[i]=i-prevhigh;
            }
            s.push(i);
        }


    }


    public static boolean ParenthesisValid(String str){
        Stack<Character> s=new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            //opening
            if(ch=='(' || ch=='{' || ch=='['){
                s.push(ch);

            }else{
                if(s.isEmpty()){
                    return false;
                }

                if((s.peek()=='(' && ch==')') || s.peek()=='{' && ch=='}'|| s.peek()=='[' && ch==']'){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }

    }

    public static boolean ParenthesisIsDuplicate(String str){
        Stack<Character> s=new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            //closing condn
            if(ch==')'){
                int count=0;
                while(!s.isEmpty() && s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true; //duplicate exists

                }else{
                    s.pop();//opening pair
                }
            
            }
            //opening condition
            else{
            s.push(ch);
            }
        }
        return false;
    }

    public static void maxAreaRectangle(int arr[]){
        int maxarea=0;
        int nsr[]=new int [arr.length];
        int nsl[]=new int[arr.length];
        
        //next smaller right
        Stack<Integer> s=new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length;
            }else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        


        //next smaller left
        s=new Stack<>();

        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }


        //current area
        //width=j-i-1=nsr[i]-nsl[i]-1
        //height=length of bar

        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int width=nsr[i]-nsl[i]-1;
            int currarea=height*width;
            maxarea=Math.max(currarea,maxarea);
        }

        System.out.println("Max area of histogram is "+ maxarea);


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


        // Stack <Integer>s=new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // //3 2 1
        // // printStack(s);
        // reverseStack(s);
        // // 1 2 3

        // printStack(s);

        // int stocks[]={100,80,60,70,60,85,100};
        // int span[]=new int[stocks.length];
        // StockSpan(stocks,span);

        // for(int i=0;i<span.length;i++){
        //     System.out.print(span[i]+" ");
        // }



        //NEXT LARGEST ELEMENT CODE

        // int arr[]={6,8,0,1,3};

        // Stack<Integer> s=new Stack<>();

        // int nxtGreater[]=new int[arr.length];

        // for(int i=arr.length-1;i>=0;i--){
        //     //while
        //     while(!s.isEmpty()&& arr[s.peek()]<=arr[i]){
        //         s.pop();
        //     }


        //     //ifelse
        //     if(s.isEmpty()){
        //         nxtGreater[i]=-1;

        //     }else{
        //         nxtGreater[i]=arr[s.peek()];
        //     }


        //     //push
        //     s.push(i);

            
        // }
        // for(int i=0;i<arr.length;i++){
        //         System.out.print(nxtGreater[i]+" ");
        //     }


    //VALID PARENTHESIS 

    // String str="(){}[]({})";

    // System.out.println(ParenthesisValid(str));


    //Duplicate Parenthesis

    // String str="((a+b))";
    // String str2="(a-b)";

    // System.out.println(ParenthesisIsDuplicate(str2));
    // System.out.println(ParenthesisIsDuplicate(str));
    

    int arr[]={2,1,5,6,2,3};
    maxAreaRectangle(arr);




        

        
    }
    
}
