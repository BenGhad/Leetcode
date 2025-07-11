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
class CBTInserter {
    List<TreeNode> treap;
    public CBTInserter(TreeNode root) {
        treap = treapify(root);
    }
    
    public int insert(int val) {
        int i = treap.size();
        TreeNode node = new TreeNode(val);
        treap.addLast(node);
        

        TreeNode parent = treap.get((i - 1) / 2);

        if(i % 2 == 1){
            parent.left = treap.getLast();
        } else {
            parent.right = treap.getLast();
        }
        return parent.val;
    }
    
    public TreeNode get_root() {
        return treap.get(0);
    }

    List<TreeNode> treapify(TreeNode root){
        List<TreeNode> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            ans.add(node);
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }
        
        
        return ans;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
