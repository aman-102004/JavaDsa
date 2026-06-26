/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       
        if(root==null){
            return "null,";
        }

        return root.val +","+serialize(root.left) + serialize(root.right);
        
    }
    static int idx=-1;
    public static TreeNode buildTree(String arr[]){
        if(arr[idx].equals("null")){
            idx++;
            return null;
        }
        TreeNode newnode=new TreeNode(Integer.parseInt(arr[idx]));
        idx++;
        newnode.left=buildTree(arr);
        newnode.right=buildTree(arr);

        return newnode;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        idx=0;
        String arr[]=data.split(",");
        return buildTree(arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));