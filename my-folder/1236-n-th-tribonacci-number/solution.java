class Solution {
    public int tribonacci(int n) {
        if(n < 2) return n;
        if(n == 2) return 1;
        int first = 0;
        int second = 1;
        int third = 1;
        int trib = first + second + third;
        for(int i = 3; i < n; i++){
            first = second;
            second = third;
            third = trib;
            trib = first + second + third;
        }
        return trib;
    }
}
