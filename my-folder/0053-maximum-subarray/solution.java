class Solution {
    public int maxSubArray(int[] nums) {
        int prev = nums[0];
        int max = prev;
        for(int i = 1; i < nums.length; i++){
            if(prev > 0){
                prev += nums[i];
                max = Math.max(max, prev);
            } else {
                prev = nums[i];
                max = Math.max(max, prev);
            }
        }


        return max;
    }
}
