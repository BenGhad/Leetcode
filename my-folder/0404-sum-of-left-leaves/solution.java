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
    public int sumOfLeftLeaves(TreeNode root) {
        /*
        if child is leaf: add, otherwise, go crazy type shiii
        */
        int ans = 0;
        
        if(root.left != null){
            if(isLeaf(root.left)){
                ans += root.left.val;
            } else {
                ans += sumOfLeftLeaves(root.left);
            }
        } 
        
        if(root.right != null){
            ans += sumOfLeftLeaves(root.right);    
        }
        
        return ans;
    
        
    }
    
    public boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}
