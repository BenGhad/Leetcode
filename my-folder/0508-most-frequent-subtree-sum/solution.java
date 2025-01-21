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
    Map<Integer, Integer> map; 
    int max;    
    int maxFreq;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        max = 0;
        maxFreq = 0;
        findSums(root);
        
        int[] ans = new int[max];
        int ptr = 0;
        for(int i : map.keySet()){
            if(map.get(i) == maxFreq){
                ans[ptr++] = i;
            }
        }
        return ans;
    }

    public int findSums(TreeNode root){
        if(root == null) return 0;
        int sum = root.val + findSums(root.left) + findSums(root.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        if(map.get(sum) > maxFreq){
            max = 1;
            maxFreq = map.get(sum);
        } else if(map.get(sum) == maxFreq){
            max++;
        }
        return sum;
    }
}
