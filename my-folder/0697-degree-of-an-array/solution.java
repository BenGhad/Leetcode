class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>(); //0 count 1 start 2 end
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            if(map.containsKey(n)){
                map.get(n)[0]++;
                map.get(n)[2] = i;
                max = Math.max(max, map.get(n)[0]);
            } else {
                map.put(n, new Integer[]{1, i, i});
            }
        }
        if(max == 0) return 1;

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            if(map.get(n)[0] == max){
                ans = Math.min(ans, map.get(n)[2] - map.get(n)[1] + 1);
            }
        }

        return ans;
    }
}
