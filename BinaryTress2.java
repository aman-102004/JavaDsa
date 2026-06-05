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


    //Diameter = No of nodes in the longest path bw two leaves
    public static int TreeDiameter2(Node root){
        if(root==null){
            return 0;
        }

        int leftDiam=TreeDiameter2(root.left);
        int rightDiam=TreeDiameter2(root.right);
        int leftht=TreeHeight(root.left);
        int rightht=TreeHeight(root.right);

        int selfDiam=leftht+rightht+1;

        return Math.max(selfDiam,Math.max(leftDiam,rightDiam));

    }

    //Diameter of the Tree Second Approach in which we will calculating height with diam to reduce the time complexity to O(n)
    //here we will be using an info return type to return height and diam altogether
    static class Info{
        int diam;
        int ht;

        public Info(int diam,int ht){
            this.diam=diam;
            this.ht=ht;
        }


    }
    public static Info diameter(Node root){
        if(root==null){
            return new Info(0,0);
        }
        Info leftInfo=diameter(root.left);
        Info rightInfo=diameter(root.right);

        int diam=Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
        int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;

        return new Info(diam,ht);
    }

    public static boolean isIdentical(Node node,Node subtree){
        if(node ==null && subtree==null){
            return true;

        }
        else if(node==null || subtree==null || node.data!=subtree.data){
            return false;
        }

        if(!isIdentical(node.left, subtree.left)){
            return false;
        }

        if(!isIdentical(node.right, subtree.right)){
            return false;
        }

        return true;

    }


    public static boolean isSubtree(Node root,Node subtree){

        if(root==null){
            return false;
        }

        if(root.data==subtree.data){
            if(isIdentical(root,subtree)){
                return true;
            }
        }

        return isSubtree(root.left, subtree) || isSubtree(root.right, subtree);
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

        // System.out.println(TreeHeight(root));
        // System.out.println(NodesCount(root));
        // System.out.println(NodesSum(root));

        // System.out.println(TreeDiameter2(root));
        // System.out.println(diameter(root).diam);

        //        2        
        //        /\       
        //       4  5
        Node subtree=new Node(2);
        subtree.left=new Node(4);
        // subtree.right=new Node(5);


        System.out.println(isSubtree(root, subtree));


        }
    
}
