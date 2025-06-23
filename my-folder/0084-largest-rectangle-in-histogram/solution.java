
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] pref = new int[n];
        pref[0] = -1;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j = pref[j];
            }

            pref[i] = j;
        }

        int[] suf = new int[n];
        suf[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n && heights[j] >= heights[i]) {
                j = suf[j];
            }

            suf[i] = j;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int area = heights[i] * (suf[i] - pref[i] - 1);
            max = Math.max(max, area);
        }

        return max;
    }
}
