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
class FindElements {
    Set<Integer> set;

    public FindElements(TreeNode root) {
        set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return;
        root.val = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            set.add(node.val);
            if(node.left != null){
                node.left.val = node.val * 2 + 1;
                queue.offer(node.left);
            }
            if(node.right != null){
                node.right.val = node.val*2 + 2;
                queue.offer(node.right);
            }
        }
        
    }
    
    public boolean find(int target) {
        return(set.contains(target));
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
