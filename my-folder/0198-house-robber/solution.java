class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){return nums[0];}
        int first = 0;
        int second = nums[0];
        boolean prev = true;

        for(int i = 1; i < nums.length; i++){
            if(!prev){
                first = second;
                second = second + nums[i];
                prev = true;
                continue; 
            }
            int tmp = first;
            first = second;
            second = Math.max(second, tmp + nums[i]);
            prev = !(first == second);
        }
        return Math.max(first, second);
    }

}
