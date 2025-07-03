class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int ans = 1;
        int count = 1;
        
        int prev = nums[0];
        for(int r = 1; r < nums.length; r++){
            if(nums[r] == prev) continue;

            if(nums[r] - nums[r - 1] == 1){
                count++;
                prev = nums[r];
            } else {
                ans = Math.max(ans, count);
                count = 1;
                if(r < nums.length - 1) prev = nums[r + 1] - 1;
            }
        }
        return Math.max(ans, count);
    }
}
