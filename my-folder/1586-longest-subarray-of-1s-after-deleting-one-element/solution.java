class Solution {
    public int longestSubarray(int[] nums) {
        int x = 0;
        int y = 0;
        int len = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                len = Math.max(x + y, len);
                x = y;
                y = 0;
            } else {
                y++;
            }
        }
        if(x + y == nums.length){
            return nums.length - 1;
        }
        return Math.max(len, x + y);
    }
}
