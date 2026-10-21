import java.util.LinkedList;
public class LinkedList2 {

    //lc143
    // public void reorderList(ListNode head) {
    //     if (head==null||head.next==null){
    //         return;
    //     }

    //     Stack<ListNode> s=new Stack<>();

    //     ListNode temp=head;

    //     int count=0;
    //     while(temp!=null){
    //         s.push(temp);
    //         count++;
    //         temp=temp.next;
    //     }

    //     temp=head;
        
    //     for(int i=0;i<count/2;i++){
    //         ListNode prev=temp.next;
    //         ListNode last=s.pop();

    //         temp.next=last;
    //         last.next=prev;
    //         temp=prev;
    //     }

    //     temp.next=null;
        
    // }
    
    public static void main(String[] args) {
        //create
        LinkedList<Integer> ll=new LinkedList<>();


        //add

        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);

        System.out.println(ll);

        //remove

        ll.removeLast();

        System.out.println(ll);
        
    }
    
}
