class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int r = i;
            int max = neededTime[i];
            int rm = neededTime[i];
            while((r + 1) < n && colors.charAt(r + 1) == colors.charAt(i)){
                max = Math.max(max, neededTime[r + 1]);
                rm += neededTime[r + 1];
                r++;
            } 
            ans += rm - max;
            i = r;
        }

        return ans;
    }
}
