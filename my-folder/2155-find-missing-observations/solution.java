class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        int[] ans = new int[n];
        for(int i : rolls){
            sum += i;
        }
        sum = mean * (rolls.length + n) - sum;

        int avg = sum / n;
        int leftover = sum - n * avg;
        if(avg > 6 || (avg == 6 && leftover > 0) || avg < 1){
            return new int[0];
        }
        for(int i = 0; i < ans.length; i++){
            ans[i] = avg;
            if(leftover != 0){
                ans[i]++;
                leftover--;
            }
        }
        return ans;
    }

}
