class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 1){return dividend;}
        long div = Math.abs((long) dividend);
        long or = Math.abs((long) divisor);
        long res = 0;

        if(dividend == Integer.MIN_VALUE && divisor == -1){return 2147483647;}
        
        if(dividend == 0){return 0;}

        boolean sign = (dividend < 0) ^ (divisor < 0);

        long ans = (long) (Math.exp(Math.log(div) - Math.log(or)) + 0.0000000001);

        int op = (int) ans;
        return (sign) ? -op : op;
        
    }
}
