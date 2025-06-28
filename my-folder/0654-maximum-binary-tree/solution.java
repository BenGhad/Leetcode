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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    public TreeNode helper(int[] nums, int l, int r){
        if(l > r) return null;
        int idx = l;
        for(int i = l; i <= r; i++){
            if(nums[idx] < nums[i]) idx = i;
        }
        TreeNode root = new TreeNode(nums[idx]);
        root.left = helper(nums, l, idx - 1);
        root.right = helper(nums, idx + 1, r);
        
        return root;
    }
}
