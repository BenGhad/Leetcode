class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for(int i : nums){
            sum += i;
            int mod = sum % k;
            if(mod < 0) mod += k;

            if(map.containsKey(mod)){
                ans += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);

        }

        return ans;
    }
}
