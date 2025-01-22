class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] freq = new int[26];
        int[] freq2 = new int[26];
        for(int i = 0; i < s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            freq[cs - 'a']++;
            freq2[ct - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(freq[i] != freq2[i]) return false;
        }
        return true;
    }
}
