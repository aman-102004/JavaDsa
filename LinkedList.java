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

    public int removeFirst(){

        if(size==0){
            System.out.println("LL is empty");
            return Integer.MAX_VALUE;

        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;

        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }

        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;

        }
        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size=0;
        return val;




    }

    public int SearchIterative(int key){//O(n)
        int i=0;
        Node temp=head;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;

    }
    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }

        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next, key);
        if(idx==-1){
            return -1;

        }

        return idx+1;
    }
    public int SearchRecursive(int key){
        return helper(head,key);
    }

    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }
        head=prev;
         

    }

    public void deleteNthfromend(int n){
        int sz=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }

        //if the removing element is the head node only
        if(n==sz){
            head=head.next;
            return;
        }
        //nth from start is size-n+1 from start so we need size-n element to delete the nth element
        //sz-n
        int i=1;
        int itofind=sz-n;
        Node prev=head;
        while(i<itofind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;

    }

    //slow fast approach
    public Node findmid(Node head){
        Node slow=head;
        Node fast=head;

        while(fast!=null&&fast.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2


        }
    return slow;//slow becomes mid;
    }

    public boolean checkPalindrome(){

        if(head==null || head.next==null){
            return true;
        }
        //step1 find mid
        
        Node midNode=findmid(head);
        //step 2 reverse 2nd half
        
        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node right =prev;
        Node left=head;
        //step3  compare both halfs
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;


        

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

        ll.removeFirst();

        ll.printData();
        

        ll.removeLast();

        ll.printData();

        System.out.println(ll.SearchIterative(10));

        System.out.println(ll.SearchRecursive(3));

        ll.reverse();

        ll.printData();

        ll.addFirst(7);
        ll.addFirst(10);
        ll.printData();

        ll.deleteNthfromend(2);
        ll.printData();
        System.out.println(ll.checkPalindrome());
    }
    }
    

