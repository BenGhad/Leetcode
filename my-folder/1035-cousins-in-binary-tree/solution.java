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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            boolean foundX = false;
            boolean foundY = false;

            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.val == x) foundX = true;
                if(node.val == y) foundY = true;
                
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);

                if(node.left != null && node.right != null){
                    if(node.left.val == x && node.right.val == y) return false;
                    if(node.right.val == x && node.left.val == y) return false;
                }
            }
            //Check if same depth
            if(foundX && foundY) return true;
            if(foundX ^ foundY) return false;
        }    
        return true;
    }
}
