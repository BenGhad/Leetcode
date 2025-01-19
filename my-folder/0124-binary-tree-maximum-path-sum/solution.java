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
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxSum(root);
        return max;
    }
    public int maxSum(TreeNode node){
        if(node == null) return 0;
        int l = Math.max(maxSum(node.left), 0);
        int r = Math.max(maxSum(node.right), 0);

        int current = node.val + l + r;
        max = Math.max(max, current);
        return node.val + Math.max(l, r);

    }
}
