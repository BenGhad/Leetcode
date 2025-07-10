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
class BSTIterator {
    List<TreeNode> ost;
    int idx;

    public BSTIterator(TreeNode root) {
        idx = 0;
        ost = inorder(root);
    }

    public int next() {
        return ost.get(idx++).val;
    }

    public boolean hasNext() {
        return idx != ost.size();
    }

    public ArrayList<TreeNode> inorder(TreeNode node) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        if (node == null)
            return ans;

        ans.addAll(inorder(node.left));

        ans.add(node);

        ans.addAll(inorder(node.right));

        return ans;
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
