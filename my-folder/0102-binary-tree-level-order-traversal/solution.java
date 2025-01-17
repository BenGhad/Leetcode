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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        queue.offer(root);        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> current = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode tmp = queue.poll();
                current.add(tmp.val);
                if(tmp.left != null) queue.offer(tmp.left);
                if(tmp.right != null) queue.offer(tmp.right);
            }
            list.add(current);
        }

        return list;

    }
}
