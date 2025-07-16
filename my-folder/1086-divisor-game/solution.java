class Solution {
    public boolean divisorGame(int n) {
        // n == 1: lose, n == 2: win, n == 3: lose
        // also you can just sub 1 
        return n % 2 == 0;
    }
}
