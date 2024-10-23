class Solution {
    public String losingPlayer(int x, int y) {
        int rounds = Math.min(x, y / 4);
        return (rounds % 2 == 0) ? "Bob" : "Alice";
    }
}
