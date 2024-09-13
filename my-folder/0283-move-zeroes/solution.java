class Solution {
    public void moveZeroes(int[] nums) {
        int nonZero = 0;
        int zIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
              nums[zIndex] = nums[i];
              zIndex++;
            }
        }
        for(int i = zIndex; i < nums.length; i++){
            nums[i] = 0;
        }
        
    }
}
