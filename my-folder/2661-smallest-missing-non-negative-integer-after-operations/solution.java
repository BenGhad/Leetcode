class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] freq = new int[value];
        for(int i : nums) {
            freq[((i % value) + value) % value]++;
        }
        int min = Integer.MAX_VALUE;
        for(int i  = 0; i < value; i++){
            min = Math.min(min, value * freq[i] + i);
        }
        return min;
    }
}
