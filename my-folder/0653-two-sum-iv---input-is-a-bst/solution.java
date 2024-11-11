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
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){return false;}
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            if(t == null){continue;}
            if(hash.containsKey(k - t.val)){
                return true;
            }
            
            if(!hash.containsKey(t.val)){
                hash.put(t.val, 1);
            }
            if(t.left != null){
                q.add(t.left);
            }   
            if(t.right != null){
                q.add(t.right);
            }
        }
        
        
        
        
        
        
        
        return false;
    }
}
