class Solution {
    public int pivotIndex(int[] nums) {
        int[] right = new int[nums.length];
        int sum = 0;
        for(int i = nums.length - 1; i >= 0; i --){
            right[i] = sum;
            sum += nums[i];
        }
        sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(right[i] == sum){
                return i;
            }
            sum += nums[i];
            
        }
        return -1;
    }
}
