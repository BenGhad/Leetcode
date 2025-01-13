class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) return 0;
        int count = 0;
        int tmp = 0;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                tmp++;
                count += tmp;
            } else {
                tmp = 0;
            }
        }

        return count;
    }
}
