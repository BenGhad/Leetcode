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
    List<TreeNode> traversal;
    public void recoverTree(TreeNode root) {
        traversal = inOrder(root);
        List<TreeNode> sussies = new ArrayList<>();

        for (int i = 0; i < traversal.size() - 1; i++) {
            TreeNode curr = traversal.get(i);
            TreeNode next = traversal.get(i + 1);
            if (curr.val > next.val) {
                if (sussies.isEmpty()) {
                    sussies.add(curr);
                    sussies.add(next);
                } else {
                    sussies.set(1, next);
                    break;
                }
            }
        
        }
        TreeNode MANGO = sussies.get(0);
        TreeNode MASSIVE = sussies.get(1);
        int MUSTARD = MANGO.val;
        MANGO.val = MASSIVE.val;
        MASSIVE.val = MUSTARD;
        
    }
    
    List<TreeNode> inOrder(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<TreeNode> ans = new ArrayList<>();
        ans.addAll(inOrder(root.left));
        ans.add(root);
        ans.addAll(inOrder(root.right));

        return ans;
    }
}
