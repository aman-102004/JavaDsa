import java.util.*;
public class BinarySearchTree {
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

    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;

        }
        if(root.data>val){
            //left subtree
            root.left=insert(root.left,val);
        }else{
            //right subtree;
            root.right=insert(root.right, val);
        }
        return root;

    }

    public static void inorder(Node root){//left root right
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
    }

    public static boolean Search(Node root,int key){
        if(root==null){
            return false;
        }
        
        if(root.data==key){
            return true;
        }

        
        if(root.data>key){
            return Search(root.left,key);
        }else{
            return Search(root.right,key);
        }


    }

    public static Node delete(Node root,int val){
        if(root.data<val){
            root.right=delete(root.right, val);

        }
        else if(root.data>val){
            root.left=delete(root.left, val);
        }
        else{
            //case 1-left node

            if(root.left==null && root.right==null){
                return null;
            }

            //case 2-single child
            if(root.left==null){
                return root.right;
            }

            if(root.right==null){
                return root.left;
            }

            //case 3-both children
            Node IS=findInorderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right,IS.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }

        return root;
    }
    public static void printInRange(Node root,int k1,int k2){
        if(root==null){
            return;
        }
        
        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }

        else if(root.data<k1){
            printInRange(root.right, k1, k2);
        }else{
            printInRange(root.left, k1, k2);
        }
    }
    public static void printpath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }
    public static void printRoot2leaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            printpath(path);
        }
       
        printRoot2leaf(root.left, path);
        printRoot2leaf(root.right,path);
        path.remove(path.size()-1);

    }

    public static boolean isValidBST(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        if(max!=null && root.data>=max.data){
            return false;
        }

        return isValidBST(root.left, min, root)&& isValidBST(root.right, root, max);


    }

    public static Node MirrorBST(Node root){
        if(root==null){
            return null;
        }
        Node lefts=MirrorBST(root.left);
        Node rights=MirrorBST(root.right);

        root.left=rights;
        root.right=lefts;
        
        return root;



    }


    public static void preorder(Node root){
            if(root==null){
                // System.out.print(-1+" ");
                return;
            }
            
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);

        }
    
    public static Node createBST(int arr[],int st,int end){
       
        if(st>end){
            return null;

        }
       
        int mid=(st+end)/2;
        Node root=new Node(arr[mid]);
        root.left=createBST(arr, st, mid-1);
        root.right=createBST(arr,mid+1, end);

        return root;
    }

    public static Node createBST(ArrayList<Integer> inorder,int st,int end){
       
        if(st>end){
            return null;

        }
       
        int mid=(st+end)/2;
        Node root=new Node(inorder.get(mid));
        root.left=createBST(inorder, st, mid-1);
        root.right=createBST(inorder,mid+1, end);

        return root;
    }

    public static void getInorder(Node root,ArrayList<Integer> inorder){
        if(root==null){
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }
    public static Node balancedBST(Node root){//O(n)
        //inorder seq
        ArrayList<Integer> inorder=new ArrayList<>();
        getInorder(root,inorder);


        //creation of bst from it
        root=createBST(inorder, 0, inorder.size()-1);

        return root;


    }

    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }

    }
        public static int maxBST=0;
        public static Info largestBST(Node root){

            if(root==null){
                return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
            }

            Info leftinfo=largestBST(root.left);
            Info rightinfo=largestBST(root.right);

            int size=leftinfo.size + rightinfo.size + 1;
            int min=Math.min(root.data,Math.min(leftinfo.min , rightinfo.min));
            int max=Math.max(root.data,Math.max(leftinfo.max,rightinfo.max));

            if(root.data <=leftinfo.max || root.data>=rightinfo.min){
                return new Info(false,size,min,max);

            }

            if(leftinfo.isBST && rightinfo.isBST){
                maxBST=Math.max(maxBST,size);
                return new Info(true,size,min,max);
            }

            return new Info(false,size,min,max);


        }

      public static int sumInRange(Node root, int l, int r) {
            if(root == null) {
                return 0;
            }

            if(root.data < l) {
                return sumInRange(root.right, l, r);
            }

            if(root.data > r) {
                return sumInRange(root.left, l, r);
            }

            return root.data
                + sumInRange(root.left, l, r)
                + sumInRange(root.right, l, r);
        }


    public static void main(String[] args) {
        // int values[]={8,5,3,1,4,6,10,11,14};
        // Node root=null;

        // for(int i=0;i<values.length;i++){
        //     root=insert(root,values[i]);
        // }

        // inorder(root);

        // System.out.println();
        // System.out.println(Search(root, 8));

        // // delete(root, 1);
        // // inorder(root);

        // printInRange(root, 5, 10);
        // System.out.println();

        // printRoot2leaf(root,new ArrayList<>());

        // System.out.println(isValidBST(root, null, null));

        // MirrorBST(root);
        // preorder(root);

        // int arr[]={3,5,6,8,10,11,12};

        // Node root=createBST(arr, 0, arr.length-1);

        // preorder(root);
        


        //binary search tree to balanced binary search tree
                //     8
                //    / \
                //    6  10
                //   /    \
                //  5      11
                // /        \
                // 3         12


        // Node root=new Node(8);
        // root.left=new Node(6);
        // root.left.left=new Node(5);
        // root.left.left.left=new Node(3);

        // root.right=new Node(10);
        // root.right.right=new Node(11);
        // root.right.right.right=new Node(12);

        // // expected outcome

        //         //     8
        //         //    / \
        //         //   5   11
        //         //  / \   / \ 
        //         // 3   6 10  12
    
        // root= balancedBST(root);
        // preorder(root);
        

        //size of largest BST in a tree

        //                50
        //         //    / \
        //         //   30   60
        //         //  / \   / \ 
        //         // 5   20 45  70
        //                        /\
        //                       65 80                              




        // Node root=new Node(50);
        // root.left=new Node(30);
        // root.left.left=new Node(5);
        // root.left.right=new Node(20);

        // root.right=new Node(60);
        // root.right.left=new Node(45);
        // root.right.right=new Node(70);
        // root.right.right.left=new Node(65);
        // root.right.right.right= new Node (80);


        // Info info=largestBST(root);

        // System.out.println(maxBST);


        Node root=new Node(8);
        root.left=new Node(5);
        root.left.left=new Node(3);
        root.left.right=new Node(6);

        root.right=new Node(11);
        
        root.right.right=new Node(20);

        System.out.println(sumInRange(root, 5, 11));
      


    
    }
    
}
