class Solution {
    public int maxSumDivThree(int[] shipments) {
        int NEG = -1;
        int[] dp = new int[]{0, NEG, NEG, NEG};

        for (int x : shipments) {
            int[] next = dp.clone();
            for (int r = 0; r < 3; r++) {
                if (dp[r] == NEG) continue;
                int nr = (r + x) % 3;
                next[nr] = Math.max(next[nr], dp[r] + x);
            }
            dp = next;
        }

        return dp[0];
    }
}
