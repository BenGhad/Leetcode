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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key > root.val){
            root.right = deleteNode(root.right, key);
        } else if(key < root.val){
            root.left = deleteNode(root.left, key);
        } else if(root.left != null && root.right != null){
            //Find smallest x > root
            // root is that x
            // delete old x
            TreeNode crnt = root.right;
            while(crnt.left != null){
                crnt = crnt.left;
            }
            root.val = crnt.val;
            root.right = deleteNode(root.right, root.val);
        } else if(root.left == null) {
            root = root.right;
        } else {
            root = root.left;
        }
        return root;
    }
}
