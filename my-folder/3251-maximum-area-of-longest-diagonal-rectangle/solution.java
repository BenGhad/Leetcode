class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int diag = 0;
        int area = 0;
        for(int[] rect : dimensions){
            int x = rect[0];
            int y = rect[1];
            int cand = x * x + y * y;
            if(cand > diag){
                diag = cand;
                area = x * y;
            } else if (cand == diag){
                area = Math.max(area, x * y);
            }
        }
        return area;
    }
}
