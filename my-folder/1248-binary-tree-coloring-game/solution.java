/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // BFS to find X + nonX subtree:
        
        int count = 0; // pick parent of X:
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode xNode = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == x) {
                xNode = node;
                break;
            }
            count++;
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        queue = new LinkedList<TreeNode>();
        int countL = 0;
        if (xNode.left != null) {
            queue.offer(xNode.left);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                countL++;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

        }
        int countR = 0;
        if (xNode.right != null) {
            queue.offer(xNode.right);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                countR++;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

        }
        count = n - countL - countR - 1;
        int[] ans = new int[]{countL, countR, count};
        System.out.println("countL: " + countL);
        System.out.println("CountR: " + countR);
        System.out.println("count: " + count);
        Arrays.sort(ans);
        return ans[2] > (ans[1] + ans[0] + 1);

    }
}
