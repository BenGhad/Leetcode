class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int sum = 0;
        int i = 0;
        int j = 1;
        int ans = 0;
        Arrays.sort(banned);
        while(j <= n && sum < maxSum){
            if(i < banned.length && banned[i] == j){
                i++;
                while(i < banned.length && banned[i] == banned[i - 1]){
                    i++;
                }
            } else {
                if(sum + j <= maxSum){
                    ans++;
                    sum += j;
                } else {
                    return ans;
                }
            }
            j++;
        }

        return ans;
    }
}
