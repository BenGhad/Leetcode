class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j = bSearch(numbers, target - numbers[i], i);
            if (j != -1) {
                return new int[] { i + 1, j + 1 };
            }
        }
        return new int[] { -1, -1 };
    }

    public int bSearch(int[] nums, int t, int i) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == t) {
                if (i == m) {
                    l++;
                } else {
                    return m;
                }

            } else if (nums[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
