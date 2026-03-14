class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        long long times[60] = {0};
        for (long long t : time) {
            times[t % 60]++;
        }
        int ans = 0;
        for (long long i = 0; i < 60; i++) {
            for (long long j = i+1; j < 60; j++) {
                if ((i + j) % 60 == 0) {
                    ans += times[i] * times[j];
                }
            }
        }
        // 30 on 30, 0 on 0, 
        ans += times[0] * (times[0] - 1) / 2;
        ans += times[30] * (times[30] - 1) / 2;
        
        return ans;
    }
};
