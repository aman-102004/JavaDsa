import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

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


    static class information{
        Node node;
        int hd;

        public information(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }

    public static void topview(Node root){
        //level order traversal first
        Queue<information> q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();
        int min=0,max=0;
        q.add(new information(root,0));
        q.add(null);

        while(!q.isEmpty()){
            information curr=q.remove();

            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){;//true if contains key in map
                //first time if distance does not occur add it
                map.put(curr.hd,curr.node);
            }

            if(curr.node.left!=null){
                q.add(new information(curr.node.left, curr.hd-1));
                min=Math.min(min,curr.hd-1);
            }

            if(curr.node.right!=null){
                q.add(new information(curr.node.right, curr.hd+1));
                max=Math.max(max,curr.hd+1);
            }

            }

            
        }


        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }


    }


    public static void kthlevel(Node root,int level,int k){
        //using preorder traversal fot this
        if(root==null){
            return;
        }
        
        if(level==k){
            System.out.print(root.data+" ");
            return;
        }

        kthlevel(root.left,level+1,k);
        kthlevel(root.right,level+1,k);

    }

    public static boolean getPath(Node root,int n,ArrayList<Node> path){
        if(root==null){
            return false;
        }
        
        path.add(root);
        if(root.data==n){
            return true;
        }
        boolean foundLeft=getPath(root.left, n, path);
        boolean foundRight=getPath(root.right, n, path);

        if(foundLeft||foundRight){
            return true;
        }

        path.remove(path.size()-1);

        return false;

    }

    

    public static Node lowestCommonAncestor(Node root,int n1,int n2){
        ArrayList<Node> path1=new ArrayList<>();
        ArrayList<Node> path2=new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

        //lca find
        int i=0;
        for(;i<path1.size()&& i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }

        Node lca=path1.get(i-1);

        return lca;
    }

    public static Node lca(Node root,int n1,int n2){
        
        //concept is this that lca must exist ina ny of the subtrees of the root if it not so then then root is the lca
        
        if(root==null || root.data==n1 || root.data == n2){
            return root;
        }
        Node leftlca=lca(root.left,n1,n2);
        Node rightlca=lca(root.right,n1,n2);

        //leftLCA=valid rightLca=null
        if(rightlca==null){
            return leftlca;
        }
        if(leftlca==null){
            return rightlca;
        }

        return root;

    }

    public static int lcaDis(Node root,int n){
        if(root==null){
            return -1;

        }

        if(root.data==n){
            return 0;
        }
        int leftDist=lcaDis(root.left, n);
        int rightDist=lcaDis(root.right, n);

        if(leftDist ==-1 && rightDist ==-1){
            return -1;
        }
        else if(leftDist==-1){
            return rightDist+1;
        }
        else{
            return leftDist+1;
        }

    }


    public static int minDistancebwNodes(Node root,int n1,int n2){
        Node lca=lca(root, n1, n2);

        int dist1=lcaDis(lca,n1);
        int dist2=lcaDis(lca,n2);

        return dist1+dist2;
        
    }

    public static int KthIncestor(Node root,int n,int k){
        if(root==null){
            return -1;
        }
        
        if(root.data==n){
            return 0;
        }

        int leftDis=KthIncestor(root.left, n, k);
        int rightDis=KthIncestor(root.right, n, k);

        if(leftDis==-1 && rightDis==-1){
            return -1;
        }

        int max=Math.max(leftDis,rightDis);

        if(max+1==k){
            System.out.println(root.data);
        }

        return max+1;


    }

    public static int SumTree(Node root){
        if(root==null){
            return 0;
        }
       
        int leftsum=SumTree(root.left);
        int rightsum=SumTree(root.right);

        int newleft=root.left==null ? 0 :root.left.data;
        int newright=root.right==null ? 0 :root.right.data;

        int data=root.data;
        root.data=newleft+leftsum+newright+rightsum;
        return data ;

    }

    public static void preorder(Node root){
        if(root==null){
            return ;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
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
        // Node subtree=new Node(2);
        // subtree.left=new Node(4);
        // // subtree.right=new Node(5);


        // System.out.println(isSubtree(root, subtree));

        // topview(root);

        // kthlevel(root, 1, 3);

        // int n1=4,n2=5;

        // System.out.println(lowestCommonAncestor(root, n1, n2).data);

        // int n1=4, n2=7;
        // System.out.println(lca(root, n1, n2).data);

        // int n1=4, n2=7;

        // System.out.println(minDistancebwNodes(root, n1, n2));

        // int n=4,k=2;
        // KthIncestor(root, n, k);

        SumTree(root);
        preorder(root);

        }
    
}
