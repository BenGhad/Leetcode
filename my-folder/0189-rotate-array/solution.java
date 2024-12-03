class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] ans = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            int val = ((i - k) + nums.length) % nums.length;
            ans[i] = nums[val];
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = ans[i];
        }
    }
}
