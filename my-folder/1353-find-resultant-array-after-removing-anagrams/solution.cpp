class Solution {
public:
    bool isAnagram(const string &a, const string &b) {
        if(a.size() != b.size()) return false;
        vector<int> freq(26);
        for(char c : a){
            freq[c - 'a']++;
        }

        for(char c : b){
            freq[c - 'a']--;
            if(freq[c - 'a'] < 0) return false; 
        }

        return true;
    }
    vector<string> removeAnagrams(vector<string>& words) {
        vector<string> ans;
        
        for(const string& s : words){
            if(ans.empty() || !isAnagram(s, ans.back())){
                ans.push_back(s);
            }
        }

        return ans;
    }
};
