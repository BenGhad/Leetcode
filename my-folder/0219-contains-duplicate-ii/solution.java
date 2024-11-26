class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for(int i = 0; i <= k && i < nums.length; i++){
            if(hash.containsKey(nums[i])) return true;
            hash.put(nums[i], 69);
        }

        for(int i = k + 1; i < nums.length; i++){
            hash.remove(nums[i - k - 1]);
            if(hash.containsKey(nums[i])) return true;
            hash.put(nums[i], 69);
        }
        return false;
    }
}
