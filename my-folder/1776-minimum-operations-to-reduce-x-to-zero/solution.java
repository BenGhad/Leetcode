class Solution {
    public int minOperations(int[] nums, int x) {
        // See this ts? It's just a max subarray problem
        int target = -x;
        for(int num : nums){
            target += num;
        }
        if(target < 0) return -1;
        
       
        int sum = 0;
        int l = 0;
        int size = -1;

        for(int r = 0; r < nums.length; r++){
            sum += nums[r];
            while(sum > target && l <= r){
                sum -= nums[l++];
            }
            if(sum == target){
                size = Math.max(size, r - l + 1);
            }
        }
        
        return (size == -1) ? -1 : nums.length - size;
    }
}
