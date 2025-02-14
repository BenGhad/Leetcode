class Solution {
    int[] arr;
    int[] dupe;
    public Solution(int[] nums) {
        arr = new int[nums.length];
        dupe = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[i];
            dupe[i] = nums[i];
        }
    }
    
    public int[] reset() {
        return arr;
    }
    
    public int[] shuffle() {
        int[] ans = new int[arr.length];

        
        for(int i = 0; i < dupe.length; i++){
            int rand = (int)(Math.random() * (dupe.length - i));
            ans[i] = dupe[rand];
            dupe[rand] = dupe[dupe.length - i - 1];
            dupe[dupe.length - i - 1] = ans[i];
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
