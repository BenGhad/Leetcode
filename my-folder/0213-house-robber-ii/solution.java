class Solution {
    public int rob(int[] nums) {
        return Math.max(rob(nums, 0), rob(nums, 1));
    }

    public int rob(int[] nums, int i){
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int rob = nums[i];
        int no = 0;
        for(int j = i + 1; j < nums.length - 1 + i; j++){
            int tmp = rob;
            rob = Math.max(rob, no + nums[j]);
            no = tmp;
        }

        return rob;
    }

}
