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
    Map<String, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return recurse(1, n);
    }

    public List<TreeNode> recurse(int start, int end){
        String key = "" + start + "," + end;
        if(map.containsKey(key)) return map.get(key);

        List<TreeNode> ans = new ArrayList<>();
        if(start > end) {
            ans.add(null);
            map.put(key, ans);
            return ans;
        }

        for(int i = start; i <= end; i++){
            List<TreeNode> left = recurse(start, i - 1);
            List<TreeNode> right = recurse(i + 1, end);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    ans.add(node);
                }
            }
        }
        map.put(key, ans);
        return ans;
    }
}
