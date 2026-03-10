class Solution {
    public int minMovesToSeat(int[] posts, int[] units) {
        int n = posts.length;
        Arrays.sort(posts);
        Arrays.sort(units);

        int moves = 0;
        for (int i = 0; i < n; i++) {
            moves += Math.abs(posts[i] - units[i]);
        }

        return moves;
    }
}
