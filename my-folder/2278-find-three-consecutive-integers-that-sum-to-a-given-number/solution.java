class Solution {
    public long[] sumOfThree(long num) {
        if(num % 3 != 0) return new long[0];
        long ans = num / 3;
        return new long[]{
            ans - 1, ans, ans + 1
        };
    }
}
