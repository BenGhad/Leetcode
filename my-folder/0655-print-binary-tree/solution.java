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
    public List<List<String>> printTree(TreeNode root) {
        int height = height(root);
        int m = height + 1;
        int n = (int)Math.pow(2, height + 1) - 1;
        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < m; i++){
            ans.add(new ArrayList<>());
            for(int j = 0; j < n; j++){
                ans.get(i).add("");            
            }
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<int[]> pos = new LinkedList<>();
        queue.offer(root);
        pos.offer(new int[]{0, (n - 1)/2});
        while(!queue.isEmpty() && !pos.isEmpty()){
            TreeNode t = queue.poll();
            int[] p = pos.poll();
            int x = p[0];
            int y = p[1];
            int change = (int)Math.pow(2, height - x - 1);

            ans.get(x).set(y, String.valueOf(t.val));
            if(t.left != null){
                queue.offer(t.left);
                pos.offer(new int[]{x + 1, y - change});
            }
            if(t.right != null){
                queue.offer(t.right);
                pos.offer(new int[]{x + 1, y + change});
            }
        }

        return ans;
    }

    public int height(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int h = -1;
        while(!queue.isEmpty()){
            h++;
            int size = queue.size();
            while(size-- > 0){
                TreeNode t = queue.poll();
                if(t.left != null) queue.offer(t.left);
                if(t.right != null) queue.offer(t.right);
            }
        }
        return h;
    }
}
