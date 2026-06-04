import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
public class BinaryTress {
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

    static class BinaryTree{
        static int idx=-1;
        //building tree using preorder;root left right
        public static Node buildtree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                
                return null;
            }

            Node newNode=new Node(nodes[idx]);
            newNode.left=buildtree(nodes);
            newNode.right=buildtree(nodes);

            return newNode;
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

        public static void inorder(Node root){//left root right
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        public static void postorder(Node root){//left right root
            if(root==null){
                return;
            }
            postorder(root.left);
            
            postorder(root.right);

            System.out.print(root.data+" ");

        }

        public static void levelOrder(Node root){
            if(root==null){
                return;
            }

            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currnode=q.remove();

                if(currnode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{

                        q.add(null);
                    }
                }else{
                    System.out.print(currnode.data+" ");
                    if(currnode.left!=null){
                        q.add(currnode.left);
                    }

                    if(currnode.right!=null){
                        q.add(currnode.right);
                    }
                }
            }



        }


       

    }


    
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree =new BinaryTree();
        Node root=tree.buildtree(nodes);
        // System.out.println(root.data);

        System.out.println("Preorder:");
        tree.preorder(root);
        System.out.println();
        System.out.println("Inorder:");
        tree.inorder(root);
        System.out.println();
        System.out.println("Postorder:");
        tree.postorder(root);

        System.out.println();
        System.out.println("LevelOrder");
        tree.levelOrder(root);

    }
    
}
