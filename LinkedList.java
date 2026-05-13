public class LinkedList {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        //step 1 -create new node
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
            
        }

       

        //step2 new node next=head;

        newNode.next=head;

        //step 3 head=newnode;

        head=newNode;
        
    }

    public void addLast(int data){
        Node newNode=new Node(data);
        size++;

        if(head==null){
            head=tail=newNode;
            return;
        }

        tail.next=newNode;

        tail=newNode;

    }
    public void printData(){

        // if(head==null){
        //     System.out.println("Linked List is empty");

        // } 
        Node temp=head;
        //this is how we gonna perform operations on link lsit by using the variale temp

        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;

        }
        System.out.println("null");

    }

    public void addinmiddle(int idx,int data){

        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        size++;
        Node temp=head;

        int i=0;

        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        //i=idx-1;temp->prev

        newNode.next=temp.next;
        temp.next=newNode;



    }

    public static void main(String[] args) {
        LinkedList ll=new LinkedList();

        // l1.head=new Node(1);
        // l1.head.next=new Node(2);
        //we will be using methods for adding and every operations unlike the above manual methods

        ll.addFirst(2);
        ll.addFirst(1);//O(n) to add a num

        ll.addLast(3);
        ll.addLast(4);//O(1);

        ll.addinmiddle(2, 9);
        
        ll.printData();
        System.out.println(ll.size);
    }
    
}
