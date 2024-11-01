class Solution {
    public void sortColors(int[] nums) {
        int f = 0;
        int s = 0;
        int t = 0;
        for(int i : nums){
            if(i == 0){
                f++;
            } else if(i == 1){
                s++;
            } else {
                t++;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(f > 0){
                nums[i] = 0;
                f--;
            } else if(s > 0){
                nums[i] = 1;
                s--;
            } else {
                nums[i] = 2;
            }
        }
    }
}
