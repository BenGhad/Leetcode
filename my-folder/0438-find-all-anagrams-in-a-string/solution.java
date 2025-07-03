class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        
        if(s.length() < p.length()) return ans;

        int[] freq = new int[26];
        for(int i = 0; i < p.length(); i++){
            freq[p.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']--;
            if(i >= p.length()) freq[s.charAt(i - p.length()) - 'a']++;
            
            if(valid(freq)) ans.add(i - p.length() + 1);
        }
        return ans;

    }
    public boolean valid(int[] freq){
        for(int i : freq){
            if(i != 0) return false;
        }
        return true;
    }
}
