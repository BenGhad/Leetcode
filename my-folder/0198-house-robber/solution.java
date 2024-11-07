class Solution {
    public int rob(int[] nums) {
        int rob = nums[0];
        int no = 0;
        for(int i = 1; i < nums.length; i++){
            int tmp = rob;
            rob = Math.max(no + nums[i], rob);
            no = tmp; 
        }
        return Math.max(rob, no);
    }
}
