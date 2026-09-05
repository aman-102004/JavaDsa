import java.util.PriorityQueue;
import java.util.Stack;

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

    public  boolean isCycle(){//this method is called floyd cycle finding algo
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                return true;
            }

            

            }
            return false;
    }

    public void removecycle(){
        //detect cycle
        Node slow=head;
        Node fast=head;

        boolean cycle =false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(fast==slow){
                cycle=true;
                break;
            }
        }

        if(cycle==false){
            return;
        }
        //find meeting point

        slow=head;
        Node prev=null;

        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;

        }


        
        //remove cycle
        prev.next=null;
    }

    public Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;

        while(fast!=null &&fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    public Node merge(Node head1,Node head2){
        Node mergedLinked=new Node(-1);
        Node temp=mergedLinked;


        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;

        }

        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;

        }
        return mergedLinked.next;
    }

    public Node mergeSort(Node head){//O(nlogn)
        if(head==null || head.next==null){
            return head;
        }
        //find mid
        Node mid=getMid(head);

        //left and right mergeSort
        Node righthead=mid.next;
        mid.next=null;

        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(righthead);

        //merge
        return merge(newLeft,newRight);
    }

    public void Zigzag(){
        //1st find mid

        Node slow=head;
        Node fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }

        Node mid=slow;

        //2nd reverse

        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        //3rd zigzag merging
        Node left=head;
        Node right=prev;
        Node nextL,nextR;

        while(left!=null && right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            left=nextL;
            right=nextR;
        }

    }

    public Node addTwoNumbers(Node l1, Node l2) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.data);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.data);
            l2 = l2.next;
        }

        Node ans = null;
        int carry = 0;

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {

            int sum = carry;

            if (!s1.isEmpty()) {
                sum += s1.pop();
            }

            if (!s2.isEmpty()) {
                sum += s2.pop();
            }

            carry = sum / 10;

            Node newNode = new Node(sum % 10);

            newNode.next = ans;
            ans = newNode;
        }

        return ans;
    }

    public Node mergeKLists(Node[] lists) {
        
        PriorityQueue<Node> pq=new PriorityQueue<>((a, b) -> a.data - b.data);
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);

            }
            

        }
        Node dummy=new Node(-1);
        Node tail=dummy;


        while(!pq.isEmpty()){
            Node curr=pq.remove();
            tail.next=curr;
            tail=curr;
            
            if(curr.next!=null){
                pq.add(curr.next);
            }
            
            
        }
        return dummy.next;
        
    }

    public Node swapPairs(Node head) {


        if(head==null){
            return head;
        }
        
        
        Node first=new Node(-1);
        first.next=head;

        Node temp=first;

        while(temp.next!=null && temp.next.next!= null){
            Node curr=temp.next;
            Node next=curr.next;

            temp.next=next;
            curr.next=next.next;
            next.next=curr;

            temp=curr;
            
        }
        
      
        
      return first.next;

    }


    //LC 2058
    public static boolean maxima(Node prev, Node curr, Node next) {
        return prev.data < curr.data && next.data < curr.data;
    }

    public static boolean minima(Node prev, Node curr, Node next) {
        return prev.data > curr.data && next.data > curr.data;
    }

    public int[] nodesBetweenCriticalPoints(Node head) {

        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        int count = 0;
        int max = 0;
        int min = 0;

        int nodenum = 2;
        int first = 0;
        int prevCritical = -1;

        Node temp = head;

        while(temp != null && temp.next != null && temp.next.next != null) {

            Node prev = temp;
            temp = temp.next;
             Node next = temp.next;

            if(maxima(prev, temp, next) || minima(prev, temp, next)) {

                count++;

                if(count == 1) {
                    first = nodenum;
                }

                if(prevCritical != -1) {
                    int distance = nodenum - prevCritical;

                    if(min == 0 || distance < min) {
                        min = distance;
                    }
                }

                prevCritical = nodenum;
            }

            nodenum++;
           
        }

        if(count < 2) {
            return ans;
        }

        max = prevCritical - first;

        ans[0] = min;
        ans[1] = max;

        return ans;
    }

    //lc19
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     //node to be deleted from last=totalnodes-n+1

    //     int totalnodes=0;
    //     ListNode temp=head;
    //     while(temp!=null){
    //         totalnodes++;
    //         temp=temp.next;
    //     }

    //     if(totalnodes==n){
    //         return head.next;
    //     }

    //     int delNode=totalnodes-n;
    //     int i=1;
    //     ListNode prev=head;
    //     while(i<delNode){
    //         prev=prev.next;
    //         i++;
    //     }
    //     prev.next=prev.next.next;

    // return head;


    // }
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();

        // // l1.head=new Node(1);
        // // l1.head.next=new Node(2);
        // //we will be using methods for adding and every operations unlike the above manual methods

        // ll.addFirst(2);
        // ll.addFirst(1);//O(n) to add a num

        // ll.addLast(3);
        // ll.addLast(4);//O(1);

        // ll.addinmiddle(2, 9);
        
        
        // ll.printData();
        // System.out.println(ll.size);

        // ll.removeFirst();

        // ll.printData();
        

        // ll.removeLast();

        // ll.printData();

        // System.out.println(ll.SearchIterative(10));

        // System.out.println(ll.SearchRecursive(3));

        // ll.reverse();

        // ll.printData();

        // ll.addFirst(7);
        // ll.addFirst(10);
        // ll.printData();

        // ll.deleteNthfromend(2);
        // ll.printData();
        // System.out.println(ll.checkPalindrome());

        // head=new Node(1);
        // Node temp=new Node(2);
        // head.next=temp;
        // head.next.next=new Node(3);
        // head.next.next.next=temp;
        // //1->2->-3->1

        // System.out.println(ll.isCycle());
        // ll.removecycle();
        // System.out.println(ll.isCycle());

        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.addFirst(5);
        // ll.addFirst(6);

        // ll.printData();

        // ll.head=ll.mergeSort(head);

        // ll.printData();

        
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.printData();
        ll.Zigzag();
        ll.printData();
    }
    }
    

