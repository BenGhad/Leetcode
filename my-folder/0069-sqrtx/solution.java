class Solution {
    public int mySqrt(int x) {
    /**    if(x == 0 || x == 1){return x;}

        int low = 1, high = x, ans = -1;
        while(low <= high){
            int i = low + (high - low) / 2;
            if(i <= x / i){
                low = i + 1;
                ans = i;
            } else {
                high = i - 1;
            }
        }
        return ans;
    }
    */
        return (int)Math.sqrt(x);
    }
}
