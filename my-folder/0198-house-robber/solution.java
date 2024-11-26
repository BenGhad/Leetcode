class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int yes = nums[0];
        int no = 0;

        for(int i = 1; i < nums.length; i++){
            int temp = no;
            no = Math.max(no, yes);
            yes = temp + nums[i];
        }
        return Math.max(yes, no);
    }
}
