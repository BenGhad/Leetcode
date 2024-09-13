class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int dist = r - l;
        int max = dist * Math.min(height[l], height[r]);

        while(l < r){
            dist = r - l;
            int area = dist * Math.min(height[l], height[r]);
            max = Math.max(max, area);
            if(height[l] < height[r]){
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
