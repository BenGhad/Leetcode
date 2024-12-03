class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        int[] r = new int[26];
        int[] m = new int[26];
        for(int i = 0; i < ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            r[c - 'a']++;
        }
        for(int i = 0; i < magazine.length(); i++){
            char c = magazine.charAt(i);
            m[c - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(r[i] > m[i]) return false;
        }
        return true;
        

    }
}
