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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : to_delete){
            set.add(i);
        }
        
        if(!set.contains(root.val)) list.add(root);
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
            
            if(set.contains(node.val)){
                if(node.left != null && !set.contains(node.left.val)) list.add(node.left);
                if(node.right != null && !set.contains(node.right.val)) list.add(node.right);
            }
        }
        
        
        for(TreeNode n : list){
            queue.offer(n);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.left != null){
                if(set.contains(node.left.val)){
                    node.left = null;
                } else {
                    queue.offer(node.left);
                }
            }
            
            if(node.right != null){
                if(set.contains(node.right.val)){
                    node.right = null;
                } else {
                    queue.offer(node.right);
                }
            }
            }
        }
        
        
    
        
        return list;
    }
}
