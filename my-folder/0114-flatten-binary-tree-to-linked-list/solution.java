/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        //O(n): Do traversal & create new tree
        //O(h): Keep pointer to each right child before recurse
        //O(1): idk
        if(root == null) return;
        flat(root);
    }
    // Returns {root, leaf}
    public TreeNode[] flat(TreeNode root){
        TreeNode[] L;
        TreeNode[] R;

        if(root.left == null && root.right == null){
            return new TreeNode[]{root, root};
        }
        
        if(root.left == null){
            R = flat(root.right);
            root.right = R[0];
            return new TreeNode[]{root, R[1]};
            
        } else if(root.right == null){
            L = flat(root.left);
            root.right = L[0];
            root.left = null;
            return new TreeNode[]{root, L[1]};
        } 
        
        L = flat(root.left);
        R = flat(root.right);
        
        root.left = null;
        root.right = L[0];
        L[1].right = R[0];

        return new TreeNode[]{root, R[1]};
    }
}
