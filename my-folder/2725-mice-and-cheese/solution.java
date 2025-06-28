class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int sum = 0;
        for(int i = 0; i < reward2.length; i++){
            sum += reward2[i];
            reward1[i] -= reward2[i];
        }
        Arrays.sort(reward1);
        for(int i = 0; i < k; i++){
            sum += reward1[reward1.length - 1 - i];
        }
        return sum;

    }
}
