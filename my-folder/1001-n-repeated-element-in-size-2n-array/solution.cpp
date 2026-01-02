class Solution {
public:
    int repeatedNTimes(vector<int>& nums) {
        int cout = 0;
        int maj = -1;
        bool first = true;
        for(int num : nums){
            if(first){
                first = false;
                continue;
            }
            if(num == nums[0]) return num;
            if(num == maj){
                cout += 1;
            } else {
                cout -= 1;
                if(cout  < 0){
                    cout = 1;
                    maj = num;
                }
            }
        }
        return maj;
    }
};
