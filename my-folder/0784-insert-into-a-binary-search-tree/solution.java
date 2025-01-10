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
        TreeNode node = root;
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }
        
        while(true){
            if(val > node.val){
                if(node.right == null){
                    node.right = new TreeNode(val);
                    return root;
                } else {
                    node = node.right;
                    continue;
                }
            }
            
            if(node.left == null){
                node.left = new TreeNode(val);
                return root;
            } else {
                node = node.left;
                continue;
            }
        }
        
        

    }
}
