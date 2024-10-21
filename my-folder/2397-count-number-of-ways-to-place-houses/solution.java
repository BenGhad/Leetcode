class Solution {
    public int countHousePlacements(int n) {
        int mod = 1000000007;
        int[] p = new int[n + 1];
        p[0] = 1;
        p[1] = 2;
        for(int i  = 2; i < p.length; i++){
            p[i] = (p[i - 1] + p[i -2]) % mod;
        }
        long result = (long)p[n] * p[n] % mod;
        return (int) result;
    }
}
