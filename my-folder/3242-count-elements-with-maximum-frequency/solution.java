class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        for(int i : nums) freq[i]++;
        int size = 0;
        int f = 0;
        for(int i = 0; i < 101; i++){
            if(freq[i] > f){
                size = 1;
                f = freq[i];
            } else if(freq[i] == f){
                size += 1;
            }
        }
        return size * f;
    }
}
