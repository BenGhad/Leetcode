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
    int mode = -1;
    int size = -1;
    int max = -1;
    List<Integer> modes;
    public int[] findMode(TreeNode root) {
        modes = new ArrayList<>();
        inorder(root);
        int[] ans = new int[modes.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = modes.get(i);
        }
        return ans;
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(mode != root.val){
            mode = root.val;
            size = 1;
        } else {
            size++;
        }
        if(size > max){
            max = size;
            modes = new ArrayList<>();   
            modes.add(mode);
        } else if(size == max){
            modes.add(mode);
        }
        inorder(root.right);
        
    }
}
