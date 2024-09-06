class Solution {
    public int jump(int[] nums) {
        int maxReach = 0;
        int ans = 0;
        int jumpCur = 0;
        if(nums.length == 1){
            return 0;
        }

        for(int i = 0; i < nums.length; i++){
            maxReach = Math.max(maxReach, i + nums[i]);

            if(i == jumpCur){
                ans++;
                jumpCur = maxReach;
                if(maxReach >= nums.length - 1){
                    return ans;
                }
            }
            

        }
        return ans;
        
     }
}


