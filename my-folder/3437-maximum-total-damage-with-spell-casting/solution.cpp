class Solution {
public:
    long long maximumTotalDamage(vector<int>& power) {
        unordered_map<int, long long> freq;
        for (int p : power)
            freq[p]++;
        freq[-1] = 0;
        vector<int> spells;
        for (auto& [k, _] : freq)
            spells.push_back(k);
        sort(spells.begin(), spells.end());
        int n = spells.size();

        vector<long long> dp(n);
        dp[0] = freq[spells[0]] * spells[0];

        for (int i = 1; i < n; i++) {
            long long pow = freq[spells[i]] * spells[i];
            int prev =
                upper_bound(spells.begin(), spells.begin() + i, spells[i] - 3) -
                spells.begin() - 1;

            if (prev >= 0){
                pow += dp[prev];
            }

            dp[i] = max(dp[i - 1], pow);
        }

        return dp[n - 1];
    }
};
