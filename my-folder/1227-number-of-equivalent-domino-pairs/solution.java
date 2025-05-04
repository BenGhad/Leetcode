class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int pairs = 0;
        int[][] dom = new int[10][10];
        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];
            if (dom[a][b] > 0) {
                pairs += dom[a][b];
            }

            dom[a][b]++;
            if (a != b)
                dom[b][a]++;
        }

        return pairs;
    }

}
