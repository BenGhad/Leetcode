class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        /*
        My 300th problem on this hellsite.
        This question sucks btw
        */
        int n = nums.length;
        int[][] map = new int[n][2];
        for(int i = 0; i < n; i++){
            map[i][0] = i;
            map[i][1] = nums[i];
        }

        Arrays.sort(map, (x, y) -> Integer.compare(y[1], x[1]));
        Arrays.sort(map, 0, k, (x, y) -> Integer.compare(x[0], y[0]));
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = map[i][1];
        }

        

        return ans;
    }
}
