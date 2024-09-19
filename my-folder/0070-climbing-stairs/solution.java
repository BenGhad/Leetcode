class Solution {
    public int climbStairs(int n) {
        return fib(n);
    }
    public int fib(int n){
        if(n == 0){return n;}
        int a = 0, b = 1, c;
        for(int i = 2; i <= n + 1; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
