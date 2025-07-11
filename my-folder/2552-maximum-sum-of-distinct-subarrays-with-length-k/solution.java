class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
    long sum = 0;
    long ans;
    HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
    Set<Integer> invalids = new HashSet<>();

    for(int i = 0; i < k; i++){
        hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
        if(hash.get(nums[i]) > 1) invalids.add(nums[i]);
        sum += nums[i];
    }
    ans = invalids.isEmpty() ? sum : 0;


    for(int i = k; i < nums.length; i++){
        int touch = nums[i];
        int rm = nums[i - k];

        sum += touch;
        sum -= rm;
        
        hash.put(rm, hash.get(rm) - 1);
        if(hash.get(rm) == 1) invalids.remove(rm);

        hash.put(touch, hash.getOrDefault(touch, 0) + 1);
        if(hash.get(touch) > 1) invalids.add(touch);

        if(invalids.isEmpty()) ans = Math.max(ans, sum);
    }



    return ans;
    }
}
