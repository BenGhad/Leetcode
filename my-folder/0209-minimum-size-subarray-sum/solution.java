class Solution {
    public int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    int l = 0, sum = 0, ans = n + 1;

    for (int r = 0; r < n; r++) {
        sum += nums[r];
        while (sum >= target) {
            ans = Math.min(ans, r - l + 1);
            sum -= nums[l++];
        }
    }

    return (ans <= n) ? ans : 0;
}

}
