class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return countWays(nums, 0, target);
    }

    public int countWays(int[] nums, int l, int target){
        int ans = 0;
        if(l == nums.length) {
            return target == 0 ? 1 : 0;
        } else {
            ans += countWays(nums, l + 1, target - nums[l]);
            ans += countWays(nums, l + 1, target + nums[l]);
        }
        return ans;
    }
}
