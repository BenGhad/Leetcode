class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        // greedy:
        int count = 1;
        int min = nums[0];

        for (int num : nums) {

            if (num - min > k) {
                count++;
                min = num;
            }
        }

        return count;
    }
}
