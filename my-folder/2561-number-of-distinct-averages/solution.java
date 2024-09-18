class Solution {
    public int distinctAverages(int[] nums) {
        HashMap<Integer, Integer> hashy = new HashMap<Integer, Integer>();
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length / 2; i++){
            int avg = nums[i] + nums[nums.length - 1 - i];
            if(hashy.getOrDefault(avg, 0) != 1){
                ans++;
                hashy.put(avg, 1);
            }
        }
        return ans;

    }
}
