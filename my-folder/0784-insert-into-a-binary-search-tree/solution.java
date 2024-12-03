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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode v = new TreeNode(val);
        if(root == null) return v;
        TreeNode r = root;
        while(root != null){
            if(val > root.val && root.right == null){
                root.right = v;
                return r;
            } else if(val < root.val && root.left == null){
                root.left = v;
                return r;
            } 
            if(val > root.val){
                root = root.right;
            } else if(val < root.val){
                root = root.left;
            }
        }
        return r;
    }
}
