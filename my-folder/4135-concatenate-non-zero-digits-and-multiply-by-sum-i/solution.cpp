class Solution {
public:
    long long sumAndMultiply(int n) {
        vector<int> digits;
        long long sum = 0;
        for(; n > 0; n /= 10){
            int dig = n % 10;
            if(dig == 0) continue;
            digits.push_back(dig);
            sum += dig;
        }

        long long ans = 0;

        reverse(digits.begin(), digits.end());

        for(int dig : digits){
            ans = ans * 10 + dig;
        }

        return ans * sum;
    }
};
