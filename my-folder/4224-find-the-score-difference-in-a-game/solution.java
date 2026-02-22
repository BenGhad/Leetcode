class Solution {
    public int scoreDifference(int[] nums) {
        boolean mode = false;
        int p1 = 0;
        int p2 = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 != 0){
                mode = !mode;
            }
            if((i+1) % 6 == 0){
                mode = !mode;
            }
            if(!mode){
                p1 += nums[i];
            } else {
                p2 += nums[i];
            }
        }
        return p1 - p2;
    }
}
