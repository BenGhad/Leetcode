class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for(int i = 0; i < 2 * (n / 2); i+= 2){
            ans[i] = i + 1;
            ans[i + 1] = 0 - (i + 1);
        }   
        if(n % 2 != 0){
            ans[n - 1] = 0;
        }

        return ans;
    }
}
