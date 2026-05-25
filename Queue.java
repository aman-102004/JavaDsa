public class Queue {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }


    static class queue{
        static Node head=null;
        static Node tail=null;

        public static boolean isEmpty(){
            return head==null && tail==null;
            
        }

        //no need of isfull in queue using linked list as we can add as many nodes we want in the end

        public static void add(int data){
            Node newNode=new Node(data);

            if(head==null){
                head=tail=newNode;
                return;
            }

            tail.next=newNode;
            tail=newNode;


        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }

            int front=head.data;
            //single element case
            if(tail==head){
                tail=head=null;

            }else{
                head=head.next;
            }


            return front;
        }


        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
       
            }

            return head.data;


    }
}
    // //queue and circular queue using arrays

    // static class queue{
    //     static int arr[];
    //     static int size;
    //     static int rear;
    //     static int front;
    //     queue(int n){
    //         arr=new int[n];
    //         size=n;
    //         rear=-1;
    //         front=-1;

    //     }

    //     // public static boolean isEmpty(){
    //     //     return rear==-1;

    //     // }

    //     public static boolean isEmpty(){
    //         return rear==-1 && front==-1;
    //     }

    //     public static boolean isFull(){
    //         return(rear+1)%size==front;
    //     }
        

    //     //add
    //     public static void add(int data){
    //         if(isFull()){
    //             System.out.println("queue is full");
    //             return;
    //         }

    //         //adding first element
    //         if(front==-1){
    //             front =0;
    //         }

    //         rear=(rear+1)%size;
    //         arr[rear]=data;

    //     }

    //     public static int remove(){
    //         if(isEmpty()){
    //             System.out.println("empty queue");
    //             return -1;
    //         }

    //         // int front=arr[0];
    //         // for(int i=0;i<rear;i++){
    //         //     arr[i]=arr[i+1];
    //         // }


    //         int result=arr[front];
    //         // rear=rear-1;
    //         // front=(front+1)%size;

    //         //deleting last elmt

    //         if(front==rear){
    //             rear=front=-1;

    //         }else{
    //             front=(front+1)%size;
    //         }
    //         return result;

    //     }

    //     public static int peek(){
    //         if(isEmpty()){
    //             System.out.println("empty queue");
    //             return -1;
    //         }

    //         return arr[front];

    //     }
    // }

    public static void main(String[] args) {
        queue q=new queue();//5 is the size of the array that we wil be using
        q.add(1);
        q.add(2);
        q.add(3);
        // System.out.println(q.remove());
        q.add(4);

        


        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
    
}

