class Solution {
    private int idx(char c) {
        if (c >= 'a' && c <= 'z')
            return c - 'a';
        if (c >= 'A' && c <= 'Z')
            return c - 'A' + 26;
        return -1;
    }

    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[] freq = new int[52];
        int[][] pref = new int[m][52];

        for (int i = 0; i < n; i++) {
            int id = idx(t.charAt(i));
            if (id >= 0)
                freq[id]++;
        }

        pref[0][idx(s.charAt(0))]++;
        for (int i = 1; i < m; i++) {
            pref[i] = Arrays.copyOf(pref[i - 1], 52);
            int id = idx(s.charAt(i));
            if (id >= 0)
                pref[i][id]++;
        }

        int bestL = -1, bestR = m + 1;
        int r = 0;

        for (int l = 0; l < m; l++) {
            while (r < m) {
                boolean valid = true;
                for (int i = 0; i < 52; i++) {
                    int cnt = pref[r][i] - (l > 0 ? pref[l - 1][i] : 0);
                    if (cnt < freq[i]) { // allow extras
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    if (r - l + 1 < bestR - bestL) {
                        bestL = l;
                        bestR = r + 1;
                    }
                    break;
                }
                r++;
            }
            if (r == l)
                r++;
        }

        System.out.println(bestL + " " + bestR);

        return bestL == -1 ? "" : s.substring(bestL, bestR);
    }
}
