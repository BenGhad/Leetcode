class Solution {
    public int maxRotateFunction(int[] nums) {
        int cur = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            cur += i * nums[i];
            sum += nums[i];
        }
        int ans = cur;


        for(int i = 1; i < nums.length; i++){
            cur = cur + sum - nums.length * nums[nums.length - i];
            ans = Math.max(ans, cur);
        }

        return ans;
    }
}
