class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        int n = nums.size();
        sort(nums.begin(), nums.end());

        long long ans = 1;

        long long kC = 0;
        long long l = 0;
        for(long long r = 1; r < n; r++){
            //l -> r-1 += cost if we can be cheap
            kC += (nums[r] - nums[r-1]) * (r-l);
            
            while(kC > k){
                kC -= (nums[r] - nums[l]);
                l++;
            }
            ans = max(ans, r - l + 1);
        }
        return ans;
    }
    
};
