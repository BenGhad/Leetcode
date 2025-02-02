class Solution {
    public boolean check(int[] nums) {
        boolean pre = false;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){
                if(pre) return false;
                pre = true;
            }
        }
        if(pre){
            return nums[nums.length - 1] <= nums[0];
        } else {
            return true;
        }
    }
}
