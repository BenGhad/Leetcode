class Solution {
    public int minStartValue(int[] nums) {
        int ans = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            count += nums[i];
            ans = Math.min(count, ans);
        }
        return -1 * ans + 1;
    }
}
