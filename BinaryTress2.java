import java.util.*;
public class BinaryTress2 {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }

    }

    public static int TreeHeight(Node root){
        if(root==null){
            return 0;
        }
        int lh=TreeHeight(root.left);
        int rh=TreeHeight(root.right);
        
        return Math.max(lh,rh)+1;

    }

    public static int NodesCount(Node root){
        if(root==null){
            return 0;
        }
        int lcount=NodesCount(root.left);
        int rcount=NodesCount(root.right);

        return lcount+rcount+1;
    }


    public static int NodesSum(Node root){
        if(root==null){
            return 0;
        }

        int ls=NodesSum(root.left);
        int rs=NodesSum(root.right);

        return ls+rs+root.data;
    }
    public static void main(String[] args) {
           /*      1
                 /    \
                2      3  
               /\      /\   
              4  5    6  7  */
        
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        System.out.println(TreeHeight(root));
        System.out.println(NodesCount(root));
        System.out.println(NodesSum(root));

        }
    
}
