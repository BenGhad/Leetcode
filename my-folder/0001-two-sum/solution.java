class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashy = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            hashy.put(nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++){
            int find = target - nums[i];
            if(hashy.containsKey(find) && hashy.get(find) != i){
                return new int[]{i, hashy.get(find)};
            }
        }
        return new int[0];
    }
}
