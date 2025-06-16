class Solution {
    public int maximumDifference(int[] nums) {
        int low = Integer.MAX_VALUE;
        int ans = -1;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= low){
                low = nums[i];
            } else {
                ans = Math.max(ans, nums[i] - low);
            }
        }


        return ans;
    }
}
