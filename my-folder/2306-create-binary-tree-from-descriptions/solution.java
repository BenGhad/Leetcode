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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> pars = new HashSet<>();
        for(int[] desc : descriptions){
            int p = desc[0];
            int c = desc[1];
            int isL = desc[2];

            pars.remove(c);
            if(!map.containsKey(p)){
                pars.add(p);
            }

            TreeNode parNode = map.computeIfAbsent(p, n -> new TreeNode(n, null, null));
            TreeNode childNode = map.computeIfAbsent(c, n -> new TreeNode(n, null, null));

            if(isL == 1){
                parNode.left = childNode;
            } else {
                parNode.right = childNode;
            }
        }

        return map.get(pars.iterator().next());
    }
}
