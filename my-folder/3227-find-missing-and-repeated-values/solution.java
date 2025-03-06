class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] nums = new int[(grid.length) * (grid.length)];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int num = grid[i][j];
                nums[num - 1]++;
            }
        }
        int[] ans = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] == 2)
                ans[0] = i;
            if (nums[i - 1] == 0)
                ans[1] = i;
        }
        return ans;

    }
}
