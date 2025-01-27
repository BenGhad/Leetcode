class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]) continue;
            int add = nums[i - 1] - nums[i] + 1;
            ans += add;
            nums[i] += add;
        }
        return ans;
    }
}
